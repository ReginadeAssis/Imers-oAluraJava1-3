
    //Ela vai receber um parametro string q é uma url q busca dados
    //O primeiro string é o q retorna. O out shifth o importa 
    //A cath é para não ter q ficar listando as exceções-vc só embrulhana runtimeexception.
    import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String buscaDados(String url) {

        try {

            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }

}
