
public class Exercicios {


	public int pegaQuantidadeNegativos(List<Integer> lst){		
		int count = 0;
		for (int i = 0; i < lst.numElements(); i++)
			if(lst.search(i) < 0)
				count++;
		return count;
	}

	public int pegaQuantidadeNegativosRecursivo(List<Integer> lst){		
		if(lst == null)
			return 0;
		return pegaQuantidadeNegativosRecursivo(lst,0, 0);
	}

	private int pegaQuantidadeNegativosRecursivo(List<Integer> lst, int count, int soma){
		if(count == lst.numElements())
			return soma;
		if(lst.get(count) < 0)
			return pegaQuantidadeNegativosRecursivo(lst,count++, soma++);
		else 
			return pegaQuantidadeNegativosRecursivo(lst,count++, soma);
	}

	public String pegaMenorStringDosArrays(List<String> lst1, List<String> lst2 ){
		String menor  = lst1.get(0);
		for (int i = 0; i < lst1.numElements(); i++) {
			if(menor.length() > lst1.get(i).length()){
				menor = lst1.get(i);
			}
		}
		for (int i = 0; i < lst2.numElements(); i++) {
			if(menor.length() > lst2.get(i).length()){
				menor = lst2.get(i);
			}
		}
		return menor;	
	}
	
	
	private List<Integer> array;
	private int length;

	public void sort(List<Integer> inputArr) {

		if (inputArr == null || inputArr.numElements() == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.numElements();;
		//Chama o metodo passando o primeiro e ultimo index do array
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// Calcula o pivo pegando um elemento quaquer
		int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
		// Divide em 2 arrays
		while (i <= j) {
			/**
			 *Para cada interação vamos indentificar um número do lado esquerdo que é maior que
			 *que o pivo e para o lado esquerdo que é menor que  o pivo, uma vez que compararmos os valores
			 *trocamos as posições deles.
			 */

			//calcula quantidade de posições menores que o pivo
			while (array.get(i) < pivot) {
				i++;
			}
			//calcula quantidade de posições maiores que o pivo
			while (array.get(i) > pivot) {
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
		
		int temp = array.get(j);
		array.insert(array.get(i), j);
		array.insert(temp, i);
	}	
}
