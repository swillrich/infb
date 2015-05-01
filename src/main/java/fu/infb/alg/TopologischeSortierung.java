package fu.infb.alg;

import java.util.ArrayList;
import java.util.List;

import fu.infb.Graph;
import fu.infb.Graph.State;

public class TopologischeSortierung {

	public static void go(final Graph g) {
		System.out.println("Perform 'Topologische Sortierung'\n");
		new TopologischeSortierung(g).work();
	}

	private void alreadyDiscovered(int i, int j) {

	}

	private void discovered(int i) {
		System.out.println("discovered " + g.get(i) + " (grey)");
	}

	private void finished(int i) {
		System.out.println("finished " + g.get(i) + " (black)");
		this.order.add(g.get(i));
	}

	private void printOrder() {
		System.out.println("\nTopological sorting:");
		for (int i = order.size() - 1; i >= 0; i--) {
			System.out.println((order.size() - i) + " -> " + order.get(i));
		}
	}

	private Graph g;
	private boolean[][] matrix;
	private State[] states;
	private List<String> order;

	public TopologischeSortierung(Graph g) {
		this.g = g;
		this.matrix = g.getMatrix();
		this.states = g.getStates();
		this.order = new ArrayList<String>();
	}

	public void work() {
		for (int i = 0; i < g.size(); i++) {
			goDeeper(i);
		}
		printOrder();
	}

	private void goDeeper(int i) {
		if (states[i].isDiscovered()) {
			return;
		} else {
			discovered(i);
		}
		states[i].setDiscovered(true);
		for (int j = 0; j < g.size(); j++) {
			if (matrix[i][j] && !states[j].isDiscovered()) {
				goDeeper(j);
			} else if (matrix[i][j] && states[j].isDiscovered()) {
				alreadyDiscovered(i, j);
			}
		}
		finished(i);
		states[i].setFinished(true);
	}
}
