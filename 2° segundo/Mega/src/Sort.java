
public class Sort {
	private int array[];
	private int length;

	public Sort(int[] inputArr) {

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
			 *Para cada intera��o vamos indentificar um n�mero do lado esquerdo que � maior que
			 *que o pivo e para o lado esquerdo que � menor que  o pivo, uma vez que compararmos os valores
			 *trocamos as posi��es deles.
			 */

			//calcula quantidade de posi��es menores que o pivo
			while (array[i] < pivot) {
				i++;
			}
			//calcula quantidade de posi��es maiores que o pivo
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
