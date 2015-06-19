package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE09)
//This class extends the abstract class Geom3D and represents a 'Tetaeder'
public class Tetraeder extends Geom3D {

	private double a;

	public Tetraeder(double a) {
		this.a = a;
	}

	@Override
	public double volume() {
		return a * a * a / 12 * Math.sqrt(2);
	}

	@Override
	public double surfaceArea() {
		return a * a * Math.sqrt(3);
	}

}
