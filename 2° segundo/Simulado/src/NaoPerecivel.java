
public class NaoPerecivel extends Produto {
	private double imposto;

	public NaoPerecivel(String nome, double preco, double imposto) {
		super(nome, preco);
		this.imposto = imposto;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	@Override
	public String toString() {
		return "NaoPerecivel [imposto=" + imposto + ", Produto Desc=" + super.toString() + "]";
	}
	
	
	
}
