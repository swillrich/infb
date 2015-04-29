package infb.triangle;

import infb.Graph;

import java.util.ArrayList;
import java.util.List;

public class CountTriangle {

	public static int k = 3;

	public static List<Triangle> countTriangle(Graph g) {
		List<Triangle> triangles = new ArrayList<Triangle>() {
			@Override
			public boolean add(Triangle e) {
				for (Triangle t : this) {
					if (e.equals(t)) {
						return false;
					}
				}
				return super.add(e);
			}
		};

		for (int i1 = 0; i1 < g.size(); i1++) {
			for (int i2 = 0; i2 < g.size(); i2++) {
				for (int i3 = 0; i3 < g.size(); i3++) {
					// no loops
					if (i1 != i2 && i2 != i3 && i1 != i3) {
						Triangle triangle = new Triangle(g.get(i1), g.get(i2),
								g.get(i3));
						boolean add = triangles.add(triangle);
					}
				}
			}
		}
		return triangles;
	}

	public static int countTriangleByMatrix(Graph g) {
		g.printMatrix();

		int counter = 0;

		boolean[][] matrix = g.getMatrix();

		for (int i = 0; i < g.size(); i++) {
			counter += searchInto(matrix, i, 0, i);
		}

		return counter;
	}

	private static int searchInto(boolean[][] matrix, int startRow,
			int tmpTriangleCounter, int ref) {
		int counter = 0;
		for (int j = startRow; j < matrix.length; j++) {
			if (matrix[startRow][j]) {
				counter += searchInto(matrix, j, tmpTriangleCounter + 1, ref);
			}
			if (tmpTriangleCounter == k - 1) {
				if (matrix[startRow][ref]) {
					return 1;
				}
			}
		}
		return counter;
	}

	public static int countShapes(int n) {
		double result = factorial(n) / (factorial(k) * factorial(n - k));
		return (int) result;
	}

	private static long factorial(int n) {
		return n == 0 ? 1 : n * factorial(n - 1);
	}
}