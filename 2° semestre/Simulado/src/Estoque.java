
public class Estoque<T> {
	private T obj;

	public Estoque(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Estoque [obj=" + obj.toString() + "]";
	}
	
	public <T extends Produto> void imprimeInformacoesProduto(T  object){
		System.out.println(object.toString());
	}
}
