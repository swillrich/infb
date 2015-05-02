package fu.infb.alg;

import java.util.ArrayList;
import java.util.List;

import fu.infb.Graph;

public class TotaleSenke {
	public static void find(Graph g) {
		List<String> queue = new ArrayList<String>(g);

		int i = 0;
		int j = 0;
		
		while (j + 1 < g.size()) {
			j = j + 1;
			if (g.getMatrix()[i][j]) {
				queue.remove(g.get(i));
				i = j;
			} else {
				queue.remove(g.get(j));
			}
			System.out.println(queue);
		}
	}
}
