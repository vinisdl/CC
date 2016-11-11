// 3 4 10 12 13 15

public class Principal{
	public static void main(String[] args) {
		Principal p = new Principal();
	}
	
	
	public Integer[] itemsExcept(int number, Stack<Integer> p){
		Stack<Integer> temp;
		
			temp = new StaticStack<>(p.numElements());
			
			while (!p.isEmpty()) {
				temp.push(p.pop());
			}
						
			Integer[] i = new Integer[p.numElements()];
			int count = 0;
			while(!temp.isEmpty()){
				int pTemp = temp.pop();
				if( pTemp != number){
					i[count] = pTemp;
					count++;
				}
				p.push(pTemp);
			}
		return i;		
	}

	
	public <E> void transferElements(Stack<E> s1, Stack<E> s2) {
			Stack<E> temp = new StaticStack<>(s2.numElements());

			while (!s1.isEmpty()) {
				temp.push(s1.pop());
			}
			
			while (!temp.isEmpty() && !s2.isFull()) {
				s2.push(temp.pop());
			}		
	}
	
	public <E> boolean verificaElementoLista(Stack<E> l, E elemento){
		Stack<E> temp = new StaticStack<E>(l.numElements());
		transferElements(l, temp);
		int pos = -1;
		while (!l.isEmpty()) {
			pos = l.numElements()  -1;
			if(l.pop() == elemento)
			{
				System.out.println("A possição do elemento é: " + pos );
			}
		}	
		
		return true;
	}
		
	public <E> void cloneElements(Stack<E> s1, Stack<E> s2) {
		Stack<E> temp = new StaticStack<>(s2.numElements());
		Stack<E> temp2 = new StaticStack<>(s2.numElements());

		while (!s1.isEmpty()) {
			E pTemp = s1.pop();
			
			temp.push(pTemp);
			temp2.push(pTemp);
		}
		
		while (!temp.isEmpty() && !s2.isFull()) {
			s2.push(temp.pop());
		}		
		
		while (!temp2.isEmpty() && !s1.isFull()) {
			s1.push(temp2.pop());
		}	
		
}
	
}
