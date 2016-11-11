import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Estoque {
	private Produto[] produtos;
	private Alimento alimentoCaro;
	private Eletrodomestico eletroBarato;
	private Vestuario[] vestuarios;
	
	public Estoque(int qtd){
		produtos = new Produto[qtd];
		vestuarios = new Vestuario[qtd];
	}
	
	public void preencheEstoque(String arquivo){
		String filename = arquivo;
		int aux = 0;
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader in = new BufferedReader(fr);
			in.readLine();
			String line = in.readLine();
			
			while (line != null) {
				
				
				String[] obj = line.split("\\s\\*\\s");
				if(obj[3].equalsIgnoreCase("Vestuário")){
					produtos[aux] = new Vestuario(obj[0],obj[1], Double.parseDouble(obj[2]),Integer.parseInt(obj[4]));					
					vestuarios[aux] = (Vestuario)produtos[aux];
				} else if(obj[3].equalsIgnoreCase("Alimento")){
					String[] data = obj[4].split("/");					
					produtos[aux] = new Alimento(obj[0],obj[1], Double.parseDouble(obj[2]),LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])));
					if(alimentoCaro == null)
						alimentoCaro = (Alimento)(produtos[aux]);
					else if(((Alimento)(produtos[aux])).getPreco() > alimentoCaro.getPreco())
						alimentoCaro = (Alimento)(produtos[aux]);					
				} else if (obj[3].equalsIgnoreCase("Eletrodoméstico")){
					produtos[aux] = new Eletrodomestico(obj[0],obj[1], Double.parseDouble(obj[2]),Double.parseDouble(obj[4]));
					if(eletroBarato == null)
						eletroBarato = (Eletrodomestico)(produtos[aux]);
					else if(eletroBarato.getPreco() > produtos[aux].getPreco())
						eletroBarato = (Eletrodomestico)produtos[aux];
				}
				aux++;
				System.out.println();
				line = in.readLine();
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+filename+"\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + filename+".");
		}
	}
	
	
	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	public Alimento getAlimentoCaro() {
		return alimentoCaro;
	}

	public Eletrodomestico getEletroBarato() {
		return eletroBarato;
	}

	public Vestuario[] getVestuarios() {
		return vestuarios;
	}

	@Override
	public String toString() {
		return "Estoque [produtos=" + Arrays.toString(produtos) + "]";
	}
	
}
