import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Rovers {
	
    int x;
    int y;
    char posicao;

	public int posicao_left(Rovers rovers){

            switch (posicao) {
                case 'N':
                    this.posicao = 'W';
                    break;
                case 'W':
                    this.posicao = 'S';
                    break;
                case 'S':
                    this.posicao = 'E';
                    break;
                case 'E':
                    this.posicao = 'N';
                    break;
                default:
                    break;
            }
            return 0;
	}

	public int posicao_right(Rovers rovers){

            switch (posicao) {
                case 'N':
                    this.posicao = 'E';
                    break;
                case 'E':
                    this.posicao = 'S';
                    break;
                case 'S':
                    this.posicao = 'W';
                    break;
                case 'W':
                    this.posicao = 'N';
                    break;
                default:
                    break;
            }
            return 0;
	}

	public int posicao_caminhar(Rovers rovers){

            switch (posicao) {
                case 'E':
                    this.x++;
                    break;
                case 'S':
                    this.y--;
                    break;
                case 'W':
                    this.x--;
                    break;
                case 'N':
                    this.y++;
                    break;
                default:
                    break;
            }
            return 0;
	}
       
}

public class MarsRovers {
    
    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        ArrayList<String> coordenadas = new ArrayList<String>();
        String text = buffRead.readLine();
        String[] matriz = text.split ("\\s");
        int n = (int) Integer.parseInt(matriz[0]);             
        int m = (int) Integer.parseInt(matriz[1]);
               
        Scanner in = new Scanner(new File("D:/teste.txt"));
        
        while (in.hasNextLine()){        
            coordenadas.add(in.nextLine());            
        }
        
        int i = 1, j = 2;
        int atual, k;
        int p = coordenadas.size();
        Rovers rovers = new Rovers();
        while(j<p){
            String[] posicaoInicial = coordenadas.get(i).split("\\s");
            rovers.x = Integer.parseInt(posicaoInicial[0]);
            rovers.y = Integer.parseInt(posicaoInicial[1]);
            rovers.posicao = (char) posicaoInicial[2].charAt(0);
            String caminho = coordenadas.get(j);
            if(rovers.x>n || rovers.y>m){
                System.out.println("Rover não esta dentro do planalto.");
                j = j + 2;
                i = i + 2;
            }
            else if ((rovers.posicao != 'N') && (rovers.posicao != 'E') && (rovers.posicao != 'W') && (rovers.posicao != 'S')){
                System.out.println("Direção não existe.");
                j = j + 2;
                i = i + 2;
            }
            else{
                for(k=0; k<caminho.length();k++){
                atual = caminho.charAt(k);
                    switch (atual) {
                        case 'L':
                            rovers.posicao_left(rovers);
                            break;
                        case 'R':
                            rovers.posicao_right(rovers);
                            break;
                        case 'M':
                            rovers.posicao_caminhar(rovers);
                            break;
                        default:
                            break;
                    }
                }
                if(rovers.x>n || rovers.y>m){
                System.out.println("Rover saiu do planalto.");
                j = j + 2;
                i = i + 2;
                }
                else {
                System.out.println(" " + rovers.x + " " + rovers.y + " " + rovers.posicao);
                j = j + 2;
                i = i + 2;
                }
            }
        }      
        buffRead.close();
    }
 
}