package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE08)
public class Kugel extends Geom3D {

	private double r;

	public Kugel(double r) {
		this.r = r;
	}

	@Override
	public double volume() {
		return 4 / 3 * Math.PI * r * r * r;
	}

	@Override
	public double surfaceArea() {
		return 4 * Math.PI * r * r;
	}

}
