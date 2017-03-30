
public class Principal {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> lista = new SinglyLinkedList<Integer>();
		try{
			lista.insertFirst(1);
			lista.insertFirst(2);
			lista.insertFirst(3);
			lista.insertFirst(4);
			lista.insertFirst(5);
			lista.insertFirst(6);
			lista.insertLast(7);

			System.out.println(lista);

			while (!lista.isEmpty()) {
				System.out.println(lista.removeFirst());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}


