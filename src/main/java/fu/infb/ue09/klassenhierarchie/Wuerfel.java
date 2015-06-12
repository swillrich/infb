package fu.infb.ue09.klassenhierarchie;

public class Wuerfel extends Geom3D {

	private double a;

	public Wuerfel(double a) {
		this.a = a;
	}

	@Override
	public double volume() {
		return a * a * a;
	}

	@Override
	public double surfaceArea() {
		return a * a * 6;
	}

}
