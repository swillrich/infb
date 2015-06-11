package fu.infb.ueb08;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE08)
public class Pi {

	public static void main(String[] args) {
		try {
			if (args.length != 1 && Integer.valueOf(args[0]) > 0) {
				new IllegalArgumentException();
			}
			double approximiere = new Pi().approximiere(Integer
					.valueOf(args[0]));
			System.out.printf("%-15d%-10s%n", Integer.valueOf(args[0]),
					approximiere);
		} catch (Exception e) {
			new Exception("wrong number of arguments or not an integer", e);
		}
	}

	// approximiert pi
	public double approximiere(int iterations) {
		// zaehlt, wie oft das Ergebnis kleiner/gleich eins war
		int isBetween = 0;
		// durchlaeuft so viele Iterationen, wie angegeben
		for (int i = 0; i < iterations; i++) {
			// generiert zwei zufaellige Zahlen mit drei Nachkommastellen, fuer
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
