//Classe criada por Marco
public class Tamagotchi{
    private String nome;
    private int idade, diasAcordado;
    private double peso;
    
    public Tamagotchi(String nome, int idade,int diasAcordado, double peso){
        this.nome = nome;
        this.idade = idade;
        this.diasAcordado = diasAcordado;
        this.peso = peso;
    }
    
    public void setDiasAcordado(int diasAcordado){
        this.diasAcordado = diasAcordado;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getDiasAcordado(){
        return this.diasAcordado;
    }
    
    public int getIdade(){
        return this.idade;
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    
}