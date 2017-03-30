
public class Questao1 {
	public StaticStack<Integer> SeparaNumeros(StaticStack<Integer> st){
		
		StaticStack<Integer> pos = new StaticStack<>(st.numElements());
		StaticStack<Integer> neg = new StaticStack<>(st.numElements());
		StaticStack<Integer> zero = new StaticStack<>(st.numElements());
		
		
		for(int i = 0; i < st.numElements(); i++){
			int t = st.pop();
			if(t == 0){
				zero.push(t);
			} else if (t > 0){
				pos.push(t);
			} else{
				neg.push(t);
			}
		}
		
		for(int i = 0; i < pos.numElements();i++)
			st.push(pos.pop());
		
		for(int i = 0; i < zero.numElements();i++)
			st.push(zero.pop());
		
		for(int i = 0; i < neg.numElements();i++)
			st.push(neg.pop());
	
		
	
		
	
		
		return st;
	}
}
