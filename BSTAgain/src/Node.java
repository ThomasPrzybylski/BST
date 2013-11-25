
public class Node <T> {
	private T data;
	private Node link;
	
	
	
	public Node(T data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
}
