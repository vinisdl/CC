import java.time.LocalDate;

public class Presidente {
	private String nome;
	private int idade;
	private LocalDate date;
	private boolean impeatchment;
	
	public Presidente(String nome, int idade, LocalDate date, boolean impeatchment) {
		this.nome = nome;
		this.idade = idade;
		this.date = date;
		this.impeatchment = impeatchment;
	}

	@Override
	public String toString() {
		return "Presidente [nome=" + nome + ", idade=" + idade + ", date=" + date + ", impeatchment=" + impeatchment
				+ "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isImpeatchment() {
		return impeatchment;
	}

	public void setImpeatchment(boolean impeatchment) {
		this.impeatchment = impeatchment;
	}
	
	
}
