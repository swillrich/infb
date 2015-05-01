package fu.infb.alg;

import java.util.ArrayList;
import java.util.Collections;
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
		this.order.add(i);
	}

	private void printOrder() {
		System.out.println("\nTopological sorting:");
		for (int i = 0; i < order.size(); i++) {
			System.out.println("at [" + (i + 1) + "] = node "
					+ g.get(order.get(i)));
		}
	}

	private Graph g;
	private boolean[][] matrix;
	private State[] states;
	private List<Integer> order;

	public TopologischeSortierung(Graph g) {
		this.g = g;
		this.matrix = g.getMatrix();
		this.states = g.getStates();
		this.order = new ArrayList<Integer>();
	}

	public void work() {
		for (int i = 0; i < g.size(); i++) {
			goDeeper(i);
		}
		Collections.reverse(order);
		printOrder();
		if (!isGraphDag(matrix, order)) {
			System.out
					.println("given graph is a dag, order condition violated");
		} else {
			System.out.println("given graph is a dag");
		}
	}

	private boolean isGraphDag(boolean[][] matrix, List<Integer> order) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					boolean validOrder = order.indexOf(i) <= order.indexOf(j);
					if (!validOrder) {
						return false;
					}
				}
			}
		}
		return true;
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
