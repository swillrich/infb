package infb;

import static infb.triangle.CountTriangle.countTriangle;
import static infb.triangle.CountTriangle.countTriangleByMatrix;
import infb.triangle.Triangle;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.inflateAlphabetically(5);

		System.out.println("generate graph with: " + g.toString());

		List<Triangle> triangles = countTriangle(g);
		System.out.println("triangle elements by duplicates: " + triangles);
		System.out.println("triangle elements by duplicates, size: " + triangles.size());
		System.out.println("count by formular: " + countTriangle(g.size()));
		System.out.println("count by matrix:  " + countTriangleByMatrix(g));
	}

	private static void testWithSequence(int lesserBound, int upperBound) {
		for (int i = lesserBound; i <= upperBound; i++) {
			Graph g = new Graph();
			g.inflateAlphabetically(i);
			List<Triangle> triangles = countTriangle(g);
			System.out.println("graph: " + g);
			System.out.println("count: " + triangles.size() + " elements: "
					+ triangles);
		}
	}
}
