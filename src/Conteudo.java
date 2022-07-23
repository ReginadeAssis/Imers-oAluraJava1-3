public class Conteudo {
  /*aqui vc coloca a variavel e o tipo dela titulo-imagem
  o private faz com que só o código dessa classe acesse o atributo.Esses objetos são pequenos. No final ninguém pode mais alterar.A app chama o cliente http, o http fala com a app e ela joga para um dos extratores pq o json pode ser um pouco diferente de um conteúdo para o outro. Dps o extrator que vai chamar o jsonparser. Por fim, a appa chama a geradora de figurinhas.
  Dps de digitar private string para java expor o q vc criou botão direito-> ação de origem-> generate gater. Em seguida cria construtor tbm com o botão direito(para ele receber as infos q precisa).
  
  
  */


  private final String titulo;
  private final String urlImage;

public String getTitulo() {
    return titulo;
}


public String getUrlImage() {
    return urlImage;
}


public Conteudo(String titulo, String urlImage) {
    
    //esse this diz que o meu objeto recebe o titulo de onde //eu busco

    this.titulo = titulo;
    this.urlImage = urlImage;
}

}
