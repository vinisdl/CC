
public class Exercicios {
	public void exercicio1(){
		System.out.println("Resultado pra f(2):" + f(2));
		System.out.println("Resultado pra f(4):" + f(4));
		System.out.println("Resultado pra f(9):" + f(9));
	}
	
	public static int f(int x){
		int res;
			if(x < 4)
				res = 3 * x;
			else 
				res = 2 * f(x-4) +5;
		return res;
	}
	
	//Criar	uma	fun��o	recursiva	para	calcular	a	soma	dos	inteiros	de	1 a	n, sendo	n	>=	1.
	public double exercicio2(int n){
		if(n == 1)
			return 1;
		return n + exercicio2(n - 1);
	}
	
	/*Escreva	 uma	 fun��o	 recursiva	 que	 retorne	 a	 soma	 dos	 elementos	 de	 um	 vetor	 v	
	contendo	t elementos.*/
	public double exercicio3(int[] a){		
		return forGambi(a, a.length -1);
	}
	
	private double forGambi(int[] a, int n){
		if(n==0)
			return a[0];
		else
			return a[n] + forGambi(a, n-1);
	}	
	
	public int mdc(int x,  int y){
		if(x>= y && x%y == 0)
			return y;		
		if(x<y)
			return mdc(x,y);		
		return mdc(y, x%y);
	}
	
	public boolean procuraNaString(String s, char c){
		
		return searchString(s,0,c);
	}
	
	private boolean searchString(String s, int i, char c){
		if(s.toLowerCase().charAt(i) == c)
			return true;
		else if(s.length() - 1 == i)
			return false;
		return searchString(s, i+1, c);		
	}
	
}
