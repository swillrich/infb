package fu.infb.triangle;

import java.util.Arrays;
import java.util.List;

public class Triangle {
	private String[] nodes = new String[3];

	public Triangle(String... nodes) {
		setNodes(nodes);
	}

	public String[] getNodes() {
		return nodes;
	}

	public void setNodes(String[] nodes) {
		this.nodes = nodes;
	}

	public boolean contains(String a) {
		List<String> list = Arrays.asList(nodes);
		return list.contains(a);
	}

	@Override
	public String toString() {
		return Arrays.asList(nodes).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Triangle) {
			Triangle arg0 = (Triangle) obj;
			int equalsCounter = 0;
			for (int i = 0; i < getNodes().length; i++) {
				if (arg0.contains(getNodes()[i])) {
					equalsCounter = equalsCounter + 1;
				}
			}
			return equalsCounter == 3;
		}
		return super.equals(obj);
	}
}
