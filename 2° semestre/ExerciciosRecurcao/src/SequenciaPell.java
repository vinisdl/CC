
public class SequenciaPell {
	public int sequenciaPell(int n){	
		return p(n);
	}
	
	private int p(int n){
		if(n == 0 || n == 1)
			return n;
		return 2 * p(n-1)+ p(n-2);
	}
}
