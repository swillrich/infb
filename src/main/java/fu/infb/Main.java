package fu.infb;

import fu.infb.alg.BFS;
import fu.infb.alg.DFS;


public class Main {
	public static void main(String[] args) {
		CustomGraph g = new CustomGraph();
		g.printMatrix();
		System.out.println();
		DFS.go(g);
		g.initStates();
		BFS.go(g);
	}
}
