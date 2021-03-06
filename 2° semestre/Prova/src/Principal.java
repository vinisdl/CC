
public class Principal {
	public static void main(String[] args) {
		int[][] ar = Array.criaArrayBidimensionalRandom(4, 4);
		Array.imprimeArrayBidimensional(ar, "Quest�o 2");

		Principal p = new Principal();
		System.out.println();
		System.out.println("Resultado: " + p.averageOddLines(ar));



		System.out.println();
		System.out.println("Quest�o 3:");

		int[] arr = Array.criaArrayRandom(10);

		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("Quantas vezes 10 aparece no array? " + p.numberOfOccurences(arr, 10));

	}

	public double averageOddLines(int[][] matriz){
		double media = 0;
		double mediaParcial = 0;

		int linhas = 1;
		for (int i = 0; i < matriz.length; i++) {
			if(i % 2 == 1){
				for (int j = 0; j < matriz[i].length; j++) {
					mediaParcial = mediaParcial + matriz[i][j];

				}
				if(i != 1)
					linhas ++;	
				media += mediaParcial / matriz[i].length;
				mediaParcial = 0;
			}
		}
		return media/linhas;
	}


	public int numberOfOccurences(int[] array, int elemento){
		if(array == null)
			return 0;
		return numberOfOccurences(array, elemento, 0);
	}

	private int numberOfOccurences(int[] array, int e, int i){
		if(array.length -1 == i)
			return 0;
		if(array[i] == e)
			return 1 + numberOfOccurences(array, e, i +1);
		return numberOfOccurences(array, e, i +1);		
	}

}
