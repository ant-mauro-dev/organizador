public class Organizador{
    public static void main(String[] args){
        File pasta = new File("/Downloads/Teste")
        File[] arquivos = pasta.listFiles()

        if(arquivo != null){
            for(File arquivo : arquivos){
                System.out.println(arquivo.getName());
            }
        }
    }
}