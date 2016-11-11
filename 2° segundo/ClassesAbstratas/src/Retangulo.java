
public class Retangulo extends Figura {
	private double base, altura;
	
	public Retangulo(String cor, double base, double altura) {
		super(cor);
		this.base = base;
		this.altura = altura;
	}

	public double calculaArea() {
		
		return base*altura;
	}

	public double calculaPerimetro() {
		return calculaArea() * 2;
	}

	@Override
	public String toString() {
		return "Retangulo [base=" + base + ", altura=" + altura + ", cor=" + cor + ", Area=" + calculaArea()
				+ ", Perimetro=" + calculaPerimetro() + "]";
	}

}
