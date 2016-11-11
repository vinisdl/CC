public class SinglyLinkedList<E> implements List<E> {
	Node<E> head;
	Node<E> tail;
	int numElements;

	public SinglyLinkedList() {
		head = tail = null;
		numElements = 0;
	}

	public int numElements() {
		return numElements;

	}

	public boolean isEmpty() {
		return numElements == 0;

	}

	public boolean isFull() {
		return false;
	}

	public void insertFirst(E element) {
		// cria um novo nó e o torna o novo "head"
		Node<E> newNode = new Node<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head = newNode;
		}
		// ajusta o total de elementos
		numElements++;
	}
	public void insertLast(E element) {
		// cria um novo nó e o torna o novo "tail"
		// ajusta o total de elementos
		Node<E> newNode = new Node<E>(element);		
		if(tail != null)
			tail.setNext(newNode);;
			tail = newNode;

			if(head == null)
				head = newNode;

			numElements++;

	}
	public E removeFirst() {
		// verifica se há pelo menos um elemento a ser removido
		// guarda uma referência temporária ao elemento sendo removido
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		// ...senão, o segundo elemento passa a ser o "head"
		// ajusta o total de elementos e retorna o removido
		E aux = head.element;
		if(head != tail)
			head.setNext(head.next);
		else
			head = tail = null;
		numElements--;
		return aux;
	}
	public E removeLast() {
		// guarda uma referência temporária ao elemento sendo removido
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		// ...senão, é necessário percorrer o encadeamento
		// até chegar ao nó imediatamente anterior ao último...
		// ...para poder torná-lo o novo "tail"
		// ajusta o total de elementos e retorna o removido

		Node<E> last = tail;
		Node<E> first = head;
		if(numElements == 1)
			head = tail = null;

		for (int i = 0; i < numElements; i++) {
			if(first.next == tail)
				first.setNext(null);
			else 
				first = first.getNext();
		}

		return last.element;
	}
	public void insert(E element, int pos) {

		Node<E> tempNode = head;
		if(pos < numElements +1)
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < numElements; i++) {
			if(i == pos){
				Node<E> newNode = new Node<E>(element);
				newNode.next = tempNode.getNext();
				tempNode.setNext(newNode);
			}	
			else{
				tempNode = tempNode.getNext();
			}
		}
	}
	public E remove(int pos) {
		Node<E> tempNode = head;
		E removed = null;
		if(pos < numElements)
			throw new IndexOutOfBoundsException();
		else if(pos == 1){
			removed = get(pos);
			removeFirst();
		} else if(pos == numElements -1){
			removed = get(pos);
			removeLast();
		} else 			
			for (int i = 0; i < numElements; i++) {
				if(i == pos -1){
					removed = tempNode.getNext().element;
					tempNode.setNext(tempNode.getNext().getNext());
				}	
				else{
					tempNode = tempNode.getNext();
				}
			}
		return removed;
	}
	public int search(E element) {
		// percorre o encadeamento até encontrar o elemento
		Node<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}

		// se chegar até aqui, é porque não encontrou
		return -1;
	}
	public String toString() {

		String retorno = "";
		Node<E> current = head;
		int i = 0;
		while (current != null) {
			retorno += "[ " + current.toString() + "] \n";
			i++;
			current = current.getNext();
		}
		return retorno;
	}

	@Override
	public E get(int pos) {
		Node<E> current = head;
		int i = 0;
		if(pos > numElements)
			throw new IndexOutOfBoundsException();
		
		while (i != pos) {
			current = current.getNext();
		}
		return current.element;
	}
}
