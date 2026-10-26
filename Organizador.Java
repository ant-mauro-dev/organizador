import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Organizador {

    public static final String SEM_EXTENSAO = "Desconhecido";
    public static void main(String[] args) {

    
    Scanner scan = new Scanner(System.in);

    System.out.println("Digite o caminho absoluto da pasta");

    File pasta = new File(scan.nextLine());
    File[] arquivos = pasta.listFiles();
    Map<String,String> categorias = new HashMap<>();
    categorias.put("jpg", "Imagem");
    categorias.put("png", "Imagem");
    categorias.put("jpeg", "Imagem");

    categorias.put("pdf", "PDF");

    categorias.put("mp4", "Video");
    categorias.put("mp3", "Audio");
    categorias.put("wav", "Audio");

    categorias.put("txt", "Documento");

    if(!pasta.exists() || !pasta.isDirectory()){
        System.out.println("O caminho não existe ou não é uma pasta");
        scan.close();
        return;
    }

    if(arquivos != null){
            Arrays.sort(arquivos, Comparator.comparingLong(File :: length).reversed());
        }
        else{
            System.out.println("Arquivos não encontrados");
            scan.close();
            return;
        }

    organizarArquivos(pasta, categorias, arquivos, true);

    System.out.println("Você quer organizar as suas pastas? se sim digite 's' ");
    String escolha = scan.nextLine();

    if(!escolha.equalsIgnoreCase("S")){
        System.out.println("Você escolheu não continuar com o programa. ");
        scan.close();
        return;

    }
    else{
        organizarArquivos(pasta, categorias, arquivos, false);
    }

    scan.close();
    }

    public static void organizarArquivos(File pasta, Map<String, String> categorias, File[] arquivos, boolean simulacao){
        for(File arquivo : arquivos){
                if(!arquivo.isFile()){ // caso seja uma pasta
                    continue;
                }
                // definir os tamanhos e tipos de medidas
                double tamanhoEmBytes = arquivo.length();
                double tamanhoEmQB = (tamanhoEmBytes / 1024.0);
                double tamanhoEmMB = (tamanhoEmQB / 1024.0);
                double tamanhoEmGB = (tamanhoEmMB / 1024.0);  


                // verificar o tamanho do arquivo
                if(tamanhoEmQB < 1024.0){
                System.out.println("Nome do Arquivo: " + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em KiloBytes: %.2f KB\n", tamanhoEmQB);
                System.out.println("==================");
                }

                else if(tamanhoEmMB < 1024.0){
                System.out.println("Nome do Arquivo: " + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em MegaBytes: %.2f MB\n",tamanhoEmMB);
                System.out.println("==================");
                }

                else{
                System.out.println("Nome do Arquivo: " + arquivo.getName()); 
                System.out.printf("Tamanho dos arquivos em GigaBytes: %.2f GB\n",tamanhoEmGB); 
                System.out.println("==================");                  
                }

                // descobrir o formato do arquivo
                int posicao = arquivo.getName().lastIndexOf(".");
                String extensao;

                if(posicao != -1){
                extensao = arquivo.getName().substring(posicao + 1).toLowerCase();
                }
                else{
                    extensao = SEM_EXTENSAO;
                }
                System.out.println("Extensão: "+extensao);
                System.out.println("=================");

                String nomeCategoria = categorias.getOrDefault(extensao, "Outros");
                System.out.println("Categoria: " + nomeCategoria);
                System.out.println("========================\n");

                File novaPasta = new File(pasta, nomeCategoria);
                File destino = new File(novaPasta, arquivo.getName());

                try {
                    if(simulacao){
                        System.out.println("arquivo: " + arquivo.getName() + " será movido para a pasta: " + novaPasta.getName());
                    
                    }
                    else{
                    novaPasta.mkdirs();
                    Files.move(arquivo.toPath(), destino.toPath());
                    System.out.println("Arquivo movido com sucesso");
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao mover o arquivo:  "  + arquivo.getName()+ " " + e.getMessage());
                }
            }
    }


}
