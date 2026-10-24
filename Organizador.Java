import java.io.File;

import java.util.Arrays;
import java.util.Comparator;
public class Organizador {
    public static void main(String[] args) {
    File pasta = new File("C:/Users/elano/Downloads/Teste");
    System.out.println("Existe? "+ pasta.exists());
    System.out.println("Caminho Absoluto: " + pasta.getAbsolutePath());

    File[] arquivos = pasta.listFiles();

     // Verifico se existem arquivos
        if(arquivos != null){
            Arrays.sort(arquivos, Comparator.comparingLong(File :: length).reversed());
            // Verifico o tamanho deles e imprimos
            for(File arquivo : arquivos){
                double tamanhoEmBytes = arquivo.length();
                double tamanhoEmQB = (tamanhoEmBytes / 1024.0);
                double tamanhoEmMB = (tamanhoEmQB / 1024.0);
                double tamanhoEmGB = (tamanhoEmMB / 1024.0);  

                if(tamanhoEmQB < 1023.0){
                System.out.println("\n" + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em KiloBytes: %.2f ", tamanhoEmQB, " KB\n\n " );
                }
                else if(tamanhoEmMB < 1023.0){
                System.out.println("\n" + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em MegaBytes: %.2f ",tamanhoEmMB, " MB\n\n " );
                }
                else{
                System.out.println("\n" + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em GigaBytes: %.2f ",tamanhoEmGB, " GB\n\n " );                   
                }
            }
        }
        else{
            System.out.println("Pasta não encontrada");
        }
    }
}
