
public class Eletrodomestico extends Produto {
	private double ipi;

	public Eletrodomestico(String nome, String descricao, double preco, double ipi) {
		super(nome, descricao, preco);
		this.ipi = ipi;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}

	@Override
	public String toString() {
		return "Eletrodomesticos [ipi=" + ipi + ", Nome=" + getNome() + ", Descricao=" + getDescricao()
				+ ", Preco=" + getPreco() + "]";
	}
	
}
