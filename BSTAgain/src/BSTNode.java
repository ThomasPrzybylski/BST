
public class BSTNode<T extends Comparable<T>> {
	private T element;
	private BSTNode <T>left;
	private BSTNode <T>right;
	
	
	public BSTNode(T element) {
		super();
		this.element = element;
		this.left = null;
		this.right = null;		
	}
	
	public BSTNode(T element, BSTNode <T>left, BSTNode <T>right) {
		super();
		this.element = element;
		this.left = left;
		this.right = right;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public BSTNode <T>getLeft() {
		return left;
	}
	public void setLeft(BSTNode <T>left) {
		this.left = left;
	}
	public BSTNode <T>getRight() {
		return right;
	}
	public void setRight(BSTNode <T>right) {
		this.right = right;
	}
	
	
}
