
public class Simulado {
	public double getSomaPares(int[][] m){
		if(m == null)
			throw new NullPointerException("Matriz Vazia");

		return getSomaPares(m, 0, 0);
	}

	private double getSomaPares(int[][] m, int i, int j){
		if(m[i][j] % 2 == 1){
			System.out.println("Elemento impar: " + m[i][j]);
			if(m[i].length -1> j )
				return getSomaPares(m, i, j + 1);
			else if(m.length -1> i)
				return getSomaPares(m, i +1, 0);
			else return 0;
		} else {
			if(m[i].length -1> j )
				return m[i][j] + getSomaPares(m, i, j + 1);
			else if(m.length -1> i)
				return m[i][j] + getSomaPares(m, i +1, 0);
			else return m[i][j];
		}
	}
	
	
	public double maiorValor(double[] array){
		if(array == null)
			throw new NullPointerException("Array Vazia");
		return maiorValor(array, 1,array[0]);
	}
	
	private double maiorValor(double[] array, int i, double maior){
		if(array[i] > maior && i > array.length -1)
			return maiorValor(array, i++, array[i]);
		else if(array[i] < maior && i > array.length -1)
			return maiorValor(array, i++, maior);
		else 
			return maior;

	}
	
}
