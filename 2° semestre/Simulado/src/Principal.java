
public class Principal {
	public static void main(String[] args) {
		Simulado s = new Simulado();

		int[][] a = Array.criaArrayBidimensionalRandom(3, 3);
		Array.imprimeArrayBidimensional(a, "Exercicio 1");
		System.out.println();
		System.out.println("Soma de todos elementos pares é :" + s.getSomaPares(a));


	
		double[] d = Array.criaArrayRandomDouble(10);
		System.out.println();
		for (int i = 0; i < d.length; i++) {
			System.out.println(" "+ (d[i]) + " ");
		}
		System.out.println();

		System.out.println("Maior valor é: "+ s.maiorValor(d));


	}
}
