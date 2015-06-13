package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE08)
public class Geom3Demo {
	public static void main(String[] args) {
		// Beispielinstanzen
		Geom3D[] arr = new Geom3D[] { new Kugel(2), new Quader(2, 3, 4),
				new Tetraeder(4), new Wuerfel(4)

		};
		int totalVolume = 0;
		int totalSurfaceArea = 0;
		// berechnet für jede Beispielinstanz Fläche und Volumen
		// und addiert es mit jeder Iteration auf
		for (Geom3D element : arr) {
			totalVolume += element.volume();
			totalSurfaceArea += element.surfaceArea();
		}
		
		// Ausgabe der berechneten Werte
		System.out.println("total volume: " + totalVolume);
		System.out.println("total surface area: " + totalSurfaceArea);
	}
}
