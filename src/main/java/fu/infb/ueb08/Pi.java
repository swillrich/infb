package fu.infb.ueb08;

public class Pi {
	public static double approximiere(int iterations) {
		int isBetween = 0;
		for (int i = 0; i < iterations; i++) {
			double dotx = Math.round(Math.random() * 1000.) / 1000.;
			double doty = Math.round(Math.random() * 1000.) / 1000.;

			if (dotx * dotx + doty * doty <= 1) {
				isBetween++;
			}
		}

		return 4 * (double) isBetween / iterations;
	}
}
