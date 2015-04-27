package infb;

import static infb.triangle.CountTriangle.countTriangle;
import infb.triangle.Triangle;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.inflateAlphabetically(5);

		System.out.println("generate graph with: " + g.toString());

		List<Triangle> triangles = countTriangle(g);
		System.out.println("triangle elements: " + triangles);
		System.out.println("count of triangles: " + triangles.size() + "\n");
		System.out.println("count by formular: " + countTriangle(5));
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
