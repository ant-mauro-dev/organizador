import java.io.File;

public class Teste {
    public static void main(String[] args) {
     File pasta = new File("/Downloads/Teste");
        File[] arquivos = pasta.listFiles();

        if(arquivos != null){
            for(File arquivo : arquivos){
                System.out.println(arquivo.getName());
            }
        }

    }
}
