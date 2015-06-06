package fu.infb;

import fu.infb.ueb08.PartialSum;
import fu.infb.ueb08.Pi;
import fu.infb.ueb08.StringInventing;

public class Main {
	public static void main(String[] args) {
		uebung8aufgabe1();
		uebung8aufgabe2();
		uebung8aufgabe3();
	}

	private static void uebung8aufgabe3() {
		int[] test = new int[] { -3, 11, -4, 13, -5, 2 };
		int biggestPartialSum = PartialSum.biggestPartialSum(test);
		System.out.println(biggestPartialSum);
	}

	private static void uebung8aufgabe2() {
		System.out.printf("%-15s%-10s%n", "iterations", "result");
		for (int integer : new int[] { 100, 200, 1000, 10000, 500, 5 }) {
			double approximiere = Pi.approximiere(integer);
			System.out.printf("%-15d%-10s%n", integer, approximiere);
		}

	}

	private static void uebung8aufgabe1() {
		StringInventing sI = new StringInventing();
		sI.generateString(200);
		sI.invertByString();
		sI.invertByStringBuilder();
		sI.invertByStringBuffer();
	}
}
