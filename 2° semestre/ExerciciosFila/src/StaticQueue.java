/**
 * Implementa��o de uma Fila com armazenamento est�tico,
 * baseado em array.
 */
public class StaticQueue<E> implements Queue<E> {
	// �ndice para o primeiro elemento
	protected int first;

	// �ndice para o �ltimo elemento
	protected int last;

	// Array que armazena as refer�ncias para os elementos
	protected E elements[];

	/**
	 * Constr�i uma fila com um tamanho m�ximo.
	 * @param maxSize O tamanho m�ximo da fila
	 */
	public StaticQueue(int maxSize) {
		elements = (E[])new Object[maxSize];
		first = last = -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#isEmpty()
	 */
	public boolean isEmpty() {
		return first == -1;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#isFull()
	 */
	public boolean isFull() {
		return first == ((last + 1) % elements.length);
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#numElements()
	 */
	public int numElements() {
		if (isEmpty())
			return 0;
		else {
			int n = elements.length; // p/ legibilidade da express�o abaixo
			return ((n + last - first) % n) + 1;
		}
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#enqueue(java.lang.Object)
	 */
	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else {
			if (last == -1)
				first = last = 0;
			else
				last = (last + 1) % elements.length;
			elements[last] = element;
		}

	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#dequeue()
	 */
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;

		return element;
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#front()
	 */
	public E front() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[first];
	}

	/* (non-Javadoc)
	 * @see br.unisinos.prog2lab2.Queue#back()
	 */
	public E back() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return elements[last];
	}

	/**
	 * Retorna uma representa��o String da fila.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (isEmpty())
			return "[Empty]";
		else {
			String s = "[" + elements[first];
			int n = numElements();
			for (int i = 1; i < n; i++) {
				int k = (first + i) % elements.length;
				s += ", " + elements[k];
			}
			s += "]";
			return s;
		}
	}
}
