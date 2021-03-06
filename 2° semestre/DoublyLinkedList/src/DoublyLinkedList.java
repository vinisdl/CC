
public class DoublyLinkedList<E> implements List<E> {
	DNode<E> head;
	DNode<E> tail;
	int numElements;


	public DoublyLinkedList() {
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
		// cria um novo n— e o torna o novo "head"
		DNode<E> newDNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newDNode;
		else {
			newDNode.setNext(head);
			head.setPrevious(newDNode);
			head = newDNode;
		}

		// ajusta o total de elementos
		numElements++;
	}


	public void insertLast(E element) {
		// cria um novo n— e o torna o novo "tail"
		DNode<E> newDNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newDNode;
		else {
			newDNode.setPrevious(tail);
			tail.setNext(newDNode);
			tail = newDNode;			
		}

		// ajusta o total de elementos
		numElements++;
	}

	public void insert(E element, int pos) {
		// verifica se a posi�‹o Ž v‡lida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();

		// casos especiais: inser�‹o no in’cio...
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements) // ... ou inser�‹o no final
			insertLast(element);
		else { 

			DNode<E> current = head;
			for (int i = 0; i < pos; i++)
				current = current.getNext();

			// cria um novo n— e o posiciona logo ap—s "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newDNode = new DNode<E>(element);

			newDNode.setNext(current);
			newDNode.setPrevious(current.getPrevious());
			current.setPrevious(newDNode);
			numElements++;
		}
	}


	public E removeFirst() {
		// verifica se h‡ pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma refer�ncia tempor‡ria ao elemento sendo removido
		E element = head.getElement();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else
		{
			head = head.getNext();
			head.setPrevious(null);
		}

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}

	public E removeLast() {
		// verifica se h‡ pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma refer�ncia tempor‡ria ao elemento sendo removido
		E element = tail.getElement();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// ...sen‹o, Ž necess‡rio percorrer o encadeamento
			// atŽ chegar ao n— imediatamente anterior ao œltimo...
			DNode<E> prev = head;
			while (prev.getNext() != tail)
				prev = prev.getNext();

			// ...para poder torn‡-lo o novo "tail"

			tail = prev;
			prev.setNext(null);

		}

		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}


	public E remove(int pos) {
		// verifica se a posi�‹o Ž v‡lida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		// casos especiais: remo�‹o do in’cio...
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) // ... ou remo�‹o do final
			return removeLast();
		else { // caso geral: remo�‹o do meio da lista
			// localiza o n— imediatamente anterior ˆ posi�‹o
			// de onde o elemento ser‡ removido
			DNode<E> current = head;
			for (int i = 0; i < pos; i++)
				current = current.getNext();

			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());

			numElements--;
			return current.getElement();
		}
	}

	public E get(int pos) {
		// verifica se a posi�‹o Ž v‡lida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		// percorre o encadeamento atŽ chegar ao elemento
		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();

		return current.getElement();
	}


	public int search(E element) {
		// percorre o encadeamento atŽ encontrar o elemento
		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}

		// se chegar atŽ aqui, Ž porque n‹o encontrou
		return -1;
	}

	/**
	 * Retorna uma representa�‹o String da lista.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";

		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " ";
			current = current.getNext();
		}
		return s;
	}
}