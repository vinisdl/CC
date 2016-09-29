import java.time.LocalDate;

public class Perecivel extends Produto {
	private LocalDate validade;

	public Perecivel(String nome, double preco, LocalDate validade) {
		super(nome, preco);
		this.validade = validade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Perecivel [validade=" + validade + ", DescPRODUTO=" + super.toString() + "]";
	}
	
	
}
