package fu.infb.ueb07;

public class Prim {
	public static void printPrim(int until) {
		for (int underTest = 1; underTest <= until; underTest++) {
			boolean isPrimeNumber = true;
			for (int var = 2; var < underTest; var++) {
				if (underTest % var == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				System.out.println("is prime number: " + underTest);
			}
		}
	}
}