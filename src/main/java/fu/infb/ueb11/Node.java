package fu.infb.ueb11;

public abstract class Node<E> {
	private Node[] kinds;
	private E value;

	public Node(int numberOfKinds) {
		kinds = new Node[numberOfKinds];
	}

	public Node(int numberOfKinds, E value) {
		kinds = new Node[numberOfKinds];
		this.value = value;
	}

	public void setValue(int pos, E value) {
		this.kinds[pos] = (Node<E>) value;
	}

	public E getValue(int pos) {
		return (E) kinds[pos].value;
	}
}