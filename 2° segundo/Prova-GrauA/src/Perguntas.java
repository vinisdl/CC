
public class Perguntas {
	
	//Questão 1
	public int countVezes(String[] txt, char c){
		return countVezes(txt,c,0,0);
	}

	private int countVezes(String[] txt, char c,int i, int v){
		if(i != txt.length)
			return countVezes(txt, txt[i],c,i,0,v );
		else
			return v;
		
	}

	private int countVezes(String[] arr, String txt, char c, int iA, int iS, int v){
		String ca = c + "";
		if(iS != txt.length()){
			if(txt.toUpperCase().charAt(iS) == ca.toUpperCase().charAt(0) )
				return countVezes(arr,txt, c,iA, iS+1, v+1);
			else
				return countVezes(arr, txt, c,iA, iS +1, v);
		} 
		else 
			return countVezes(arr,c,iA+1,v);


	}
	
	//Questão 2
	public boolean verificaMatrizIdentidade(int[][] m) throws MatrixIncorrectException{
		if(m[0].length != m.length)
			throw new MatrixIncorrectException();
		return verificaMatrizIdentidade(m,0,0);
	}
	
	private boolean verificaMatrizIdentidade(int[][] m, int i, int j){
		if(i != m.length)
			if(m[i].length != j){
				if(m[i][j] != 0 && j != i)
					return false;
				else{
					if(m[i][i] != 1)
						return false;
				}
				return verificaMatrizIdentidade(m,  i, j + 1);
			}else{
				return verificaMatrizIdentidade(m,  i +1, 0);
			}
		return true;
	
	
	}
	
	//Pergunta 3
	public int[][] transpose(int[][] m){
		
		int[][] mNew= new int[m[0].length][m.length];
		
		for (int i = 0; i < m[0].length; i++) {
			for (int j = 0; j < m.length; j++) {
				mNew[i][j] = m[j][i];
			}
		}	
		return mNew;
	}
	
	
	
	public static void imprimeMatriz(int[][] arr){

		System.out.println();

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
	
}
