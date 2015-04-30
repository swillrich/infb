package fu.infb;

import fu.infb.alg.TopologischeSortierung;


public class Main {
	public static void main(String[] args) {
		CustomGraph g = new CustomGraph();
		g.printMatrix();
		System.out.println();
		TopologischeSortierung.go(g);
	}
}
