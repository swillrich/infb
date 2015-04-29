package infb;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Graph extends ArrayList<Character> {

	private boolean[][] matrix;

	public void initMatrix() {
		this.matrix = new boolean[size()][size()];
		for (int i = 0; i < size(); i++) {
			for (int j = 0; j < size(); j++) {
				if (i != j) {
					this.matrix[i][j] = true;
				}
			}
		}
	}

	public boolean[][] getMatrix() {
		return matrix;
	}

	public void printMatrix() {
		Character[] array = toArray(new Character[size()]);
		String printOut = "";
		for (int i = 0; i < array.length; i++) {
			printOut += array[i] + "  ";
		}
		System.out.println("   " + printOut);

		for (int i = 0; i < this.matrix.length; i++) {
			printOut = array[i] + "  ";
			for (int j = 0; j < this.matrix.length; j++) {
				printOut += this.matrix[i][j] ? "1  " : "0  ";
			}
			System.out.println(printOut);
		}
	}

	public void inflateAlphabetically(int size) {
		for (int i = 65; i < 65 + size; i++) {
			char node = (char) i;
			add(node);
		}
	}
}