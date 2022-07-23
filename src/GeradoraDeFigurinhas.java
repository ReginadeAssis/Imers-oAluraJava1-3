/*
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {
    

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        O que vc quer aqui é criar uma imagem, o public serve para dizer que vc pode acessar essas infos de qualquer parte do código.Para fazer essas alterações ele salvou a imagem dentro da pasta do projeto.


Dentro do java agr o objetivo é ler, transparência, redimensionar a imagem.A api chama serviço, arruma imagem ...faz mt coisa



        leitura da imagem por fim decidiram passar a url para vc não ter que baixar.Como não consegue criar input scream que é classe abstrata cria nem file.

        InputStream inputStream = 
      new FileInputStream(new File("entradafilme-maior.jpg"));
        // InputStream inputStream = 
        //                 new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg") ela vai exatamente como um texto e lê os dados direto dela.
        //                 .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream); Com buffered image e o input scream cria a imagem.

        // cria nova imagem em memória com transparência e com tamanho novo para pegar ela usa a bufferedImage de dentro do io. A nova altura é uma variável para esticar e vc escrever. Usa o new para ver como vai ficar e joga dentro dele o que ele precisa para fazer a imagem que vc quer e guarda em uma variavel.

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória). A getgrafic 2d busca a imagem força a barra com ele entre parenteses para forçar as variaveis. O drawimage permite que vc desenhe a imagem em uma imagem.não esqueça que vc escreve a antiga na nova por isso é a antiga que vai.O observe fica pq ele pediu mais um argumento ai só para tentar fazer o que ele pediu.

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte. Dps da imagem e antes do texto vc configura a fonte-isso chama setar a fonte.Java awt fonte ele importa forçado.Não esquece de jogar a fonte em uma variável.Por fim, para usar a imagem é só baixar.

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem,aqui vc passa o texto e a posição mais a esquerda e o outro abaixo q é a nova altura intera é a nova altura menos 100 que é quase no fim.

        graphics.drawString("O melhor do mundo", 100, novaAltura - 100);

        // escrever a nova imagem em um arquivo. O que está em cinza tipo format name é só a ide falando o tipo do negócio. 
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

Para testar uma classe vc pode colocar um mainaqui para testar.Não esquece que tem que criar a variável e chamar o método. 
 *public static void main(String[] args) throws Exception{
var geradora = new GeradoraDeFigurinhas();
geradora.cria(null, null);
}
}
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
//recebe qualquer coisa, string nome do arquivo para salvar dif
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {


        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        
        graphics.drawString("Experimenta!", 100, novaAltura - 100);

       
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}