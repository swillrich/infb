package fu.infb.alg;

import java.util.ArrayList;
import java.util.List;

import fu.infb.Graph;
import fu.infb.Graph.State;

public class BFS {

	public static void go(final Graph g) {
		System.out.println("Perform BFS\n");
		new BFS(g).work();
	}

	private void alreadyDiscovered(int j) {
		System.out.println(getQueueAsString() + "Try to add node " + g.get(j)
				+ " to queue, but node is not new");
	}

	private void discovered(int i) {
		System.out.println(getQueueAsString() + "Add node " + g.get(i)
				+ " to queue");
	}

	private void finished(int i) {
		System.out.println(getQueueAsString() + "Remove node " + g.get(i)
				+ " from queue");
	}

	private Graph g;
	private boolean[][] matrix;
	private State[] states;
	private List<Integer> queue;

	public BFS(Graph g) {
		this.g = g;
		this.matrix = g.getMatrix();
		this.states = g.getStates();
		this.queue = new ArrayList<Integer>();
	}

	public void work() {
		// initializing
		System.out.println("starts with node: " + g.get(0));
		states[0].setDiscovered(true);
		for (int i = 0; i < g.size(); i++) {
			if (matrix[0][i] && 0 != i) {
				queue.add(i);
				discovered(i);
				states[i].setDiscovered(true);
			}
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < g.size(); i++) {
				if (matrix[queue.get(0)][i] && !states[i].isDiscovered()) {
					queue.add(i);
					discovered(i);
					states[i].setDiscovered(true);
				} else if (matrix[queue.get(0)][i] && states[i].isDiscovered()) {
					alreadyDiscovered(i);
				}
			}
			Integer removedEntry = queue.remove(0);
			finished(removedEntry);
			states[removedEntry].setFinished(true);
		}
	}

	private String getQueueAsString() {
		String result = "";
		for (int i = 0; i < g.size(); i++) {
			if (queue.size() > i) {
				result += g.get(queue.get(i));
			} else {
				result += " ";
			}

		}
		return "queue [" + result + "] <- ";
	}
}
