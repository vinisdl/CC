import java.time.LocalDate;

public class Alimento extends Produto {
		private LocalDate Validade;

		public Alimento(String nome, String descricao, double preco, LocalDate validade) {
			super(nome, descricao, preco);
			Validade = validade;
		}

		public LocalDate getValidade() {
			return Validade;
		}

		public void setValidade(LocalDate validade) {
			Validade = validade;
		}

		@Override
		public String toString() {
			return "Alimento ["+ super.toString() + " Validade=" + Validade + "]";
		}
		
}
