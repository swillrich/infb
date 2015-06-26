package fu.infb.ueb11;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		int[] sample = new int[] { 5, 10, 2, 7, 9, 1, 3, 15 };
		for (int i : sample) {
			binaryTree.add(i);
		}
		new Baumtraversierung<Integer>().traversiereEulisch(binaryTree);
	}
}
