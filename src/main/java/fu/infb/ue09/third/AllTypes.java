package fu.infb.ue09.third;

public class AllTypes {
	public static class Place {
		public void printMe() {
			System.out.println("Buy it.");
		}
	}

	public static class Region extends Place {
		public void printMe() {
			System.out.println("Box it.");
		}
	}

	public static class State extends Region {
		public void printMe() {
			System.out.println("Ship it.");
		}
	}

	public static class Maryland extends State {
		public void printMe() {
			System.out.println("Read it.");
		}
	}

	public static void main(String[] args) {
		Region mid = new State();
		State md = new Maryland();
		Object obj = new Place();
		Place usa = new Region();
		md.printMe();
		mid.printMe();
		((Place) obj).printMe();
		obj = md;
		((Maryland) obj).printMe();
		obj = usa;
		((Place) obj).printMe();
	}
}
