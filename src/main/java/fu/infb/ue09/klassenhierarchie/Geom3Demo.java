package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE09)
//This class is used to execute sample input and to demonstrate how it works
public class Geom3Demo {
	public static void main(String[] args) {
		// sample instances
		Geom3D[] arr = new Geom3D[] { new Kugel(2), new Quader(2, 3, 4),
				new Tetraeder(4), new Wuerfel(4)

		};
		int totalVolume = 0;
		int totalSurfaceArea = 0;
		// calculates for each body the data (volume and surface area) and add
		// each value up
		for (Geom3D element : arr) {
			totalVolume += element.volume();
			totalSurfaceArea += element.surfaceArea();
		}

		// Print results
		System.out.println("total volume: " + totalVolume);
		System.out.println("total surface area: " + totalSurfaceArea);
	}
}
