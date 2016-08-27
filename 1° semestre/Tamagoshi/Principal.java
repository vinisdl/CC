//Classe criada por Marco
public class Principal{
    public static void main(String[] args){
        Tamagotchi bichinho = new Tamagotchi(T.leString("Digite um nome para seu tamagotchi"), 0, 0, 1);
        
        while(bichinho.getIdade() <= 14 && bichinho.getPeso() <= 20)
        {
            int randOp;
            int diasAcordado = 0;                      
            randOp = (int)(Math.random() * 3 + 1);
            switch(randOp){
                case 1:
                    System.out.println(bichinho.getNome() + " está com fome, escolha uma opção");
                    bichinho = fome(bichinho);
                    break;
                case 2:                   
                    System.out.println(bichinho.getNome() + " está com sono escolha uma opção");
                    bichinho = sono(bichinho);             
                    break;
                case 3:
                    System.out.println(bichinho.getNome() + " está intediado escolha uma opção");
                    break;
                
            }
        }   
        
        if(bichinho.getIdade() > 14){
            System.out.println(bichinho.getNome() + " Morreu");
        } else if(bichinho.getPeso() > 20){
            System.out.println("KABOMMMMM");
            System.out.println(bichinho.getNome() + " Explodiu e morreu.");
        }
            
        
    }
    
    //Retorna o tamagotchi depois de executar a função exercitar por 10 minutos correr ou andar.
    private static Tamagotchi exercitar(Tamagotchi bichinho){
         boolean marcador = true;
        int op = 0;
        while(marcador){
            System.out.println("Digite 1 para correr 10 minutos e 2 para caminhar 10 minutos");
            switch(op){
                case 1:
                     bichinho.setPeso(bichinho.getPeso() + 1);
                    break;
                case 2:
                    bichinho.setPeso(bichinho.getPeso() - 1);
                    System.out.println(bichinho.getNome() + " está com fome, escolha uma opção");
                    bichinho = fome(bichinho);
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
                    
                
            }
        }                
        return bichinho;
    }
    
    //Retorna o tamagotchi depois de executar a função dormir ou nao.
    private static Tamagotchi sono(Tamagotchi bichinho){
        boolean marcador = true;
        int op = 0;
        while(marcador){
            System.out.println("Digite 1 para dormir e 2 para permanecer acordado");
            op = T.leInt("Digite:");
            switch(op){
                case 1:
                    bichinho.setIdade(bichinho.getIdade() + 1);
                    bichinho.setDiasAcordado(0);
                    marcador = false;
                    break;
                case 2:
                    bichinho.setDiasAcordado(bichinho.getDiasAcordado() + 1);
                    if(bichinho.getDiasAcordado() <= 5){
                        bichinho.setDiasAcordado(0);
                        bichinho.setIdade(bichinho.getIdade() + 1);
                    }
                    marcador = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        return bichinho;
    }        
    
    //Retorna o tamagotchi depois de executar a função fome, que da opções de comer ou não.    
    private static Tamagotchi fome(Tamagotchi bichinho){
         boolean marcador = true;
         int op = 0;
         while(marcador){
            System.out.println("Digite 1 para comer muito e 2 para comer pouco e 3 para não comer");
            op = T.leInt("Digite:");
            switch(op){
                case 1:
                    bichinho.setPeso(bichinho.getPeso() + 5);
                    bichinho = sono(bichinho);
                    marcador = false;
                    break;
                case 2:
                    bichinho.setPeso(bichinho.getPeso() + 1);                                
                    marcador = false;
                    break;
                case 3:
                    bichinho.setPeso(bichinho.getPeso() - 2);                                
                    marcador = false;
                    break;
                default:
                
                    System.out.println("Opção invalida");
                    break;
                }
            }   
         return bichinho;
    }
}