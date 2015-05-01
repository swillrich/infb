package fu.infb;

public class CustomGraph extends Graph {
	public CustomGraph() {
		inflateNumerically(getCustomMatrix().length);
		setMatrix(transform(getCustomMatrix()));
	}

//	�bung 2, Aufgabe 1
//	private int[][] getCustomMatrix() {
//		return new int[][] {
//				{0, 1, 1, 0, 0, 0, 0},
//				{0, 0, 1, 1, 1, 0, 0},
//				{0, 0, 0, 0, 0, 1, 0},
//				{0, 0, 0, 0, 0, 0, 1},
//				{1, 0, 0, 1, 0, 0, 0},
//				{0, 0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 0, 1, 0, 0}
//		};
//	}
	
//	�bung 2, Aufgabe 2
	private int[][] getCustomMatrix() {
	return new int[][] {
			{0, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 1, 1, 0, 0, 0},
			{0, 1, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 1, 0},
			{0, 0, 0, 1, 1, 0, 0, 1},
			{0, 0, 1, 0, 1, 0, 0, 0}
		};
	}
}
