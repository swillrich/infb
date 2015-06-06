package fu.infb.ueb08;

public class Pi {
	// approximiert pi
	public static double approximiere(int iterations) {
		// z�hlt, wie oft das Ergebnis kleiner/gleich eins war
		int isBetween = 0;
		// durchl�uft so viele Iterationen, wie angegeben
		for (int i = 0; i < iterations; i++) {
			// generiert zwei zuf�llige Zahlen mit drei Nachkommastellen, f�r
			// die gilt 0 <= x <= 1
			double dotx = Math.round(Math.random() * 1000.) / 1000.;
			double doty = Math.round(Math.random() * 1000.) / 1000.;

			// wenn kleiner/gleich eins, ist es enthalten
			if (dotx * dotx + doty * doty <= 1) {
				isBetween++;
			}
		}

		// Konsolenausgabe
		return 4 * (double) isBetween / iterations;
	}
}
