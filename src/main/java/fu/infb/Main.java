package fu.infb;

import static fu.infb.triangle.CountTriangle.countShapes;
import static fu.infb.triangle.CountTriangle.countTriangle;
import static fu.infb.triangle.CountTriangle.countTriangleByMatrix;
import fu.infb.triangle.CountTriangle;
import fu.infb.triangle.Triangle;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.inflateAlphabetically(6);
		g.initCompleteMatrix();
		CountTriangle.k = 3;

		System.out.println("generate graph with: " + g.toString());

		List<Triangle> triangles = countTriangle(g);
		System.out.println("triangle elements by duplicates: " + triangles);
		System.out.println("triangle elements by duplicates, size: "
				+ triangles.size());
		System.out.println("count by formular: " + countShapes(g.size()));
		System.out.println("count by matrix:  " + countTriangleByMatrix(g));

		System.out.println("custom non-complete graph: "
				+ countTriangleByMatrix(new CustomGraph()));
	}
}
