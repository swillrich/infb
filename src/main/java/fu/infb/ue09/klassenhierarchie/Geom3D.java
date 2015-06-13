package fu.infb.ue09.klassenhierarchie;

//Namen Martin Voges, Rico Koetschau, Sven Willrich (UE08)
//abstrakte Oberklasse mit der Definition von Operationen, 
//die jede Unterklasse implementieren muss
public abstract class Geom3D {
	// gibt das Volume jeder Form zurück
	public abstract double volume();

	// gibt die SurfaceArea, also die Fläche, jeder Form zurück
	public abstract double surfaceArea();
}
