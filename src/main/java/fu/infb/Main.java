package fu.infb;

import fu.infb.ueb07.Prim;
import fu.infb.ueb07.RomanNotation;

public class Main {
	public static void main(String[] args) {
		Prim.printPrim(20);
		System.out.println();
		int[] sampleDates = new int[] { 119, 200, 214, 300, 304, 400, 468, 500,
				545, 600, 633, 700, 774, 800, 895, 900, 921, 1000 };
		for (int i = 0; i < sampleDates.length; i++) RomanNotation.convert(sampleDates[i]);
	}
}
