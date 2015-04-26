package infb.triangle;
import java.util.Arrays;
import java.util.List;

public class Triangle implements Comparable<Triangle> {
	private Character[] nodes = new Character[3];

	public Character[] getNodes() {
		return nodes;
	}

	public Triangle(Character... nodes) {
		this.nodes = nodes;
	}

	public boolean contains(Character a) {
		List<Character> list = Arrays.asList(nodes);
		return list.contains(a);
	}

	@Override
	public String toString() {
		return Arrays.asList(nodes).toString();
	}
	@Override
	public int compareTo(Triangle arg0) {
		int equalsCounter = 0;
		for (int i = 0; i < getNodes().length; i++) {
			if (arg0.contains(getNodes()[i])) {
				equalsCounter = equalsCounter + 1;
			}
		}
		return equalsCounter == 3 ? 0 : -1;
	}
}
