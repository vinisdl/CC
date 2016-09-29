import java.io.*;
import java.util.Scanner; 

public class Principal {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		String filename;
		
		do{
			System.out.println("Digite o nome do arquivo");
			filename = s.nextLine();
		}while(filename == null);
	
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			int linhas = 0;
			while (line != null) {
				line = in.readLine();
				linhas++;				
			}		
			Estoque e = new Estoque(linhas -1);
			
			e.preencheEstoque(filename);
			
			
			System.out.println("Mais caro:" + e.getAlimentoCaro());
			
			System.out.println("Barato " + e.getEletroBarato());
			
			for (int i = 0; i < e.getVestuarios().length; i++) {
				if(e.getVestuarios()[i] != null)
					e.getVestuarios()[i].toString();
				
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+filename+"\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + filename+".");
		}
	} 
}
