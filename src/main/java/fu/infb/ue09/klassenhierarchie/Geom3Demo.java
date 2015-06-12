package fu.infb.ue09.klassenhierarchie;

public class Geom3Demo {
	public static void main(String[] args) {
		Geom3D[] arr = new Geom3D[] {};
		int totalVolume = 0;
		int totalSurfaceArea = 0;
		for (Geom3D element : arr) {
			totalVolume += element.volume();
			totalSurfaceArea += element.surfaceArea();
		}
		System.out.println("total volume: " + totalVolume);
		System.out.println("total surface area: " + totalSurfaceArea);
	}
}
