package fu.infb.ue09.klassenhierarchie;

public class Quader extends Geom3D {

	private double a;
	private double b;
	private double c;
	
	public Quader(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double volume() {
		return a * b * c;
	}

	@Override
	public double surfaceArea() {
		return 2 * a * b + 2 * a * c + 2 * b * c;
	}

}
