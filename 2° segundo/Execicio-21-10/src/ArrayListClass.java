import java.util.ArrayList;
import java.util.Random;

//Array dinamico redimencionavel
public class ArrayListClass {
	
	public static void main(String[] args) {
		ArrayListClass prs = new ArrayListClass();
		ArrayList<Integer> lst = new ArrayList<>();
		Random r = new Random();
		lst.add(r.nextInt(10));
		lst.add(r.nextInt(10));	
		lst.add(r.nextInt(10));
		lst.add(r.nextInt(10));
		lst.add(r.nextInt(10));
		
		Stack<Integer> pilha = prs.RetornaPilha(lst);
		
		int count = 0;
		while(!pilha.isEmpty()){
			System.out.println("Topo pilha: " + pilha.pop() + " Primeiro ArrayList: " + lst.get(count));
			count++;
		}
		
	}
	
	public Stack<Integer> RetornaPilha(ArrayList<Integer> list){
		
		Stack<Integer> sList = new StaticStack<>(list.size());
		
		
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(list.size() -1 - i);
			sList.push(temp);
		}
		
		
		return sList;
	}

}
