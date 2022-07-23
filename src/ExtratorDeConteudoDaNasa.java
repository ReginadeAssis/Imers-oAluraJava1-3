
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    //recebe json e retorna list de conteudo metodo é extrai

    public List<Conteudo> extraiConteudos(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
//Cria uma lista de map de string para string ai criou uma
        List<Conteudo> conteudos = new ArrayList<>();

        // popular/ccompletar a lista de conteudos usa o for.Para 
        //cada item da lista chave-valor tem uma string
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
        //Peguei na api o que eu quero title igual mas url diferente
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
            //conteudo recebe o conteudo. A lista no singular os objetos no plural
        }

        return conteudos;
    }

}