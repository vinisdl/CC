import java.util.Random;

public class Principal {
	public static void main(String[] args) {
		Principal p = new Principal();
		StaticQueue<Integer> q1 = new StaticQueue<>(2);

		q1.enqueue(1);
		q1.enqueue(2);

		StaticQueue<Integer> q2 = new StaticQueue<>(2);

		q2.enqueue(3);
		q2.enqueue(4);


		p.exercicio1(q1, q2);
	}


	public void exercicio1(Queue<Integer> q1,Queue<Integer> q2){
		StaticQueue<Integer> tempQ = new StaticQueue<>(q1.numElements() + q2.numElements());

		while(!q2.isEmpty()){
			tempQ.enqueue(q2.dequeue());
		}
		while(!q1.isEmpty()){
			tempQ.enqueue(q1.dequeue());
		}

		while(!tempQ.isEmpty()){
			System.out.println(tempQ.dequeue());
		}
	}
	
	public <E> void exterminateFromQueue(Queue<E> q, E element){
		
	}
}
