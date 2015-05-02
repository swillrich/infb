package fu.infb;

import fu.infb.alg.TotaleSenke;


public class Main {
	public static void main(String[] args) {
		CustomGraph g = new CustomGraph();
		TotaleSenke.find(g);
	}
}
