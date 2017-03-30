public class Exercicio {
	public static void main(String a[]){

		Exercicio s = new Exercicio();
		int[] input = {10,87,8,-3,-34,-22,89,0,1,37,14,-2};
		s.sort(input);
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
	}

	private int array[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		//Chama o metodo passando o primeiro e ultimo index do array
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// Calcula o pivo pegando um elemento quaquer
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide em 2 arrays
		while (i <= j) {
			/**
			 *Para cada interação vamos indentificar um número do lado esquerdo que é maior que
			 *que o pivo e para o lado esquerdo que é menor que  o pivo, uma vez que compararmos os valores
			 *trocamos as posições deles.
			 */

			//calcula quantidade de posições menores que o pivo
			while (array[i] < pivot) {
				i++;
			}
			//calcula quantidade de posições maiores que o pivo
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// Chama o metodo recursivamente
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


}
