package Circle;

public class CylinderTest {
	public static void main (String[] args) {
		// Deklarasikan dan alokasikan silinder baru
		// dengan default color, radius, dan height 
		Cylinder c1 = new Cylinder(); 
		System.out.println("Cylinder  :"
				+ " radius=" + c1.getRadius()
				+ " height=" + c1.getHeight()
				+ " base area=" + c1.getArea()
				+ " volume=" + c1.getVolume()
				+ "to String = " + c1.toString());

		// Deklarasikan dan alokasikan silinder baru
		//menentukan height, dengan default color and radius 
		Cylinder c2 = new Cylinder(10.0); 
		System.out.println("Cylinder :"
				+ " radius=" + c2.getRadius()
				+ " height=" + c2.getHeight()
				+ " base area=" + c2.getArea()
				+ " volume=" + c2.getVolume()
				+ "to String = " + c2.toString());

		// Deklarasikan dan alokasikan silinder baru
		//menentukan radius dan height, dengan default color
		Cylinder c3 = new Cylinder(2.0, 10.0); 
		System.out.println("Cylinder :"
				+ " radius=" + c3.getRadius()
				+ " height=" + c3.getHeight()
				+ " base area=" + c3.getArea()
				+ " volume=" + c3.getVolume()
				+ "to String " + c3.toString());
	}

}
