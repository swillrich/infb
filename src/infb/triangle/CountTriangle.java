package infb.triangle;

import infb.Graph;

import java.util.Set;
import java.util.TreeSet;

public class CountTriangle {
	public static Set<Triangle> countTriangle(Graph g) {
		Set<Triangle> triangles = new TreeSet<Triangle>();

		for (int i1 = 0; i1 < g.size(); i1++) {
			for (int i2 = 0; i2 < g.size(); i2++) {
				for (int i3 = 0; i3 < g.size(); i3++) {
					//no loops
					if (i1 != i2 && i2 != i3 && i1 != i3) {
						Triangle triangle = new Triangle(g.get(i1), g.get(i2),
								g.get(i3));
						triangles.add(triangle);
					}
				}
			}
		}
		return triangles;
	}
}
