package fu.infb.ueb11;

import java.util.ArrayList;
import java.util.List;

public class Baumtraversierung<E extends Comparable<E>> {

	private List<E> post;
	private List<E> in;
	private List<E> pre;
	private BinaryTree<E> tree;

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

	private void print(List<E> list, String name) {
		StringBuilder b = new StringBuilder();
		b.append(name + "\n");
		for (E e : list) {
			b.append(e + " ");
		}
		System.out.println(b.toString());
	}

}
