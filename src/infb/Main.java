package infb;

import static infb.triangle.CountTriangle.countTriangle;
import infb.triangle.Triangle;

import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.inflateAlphabetically(4);

		System.out.println("generate graph with: " + g.toString());

		Set<Triangle> triangles = countTriangle(g);
		System.out.println("triangle elements: " + triangles);
		System.out.println("count of triangles: " + triangles.size() + "\n");
	}

	private static void testWithSequence(int lesserBound, int upperBound) {
		for (int i = lesserBound; i <= upperBound; i++) {
			Graph g = new Graph();
			g.inflateAlphabetically(i);
			Set<Triangle> triangles = countTriangle(g);
			System.out.println("graph: " + g);
			System.out.println("count: " + triangles.size() + " elements: "
					+ triangles);
		}
	}
}
