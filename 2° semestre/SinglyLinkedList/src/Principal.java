import java.time.format.SignStyle;

public class Principal {
	public static void main(String[] args) {
		Principal p = new Principal();

		SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();


		lst.insertLast(2);
		lst.insertLast(-1);
		lst.insertLast(1);
		lst.insertLast(-2);


		System.out.println(p.convertToInt(lst));

		System.out.println("Soma a lista.");

		System.out.println(p.somaLista(lst));

		System.out.println();
		System.out.println("Split");

		System.out.println(lst.split(0).toString());

		System.out.println(lst.toString());

		System.out.println();
		
		System.out.println("convertOverZeroStack");
		
		
		SinglyLinkedList<Double> lstD = new SinglyLinkedList<>();
		
		lstD.insertLast(1.0);
		lstD.insertLast(-1.0);
		lstD.insertLast(-3.0);
		lstD.insertLast(-4.0);
		lstD.insertLast(4.0);
		
		System.out.println(p.convertOverZeroStack(lstD));


	}



	public int convertToInt(SinglyLinkedList<Integer> lst){
		String num = "";
		Node<Integer> current = lst.head;
		while(current != null)
		{
			if(current.getElement() > 0)
				num += current.getElement() + "";
			current = current.getNext();
		}

		return Integer.parseInt(num);
	}

	public double somaLista(SinglyLinkedList<Integer> lst){		
		return soma(lst.head);		
	}

	private double soma(Node<Integer> node){
		if(node == null)
			return 0;
		else 
			return node.getElement() + soma(node.getNext());
	}


	public Stack<Double> convertOverZeroStack(SinglyLinkedList<Double> lst){
		Node<Double> current = lst.head;
		SinglyLinkedList<Double> overZero = new SinglyLinkedList<>();
		while(current != null){
			if(current.getElement() < 0){
				overZero.insertLast(current.element);
			}
			current = current.getNext();	
		}

		StaticStack<Double> stacLst = new StaticStack<>(overZero.numElements);
		current = overZero.head;
		while(current != null){
			stacLst.push(current.element);
			current = current.getNext();
		}

		return stacLst;
	}

}
