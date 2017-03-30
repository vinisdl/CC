

import java.util.Random;

//Classe com metodos referente a arrays
public class Array {

	public static int[] criaArrayRandom(int l){
		Random gerador = new Random();
		int[] a = new int[l];
		for (int i = 0; i < a.length; i++) {
			a[i] = gerador.nextInt(100);
		}
		return a;
	}
	
	public static double[] criaArrayRandomDouble(int l){
		Random gerador = new Random();
		double[] a = new double[l];
		for (int i = 0; i < a.length; i++) {
			a[i] = gerador.nextDouble();
		}
		return a;
	}

	public static void imprimeArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
	
	public static int[][] criaArrayBidimensionalRandom(int l, int c){
		Random gerador = new Random();
		int[][] a = new int[l][c];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = gerador.nextInt(100);
			}
		}
		return a;
	}

	public static void imprimeArrayBidimensional(int[][] arr, String exercicio){

		System.out.println();
		if(!exercicio.equals(""))
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
	}

	public static void imprimeArrayBidimensional(String[][] arr, String exercicio){

		if(!exercicio.equals(""))
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
	}

	public static int[][] ordenaArrayBidimensional(int[][] arr){
		arr = auxSortBuble(arr);
		return arr;
	}

	private static int[][] auxSortBuble(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = bubbleSort(arr[i]);
		}

		boolean troca = false;
		for (int i = 0; i < arr.length; i++) {
			if(i+1 < arr[i].length && arr[i][arr[i].length-1] > arr[i+1][0] ){
				int T = arr[i+1][0]; 
				arr[i+1][0] = arr[i][arr[i].length-1]; 
				arr[i][arr[i].length-1] = T;
				troca = true;
			}		 
		}		
		if(troca){
			auxSortBuble(arr);
		}

		return arr;
	}

	public static int[] bubbleSort(int[] a) { 
		int i = a.length-1;
		while (i > 0) {
			int lastFlipped = 0;
			for (int j = 0; j < i; j++) { 
				if (a[j] > a[j+1]) { // troca par de posição
					int T = a[j]; 
					a[j] = a[j+1]; 
					a[j+1] = T; 
					lastFlipped = j; 
				}
			}
			i = lastFlipped;
		}
		return a;
	}


	public static void pesquisaBinariaArrayBidimensional(int[ ][ ] arr, int arg){
		int c = -1,e = -1;
		System.out.println();
		System.out.println();
		int i = 0;

		while(e == -1 && i < arr[i].length-1){
			e = pesquisaBinaria(arr[i], arg);
			if(e != -1){
				c = i;
			}
			i++;
		}

		if(e != -1 && c != -1){
			System.out.println("O elemento se encontra");
			System.out.println("Linha: "+ c);
			System.out.println("Coluna: "+ e);
		} else {
			System.out.println("Elemento "+ arg +" não encontrado: " + e);
		}

	}

	public static int pesquisaBinaria(int[] tab, int arg) {
		int inf = 0;   int sup = tab.length - 1;
		while (inf <= sup) {
			int med = (inf + sup) / 2; // divisão inteira
			if (arg == tab[med])
				return med;
			else if (arg < tab[med])
				sup = med - 1; // procura na 1a. metade
			else
				inf = med + 1; // procura na 2a. metade
		}
		return -1;
	}

}
