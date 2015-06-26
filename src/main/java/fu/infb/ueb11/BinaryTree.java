package fu.infb.ueb11;

/**
 * Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
 */
@SuppressWarnings("unchecked")
public class BinaryTree<E extends Comparable<E>> {
	private BinaryNode<E>[] nodes;
	private int lastPos = -1;

	public int getLastPos() {
		return lastPos;
	}

	public BinaryNode<E> getElement(int pos) throws IndexOutOfBoundsException {
		return nodes[pos];
	}

	public BinaryTree() {
		//initialize the tree size with 1
		this.nodes = new BinaryNode[1];
	}

	/**
	 * This method adds a new value considering the correct order.
	 */
	public void add(E value) {

		int pos = getPos(0, value);

		if (pos > lastPos) {
			lastPos = pos;
		}

		BinaryNode<E> node = new BinaryNode<E>();
		node.setValue(value);
		node.setLeftChild(2 * pos + 1);
		node.setRightChild(2 * pos + 2);
		this.nodes[pos] = node;
		reconfigureTreeSize();

		printState();
	}

	/**
	 * Searches for the new position to which the element should be added (recursively). 
	 */
	private int getPos(int pos, E value) {
		if (this.nodes[pos] == null) {
			return pos;
		}

		int subPos = this.nodes[pos].getValue().compareTo(value) == 1 ? this.nodes[pos]
				.getLeftChild() : this.nodes[pos].getRightChild();

		return getPos(subPos, value);
	}

	/**
	 * This method handles the tree size dynamically.
	 * There are two conditions which apply.
	 * i)  If lastPos * 2 is >= tree size -> tree size * 2
	 * ii) If lastPos < tree size / 2 --> treesize / 2 
	 */
	private void reconfigureTreeSize() {
		BinaryNode<E>[] newArr = null;
		int tmpLastPos = this.lastPos + 1;
		if (tmpLastPos * 2 >= this.nodes.length) {
			newArr = new BinaryNode[(this.nodes.length + 1) * 2 - 1];
		} else if (tmpLastPos * 2 < ((this.nodes.length + 1) / 2) - 1) {
			newArr = new BinaryNode[(int) (((this.nodes.length + 1) / 2) - 1)];
		}

		if (newArr != null) {
			for (int i = 0; i <= this.lastPos; i++) {
				newArr[i] = this.nodes[i];
			}
			this.nodes = newArr;
		}
	}

	/**
	 * Just for showing the current tree state. This method prints out the content of
	 * the tree as table.
	 */
	public void printState() {
		String[] columns = "pos value lChild rChild isLast".split(" ");
		String format = "";
		String underLine = "";
		for (int i = 0, length = 10; i < columns.length; i++) {
			format += "%-" + length + "s";
			for (int ii = 0; ii < length; ii++) {
				underLine += "=";
			}
		}
		String title = String.format(format, (Object[]) columns);

		System.out.println("print content of tree:".toUpperCase());
		System.out.println("current size: " + this.nodes.length
				+ "\nlast pos: " + lastPos);
		System.out.println(title);
		System.out.println(underLine);
		for (int pos = 0; pos <= lastPos; pos++) {
			BinaryNode<E> node;
			if (pos >= this.nodes.length) {
				node = null;
			} else {
				node = this.nodes[pos];
			}
			if (node == null) {
				columns[1] = "";
				columns[2] = "";
				columns[3] = "";
				columns[4] = String.valueOf(pos == lastPos ? "x" : "");
			} else {
				columns[1] = String.valueOf(node.getValue());
				columns[2] = String.valueOf(node.getLeftChild());
				columns[3] = String.valueOf(node.getRightChild());
				columns[4] = String.valueOf(pos == lastPos ? "x" : "");
			}
			columns[0] = String.valueOf(pos);
			System.out.println(String.format(format, (Object[]) columns));

		}
		System.out.println();
	}

	public int getSize() {
		return this.nodes.length;
	}

}
