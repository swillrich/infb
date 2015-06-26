package fu.infb.ueb11;

/**
 * Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
 */
public class BinaryNode<E> {
	private E value;
	private int rightChild = -1;
	private int leftChild = -1;

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public int getRightChild() {
		return rightChild;
	}

	public void setRightChild(int rightChild) {
		this.rightChild = rightChild;
	}

	public int getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(int leftChild) {
		this.leftChild = leftChild;
	}
	@Override
	public String toString() {
		return value.toString();
	}

}
