package fu.infb.ueb11;

public class Main {
	/**
	 * Namen Martin Voges, Rico Koetschau, Sven Willrich (UE10)
	 */
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		
		//given the sample data as array and add 
		//these step-by-step to the binary tree
		int[] sample = new int[] { 8, 9, 8, 10, 15, 13, 12, 9, 0, 6, 2 };
		for (int i : sample) {
			binaryTree.add(i);
		}
		//after all data are added, the order algorithm is starting (pre, post, in)
		new Baumtraversierung<Integer>().traversiereEulisch(binaryTree);
	}
}
