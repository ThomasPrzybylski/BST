import java.util.Collection;
import java.util.LinkedList;

public class Bst<T extends Comparable<T>> implements BSTInterface<T> {
	BSTNode<T> root, current, previous;
	Collection<T> output;
	int size = 0;

	public Bst() {
		root = null;
	}

	public void add(T element) {
		if(root==null)
		{
			BSTNode<T> newNode = new BSTNode<T>(element);
			root = newNode;
			size = 1;
		}
		else{
			boolean left = false;
			current = root;
			previous = current;
			while (current != null) {
				if (element.compareTo(current.getElement()) <= 0) {
					// left
					left = true;
					previous = current;
					current = current.getLeft();
					previous.setLeft(current);
				} else {
					// right
					left = false;
					previous = current;
					current = current.getRight();
					previous.setRight(current);
				}
			}
			BSTNode<T> newNode = new BSTNode<T>(element);
			current = newNode;
			size++;
			if(left)
			{
				previous.setLeft(current);
			}
			else
			{
				previous.setRight(current);
			}


			if(isEmpty()) {
				root = current;
			}
		}
	}

	@Override
	public T search(T element) throws BSTUnderflowException {
		current = root;
		previous = current;
		while (current != null&&!(current.getElement() == (element))) {
			if (element.compareTo(current.getElement()) <= 0) {
				// left
				previous = current;
				current = current.getLeft();
				previous.setLeft(current);
			} else {
				// right
				previous = current;
				current = current.getRight();
				previous.setRight(current);
			}
		}
		if(current != null)
		{
			if((current.getElement() == (element)))
				return current.getElement();
		}
		return null;
	}

	@Override
	public T remove(T element) throws BSTUnderflowException {
		boolean left = false;
		current = root;
		previous = current;
		while (!(current.getElement() == (element))&&current != null) {
			if (element.compareTo(current.getElement()) < 0) {
				// left
				left = true;
				previous = current;
				current = current.getLeft();
				previous.setLeft(current);
			} else {
				// right
				left = false;
				previous = current;
				current = current.getRight();
				previous.setRight(current);
			}
		}
		if(current.getElement().equals(element)){
			BSTNode<T> out = current;
			current = null;
			size--;
			if(left)
			{
				previous.setLeft(current);
			}
			else
			{
				previous.setRight(current);
			}
			return out.getElement();
		}
		else 
			return null;
	}


	@Override
	public boolean contains(T element) throws BSTUnderflowException {
		current = root;
		previous = current;
		while (current != null&&!(current.getElement() == (element))) {
			if (element.compareTo(current.getElement()) <= 0) {
				// left
				previous = current;
				current = current.getLeft();
				previous.setLeft(current);
			} else {
				// right
				previous = current;
				current = current.getRight();
				previous.setRight(current);
			}
		}
		if(current != null)
		{
			if((current.getElement() == (element)))
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Collection<T> traversal(Order order) {
		output = new LinkedList<T>();
		if (!isEmpty()) {

			if (order == Order.INORDER) {
				// LRootR
				getInorder(root);
			} else if (order == Order.POSTORDER) {
				// LRRoot
				getPostorder(root);

			} else if (order == Order.PREORDER) {
				// RootLR
				getPreorder(root);
			}
			return output;
		}
		return output;
	}

	private void getPreorder(BSTNode<T> r) {

		output.add(r.getElement());
		getInorder(r.getLeft());
		getInorder(r.getRight());

	}

	private void getPostorder(BSTNode<T> r) {

		getInorder(r.getLeft());
		getInorder(r.getRight());
		output.add(r.getElement());

	}

	private void getInorder(BSTNode<T> r)
	{
		if(r.getLeft() != null)
			getInorder(r.getLeft());
		output.add(r.getElement());
		if(r.getRight() != null)
			getInorder(r.getRight());


	}


}
