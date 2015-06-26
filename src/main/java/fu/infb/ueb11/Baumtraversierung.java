package fu.infb.ueb11;

import java.util.ArrayList;
import java.util.List;

/**
 * As the tree this method is also configurable via java generics.
 * Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
 */
public class Baumtraversierung<E extends Comparable<E>> {

	private List<E> post;
	private List<E> in;
	private List<E> pre;
	private BinaryTree<E> tree;

	/**
	 * This method gets the param tree being inflated previously.
	 * Then three lists gets initialized, which will store the order.
	 * The search process will start with the first (0-based) element.
	 */
	@SuppressWarnings("unchecked")
	public void traversiereEulisch(BinaryTree<E> t) {
		post = new ArrayList<E>();
		in = new ArrayList<E>();
		pre = new ArrayList<E>();
		tree = t;

		BinaryNode<E> firstElement = t.getElement(0);

		traversiereRecursively(firstElement);

		print(pre, "Pre-Order");
		print(post, "Post-Order");
		print(in, "In-Order");
	}

	/**
	 * This method goes through the binary tree recursively until 
	 * all elements are covered (deep search, DFS).
	 * If the algorithm achieves the specific position, 
	 * the current element will be added to the particular list.
	 */
	public void traversiereRecursively(BinaryNode<E> element) {
		pre.add(element.getValue());
		int[] nodes = new int[] { element.getLeftChild(),
				element.getRightChild() };

		for (int i = 0; i < nodes.length; i++) {
			if (i == 1) {
				in.add(element.getValue());
			}
			if (nodes[i] > -1 && nodes[i] < tree.getSize()) {
				BinaryNode<E> binaryNode = tree.getElement(nodes[i]);
				if (binaryNode != null) {
					traversiereRecursively(binaryNode);
				}
			}
		}

		post.add(element.getValue());
	}

	/**
	 * This method prints each list containing ordered elements.
	 */
	private void print(List<E> list, String name) {
		StringBuilder b = new StringBuilder();
		b.append(name + "\n");
		for (E e : list) {
			b.append(e + " ");
		}
		System.out.println(b.toString());
	}

}
