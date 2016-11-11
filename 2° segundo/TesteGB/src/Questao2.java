
public class Questao2 {
	public StaticQueue<Pessoa> retiraNovatos(StaticQueue<Pessoa> sQue){
		
		StaticQueue<Pessoa> listSemNovatos = new StaticQueue<>(sQue.numElements());
		
		for(int i = 0; i < sQue.numElements(); i++){
			Pessoa p = sQue.dequeue();
			if(p.getIdade() >= 16)
				listSemNovatos.enqueue(p);
		}		
		sQue = listSemNovatos;		
		return sQue;
	}
}
