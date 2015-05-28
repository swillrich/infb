package fu.infb.ueb07;

public class Prim {
	// gibt alle Zahlen von 1 bis "until" aus, die Primzahlen sind
	public static void printPrim(int until) {
		// Läuft ab 1 und wird inkrementiert, bis kleiner/gleich "util" ist
		for (int underTest = 1; underTest <= until; underTest++) {
			// speichert, ob es sich bei der aktuellen Primzahl (underTest) um
			// eine Primzahl handelt; default ist true
			boolean isPrimeNumber = true;
			// prüft für die aktuelle Zahl, ob sie eine Primzahl ist
			for (int var = 2; var < underTest; var++) {
				// Wenn underTest eine Primzahl ist, ist der Divisionsrest NIE
				// 0, außer bei 1 und sich selbst
				if (underTest % var == 0) {
					// Ist der Divisionsrest 0, kann es keine Primzahl sein.
					isPrimeNumber = false;
					break;
				}
			}

			// handelt es sich bei der aktuellen Zahl um eine Primzahl, wird sie
			// ausgegeben
			if (isPrimeNumber) {
				System.out.println("is prime number: " + underTest);
			}
		}
	}
}