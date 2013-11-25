import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class CirQueue<T> implements Queue<T> {

	Node rear, current, previous;

	public CirQueue() {
		rear = null;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object element) {
		boolean found = false;
		current = rear.getLink();
		previous = rear;
		do {
			if (current.getData().equals(element)) {
				found = true;
				break;
			} else if (current == rear) {
				found = false;
			}
			previous = current;
			current = current.getLink();
		} while (current != rear.getLink());
		return found;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object element) {
		boolean found = true;
		if (contains(element)) {

			if (current == rear) {
				// last
				rear = previous;
			}
			// between
			previous.setLink(current.getLink());

		} else {
			found = false;
		}
		return found;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(T element) {

		Node newNode = new Node(element, null);
		if (isEmpty()) {
			rear = newNode;
		} else {
			newNode.setLink(rear.getLink());
		}
		rear.setLink(newNode);
		rear = newNode;

		return true;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		String list = "[";
		if (isEmpty()) {
			try {
				throw new QueueUnderflowException("Empty List!");
			} catch (QueueUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			current = rear.getLink();
			do {
				if (current == rear) {
					list += current.getData();
				} else {
					list += current.getData() + ", ";
				}
				current = current.getLink();
			} while (current != rear.getLink());
		}
		list += "]";
		return list;
	}

}
