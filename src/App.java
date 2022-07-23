/* 
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

Pegar os dados(fazer conexão) http e fazer um gat é necessário guardar os dados da http dentro da string com os tops 250 filmes que buscamos. Em seguida, pega só os dados que vc quer dentro da string(extrair os dados-título,poster e a classificação). A extração é chamada de partiar. Por fim, vamos exibir e manipular os dados da aplicação.

public class App {
    public static void main(String[] args) throws Exception {
        
        1 Conexão: pricisa criar variável com a url do endereço que vc deseja.Por ser uma string vai ficar entre aspas.

        String url = "https://imdb-api.com/en/API/Top250Movies/k_s7xcdj31";

    Para conectar o servidor e buscar os dados vc pode olhar a documentação pq lá tem exemplos:
    URI endereco = URI.create(url);   
    var client = HttpClient.newHttpClient();

    Tem q criar uma uri(tem vários tipos inclusive url-aqui no caso é a identificação do recurso usado)associar a url para poder criar um builder e usar as infos que pegamos para fazer o request.Vc passa o endereço para o new builder.Esse get ou método http é a maneira de buscar os dados de qualquer uri/url de qualquer servidor http
    Caso tenha dúvid pode procurar no google http request java doc que ele traz exemplos. A bodyhandler é a classe que vai criar a maneira de ler os dados.Isso para o send saber que estamos lendo uma string.Dps coloca ela dentro de uma variável.

    var request = HttpRequest.newBuilder(endereco).GET().build();
    var response = client.send(request,BodyHandlers.ofString());
    String body = response.body();
    System.out.println(listaDeFilmes.size());   
        
A segunda parte é catar só o que vc quer dentro dos dados que vc importou tudo acima foi usado para fazer uma conexão.Aqui foi feito com expressões regulares sem as bibliotecas.O java tem uma estrutura associativa que liga uma tributo a um valor do atributo é um dicionário chave-valor e vc põe o tipo. Ele não aceitaria igualar assim e já arrumar os dados por isso vem o código gigante já que não tem biblioteca. O processo passa por criar uma classe que vai retonar os dados ai aperta control shifth e p-creat java class.
var parser = new JsonParser();
List<Map<String, String>> listaDeFilmes = parser.parse(body);
Aqui vc vai pedindo para ele pegar as coisas(sleciona foreach):
for (Map<String,String> filme : listaDeFilmes) {
    System.out.println(filme.get("title"));
    System.out.println(filme.get("image"));
    System.out.println(filme.get("imDbRating"));
    System.out.println();
}


    }
}

Criou a classe geradora de figurinhas para passar as instruções de como criá-las.
*/
/* Segunda rodada

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados para cada filme pela url 
        //A classe de figurinhas vem para cá

        var geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();

            //a linha abaixo diz a pasta
            String nomeArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }
}
*/

import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {


        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            //criou essa classe conteudo para ficar melhor
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}