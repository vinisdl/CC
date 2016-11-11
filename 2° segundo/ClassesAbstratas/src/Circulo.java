
public class Circulo extends Figura {
	private double raio;
	
	
	public Circulo(String cor, double raio) {
		super(cor);
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		// TODO Auto-generated method stub
		return Math.PI * (raio * raio);
	}

	@Override
	public double calculaPerimetro() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * raio;
	}

	@Override
	public String toString() {
		return "Circulo [raio=" + raio + ", cor=" + cor + ", Area=" + calculaArea() + ", Perimetro="
				+ calculaPerimetro() + "]";
	}

}
