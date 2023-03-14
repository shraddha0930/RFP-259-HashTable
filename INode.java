public interface INode<T> {

	public T getKey();
	
	public void setKey(T key);
	
	public INode<T> getNext();
	
	public void setNext(INode<T> next);
	
	
	
}