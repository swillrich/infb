package infb;

import java.util.ArrayList;

public class Graph extends ArrayList<Character> {
	public void inflateAlphabetically(int size) {
		for (int i = 65; i < 65 + size; i++) {
			char node = (char) i;
			add(node);
		}
	}
}