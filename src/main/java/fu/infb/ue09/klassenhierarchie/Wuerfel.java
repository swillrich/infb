package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE09)
//This class extends the class Quader and represents a 'Quader'
//Note: In this case the choice is to extend 'Quader' 
//because the process of calculating the data is not different.
public class Wuerfel extends Quader {

	// Just pass the only once argument 'a' three times.
	public Wuerfel(double a) {
		super(a, a, a);
	}
}
