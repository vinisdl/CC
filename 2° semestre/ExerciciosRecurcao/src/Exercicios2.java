import Array.*;
public class Exercicios2 {	
	public double maiorValor(double[] array){
		if(array.length == 0)
			return 0;
		else if (array.length == 1)
			return array[0];
		else 
			return maiorValor(array, array[0], 1);
	}

	private double maiorValor(double[] ar, double maior, int i){
		if(ar.length -1 == i && maior > ar[i])
			return maior;
		else if(maior > ar[i])
			return maiorValor(ar, maior, i+1);
		else if(ar[i] > maior)
			return maiorValor(ar, ar[i], i+1);
		else
			return 0;
	}

	public void exercicio2(String[][] arr){
		exercicio2(arr,0,0);
	}

	private void exercicio2(String[][] arr, int x, int y){
		if (x != arr.length){
			if(y != arr[x].length){
				if(arr[x][y] != null  && arr[x][y].length() % 2 == 1)
					System.out.println(arr[x][y]);
				else
					exercicio2(arr, x, y+1);
			}else{
				exercicio2(arr, x +1, 0);
			}
		}	
	}


	public double somaDiagonal(int[][] ar){
		if(ar[0].length != ar.length){
			System.out.println("O array não possui diagonal principal");
			return 0;
		}
		return somaDiagonal(ar,0,0);
	}

	private double somaDiagonal(int[][] ar, int i, int j){
		if(i == ar.length -1 && j ==  ar[0].length -1 )
			return ar[i][j];
		return ar[i][j] + somaDiagonal(ar, i + 1, j +1);
	}

	public double somaDiagonalSec(int[][] ar){
		if(ar[0].length != ar.length){
			System.out.println("O array não possui diagonal Sec");
			return 0;
		}
		return somaDiagonalSec(ar, 0 ,ar[0].length -1);
	}

	private double somaDiagonalSec(int[][] ar, int i, int j){
		if(i == ar.length -1 && j ==  0 )
			return ar[i][j];
		return ar[i][j] + somaDiagonalSec(ar, i + 1, j -1);
	}


	public Presidente presidentesMaisNovoEPresidentesLadroes(Presidente[] pr){
		return presidente(pr, null, 0);
	}

	private Presidente presidente(Presidente[] pr, Presidente novo, int i){
		if(i == pr.length)
			return novo;		
		if(pr[i].isImpeatchment()){
			if(novo == null)
				novo = pr[i];
			System.out.println(pr[i].toString());
			if(pr[i].getIdade() < novo.getIdade())
				return presidente(pr, pr[i], i+1);
			else
				return presidente(pr, novo, i+1);
		}
		return presidente(pr, novo, i+1);
	}

}
