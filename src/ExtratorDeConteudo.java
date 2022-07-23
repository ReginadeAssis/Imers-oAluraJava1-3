import java.util.List;

public interface ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json);

}
//usa a interface do que um objeto deve fazer mas aqui a interface que diz o que ela deve fazer.Sempre pública. Ela é ipc para unir os objetos ai vc diz q classe implementa aquela interface.
//põe no extrator public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    //recebe json e retorna list de conteudo metodo é extrai