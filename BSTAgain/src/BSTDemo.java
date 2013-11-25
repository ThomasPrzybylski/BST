import java.util.Collection;


public class BSTDemo {

	/**
	 * @param args
	 * @throws BSTUnderflowException 
	 */
	public static void main(String[] args) throws BSTUnderflowException {
		// TODO Auto-generated method stub
		Collection <Character> alist;
		Bst <Character>abst = new Bst<Character>();
		abst.add('D');
		abst.add('A');
		abst.add('G');
		abst.add('F');
		alist = abst.traversal(Order.INORDER);
		//ADFG
		System.out.println(alist.toString());
		System.out.println(abst.size());
		System.out.println(abst.search('A'));
		System.out.println(abst.search('Z'));
		alist = abst.traversal(Order.PREORDER);
		//DAFG
		System.out.println(alist.toString());
		alist = abst.traversal(Order.POSTORDER);
		//AFGD
		System.out.println(alist.toString());
		abst.remove('F');
		alist = abst.traversal(Order.INORDER);
		//ADFG
		System.out.println(alist.toString());
		System.out.println(abst.size());
		abst.remove('G');
		alist = abst.traversal(Order.INORDER);
		//ADFG
		System.out.println(alist.toString());
	}

}
