public class DNode<E> {
	protected E element;
	protected DNode<E> next;
	protected DNode<E> previous;
	
	public DNode(E e) {
		element = e;
		next = null;
		previous = null;
	}

	public E getElement() {
		return element; 
	}

	public DNode<E> getNext() { 
		return next;
	}

	public DNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<E> previous) {
		this.previous = previous;
	}

	public void setElement(E e) { 
		element = e; 
	}

	public void setNext(DNode<E> n) {
		next = n; 
	}
	
	@Override
	public String toString() {
		return " Elemento ["+element.toString() + "] anterior [" + (previous != null ? previous.getElement() : "null" )+ "] [proximo [" + (next != null ? next.getElement() : "null" )+ "]";
	}
}

