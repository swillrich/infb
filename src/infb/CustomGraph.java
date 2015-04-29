package infb;

public class CustomGraph extends Graph {
	public CustomGraph() {
		inflateAlphabetically(getCustomMatrix().length);
		setMatrix(transform(getCustomMatrix()));
	}

	private int[][] getCustomMatrix() {
		return new int[][] {
				{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 0}
		};
	}
}
