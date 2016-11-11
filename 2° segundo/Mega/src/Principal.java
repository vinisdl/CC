import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
//Número do sorteio - Data do sorteio - Dezena 1 - Dezena 2 - Dezena 3 - Dezena 4 - Dezena 5 - Dezena 6 - N/A - Número de ganhadores da Sena - Prêmio para os ganhadores da sena - Número de ganhadores da Quina - Prêmio para os ganhadores da quina - Número de ganhadores da Quadra - Prêmio para os ganhadores da quadra - Acumulou ou não - Valor acumulado - N/A - N/A
//0				1				2		  3			4			5			6		   7		8			9									10										11							12								13									14									15				16								
public class Principal {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("megasena.txt");
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			int[] nums = new int[61];
			int c = 0;
			double maiorSort = 0;
			LocalDate data = LocalDate.MIN;
			while (line != null) {
				c++;
				line = in.readLine();
				
				if(line != null){
					String[] temp = new String[17];;
					temp = line.split(" 	");
					for (int i = 0; i < temp.length; i++) {
						if( i >= 2 && i<= 7)
							nums[Integer.parseInt(temp[i])]++;									
					}	
					double tempVlr = Double.parseDouble(temp[11]);
					if(tempVlr > maiorSort){
						maiorSort = tempVlr;
						 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						data = LocalDate.parse(temp[1], formatter);
					}
				}
			}

			System.out.println(maiorSort + "  -  " + data.toString());
			int[] topTen = new int[10];
			int[] tempArr = Arrays.copyOf(nums, nums.length);

			for (int i = 0; i < topTen.length; i++) {
				int maior = achaMaior(tempArr);
				topTen[i] = maior;
				tempArr[maior] = 0;
			}
			FileOutputStream out = new FileOutputStream("maisSorteados.txt");
			PrintStream ps = new PrintStream(out);
			for (int i = 0; i < topTen.length; i++) {			
				ps.println (topTen[i] + " é o " + (i+1) +"° mais sorteado e foi sorteado " + nums[topTen[i]] + " vezes");
			}
			ps.close();


			//			in.close();
			//			fr = new FileReader("megasena.txt");
			//			in = new BufferedReader(fr);
			//			line = in.readLine();
			//			
			//			String[] linhas = new String[c];
			//			int[] nums = new int[59];
			//			c = 0;
			//			while (line != null) {
			//				linhas[c] = line = in.readLine();
			//				c++;
			//			}
			//			
			//			for (int i = 0; i < linhas.length; i++) {
			//				System.out.println(linhas[i]);
			//			}


			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura.");
		} 
	}


	public static int achaMaior(int[] ar){
		int maior = 0;
		for (int i = 1; i < ar.length; i++) {
			if(ar[i] > ar[maior]){
				maior = i;				
			}
		}		
		return maior;
	}

}
