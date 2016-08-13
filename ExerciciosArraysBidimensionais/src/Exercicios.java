import java.text.DecimalFormat;
import java.util.Random;

public class Exercicios {
	public void Exercicio1(){
		int[][] a = new int[10][10];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = j;
			}
		}
		
		escreveArray(a, "1-a");
		
		
		int[][] b = new int[10][10];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = j * j;
			}
		}
		
		escreveArray(b, "1-b");
		
		int[][] c = new int[6][6];
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				c[i][j] = i;
			}
		}
		
		escreveArray(c, "1-c");
		
		
		int[][] d = new int[6][9];
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if(i % 2 == 0)
					d[i][j] = -1;
				else
					d[i][j] = 0;
			}
		}
		
		escreveArray(d, "1-d");
	}
	
	
	public void exercicio2(){
		
		Random gerador = new Random();
		int[][] a = new int[10][10];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = gerador.nextInt(100);
			}
		}
		
		escreveArray(a, "2");
	}
	
	
	public double exercicio7(double[][] arr){
		
		double maior  = arr[0][0];
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if(arr[i][j] > maior)
					maior = arr[i][j];
			}
		}
		
		escreveArray(arr, "7");
		DecimalFormat twoDForm = new DecimalFormat("0.0");
		return Double.parseDouble(twoDForm.format(maior).replaceAll(",", "."));
	}
	
	
	public double exercicio8(int[][] arr){
		double soma  = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {				
					soma += arr[i][j];
			}
		}
		
		escreveArray(arr, "8");
		
		return soma;
	}
	
	
	public double exercicio9(int[][] arr, int linha){
		
		double soma  = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if(i == linha)
				for (int j = 0; j < arr[i].length; j++) {	
						soma += arr[i][j];
				}
		}
		
		escreveArray(arr, "9");
		System.out.println("A media da linha " + linha + " é " + soma / arr[linha].length);
		
		
		return soma / arr[linha].length;
	}
	
	public void escreveArray(int[][] arr, String exercicio){
		
		System.out.println("Escrevendo array do exercicio " + exercicio);
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.println("");
			System.out.print("L | ");
			for (int j = 0; j < arr[i].length; j++) {
				if(j == 0 && i == 0 ){
					String h = "";
					for (int j2 = 0; j2 < arr[i].length; j2++) 
						h += " C ";
					System.out.println(h);
					System.out.print("L | ");
				}
				String str = arr[i][j] + "";
				if(str.length() == 2)
					System.out.print(arr[i][j] + " ");
				else
					System.out.print(" " + arr[i][j] + " ");
			}
		}
		
		System.out.println(" ");
		System.out.println("Final");
	}



	public void escreveArray(double[][] arr, String exercicio){
		
		System.out.println("Escrevendo array do exercicio " + exercicio);
		DecimalFormat twoDForm = new DecimalFormat("0.0");
		for (int i = 0; i < arr.length; i++) {
			
			System.out.println("");
			System.out.print("L | ");
			for (int j = 0; j < arr[i].length; j++) {
				if(j == 0 && i == 0 ){
					String h = "";
					for (int j2 = 0; j2 < arr[i].length; j2++) 
						h += "  C ";
					System.out.println(h);
					System.out.print("L | ");
				}
													
				System.out.print(twoDForm.format(arr[i][j]) + " ");
				
			}
		}
		
		System.out.println(" ");
		System.out.println("Final");
	}
}		
	