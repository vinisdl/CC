import Array.*;
public class Principal {
	public static void main(String[] args) {
		int[][] arr = Array.criaArrayBidimensionalRandom(5, 5);
		
		Array.imprimeArrayBidimensional(arr, "Exercicio 1 e array utilziado no 2 desordenado");
		Array.ordenaArrayBidimensional(arr);
		System.out.println();
		Array.imprimeArrayBidimensional(arr, "Exercicio 2 ordenado");
		
		
		Array.pesquisaBinariaArrayBidimensional(arr, 5);
	}
}
