
public abstract class Figura {
	public String cor;
	
	public Figura(String cor){
		this.cor = cor;
	}
	
	public String getCor(){
		return cor;
	}
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	public abstract double calculaArea();
	public abstract double calculaPerimetro();
	
	
}
