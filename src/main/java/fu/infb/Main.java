package fu.infb;

import fu.infb.ueb08.StringInventing;

public class Main {
	public static void main(String[] args) {
		uebung8aufgabe1();
		
	}

	private static void uebung8aufgabe1() {
		StringInventing sI = new StringInventing();
		sI.generateString(200);
		sI.invertByString();
		sI.invertByStringBuilder();
		sI.invertByStringBuffer();
	}
}
