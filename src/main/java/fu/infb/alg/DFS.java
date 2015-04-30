package fu.infb.alg;

import fu.infb.Graph;
import fu.infb.Graph.State;

public class DFS {

	public static void go(final Graph g) {
		System.out.println("Perform DFS\n");
		new DFS(g).work();
	}

	private void alreadyDiscovered(int i, int j) {
		System.out.println("Try to go from node " + g.get(i) + " to node "
				+ g.get(j) + ", but it is already discovered or finished");
	}

	private void discovered(int i) {
		System.out.println("Discovered node: " + g.get(i));
	}

	private void finished(int i) {
		System.out.println("Finished node: " + g.get(i));
	}

	private Graph g;
	private boolean[][] matrix;
	private State[] states;

	public DFS(Graph g) {
		this.g = g;
		this.matrix = g.getMatrix();
		this.states = g.getStates();
	}

	public void work() {
		for (int i = 0; i < g.size(); i++) {
			goDeeper(i);
		}
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
