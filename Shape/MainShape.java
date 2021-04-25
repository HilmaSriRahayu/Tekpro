package Shape;

public class MainShape {
	public static void main (String[] args){
		Circle c = new Circle();
		System.out.println("Circle :\n"
				+ "radius= " + c.getRadius()
				+ " perimeter= " + c.getPerimeter()
				+ " area= " + c.getArea()
				+ " note(toString)= " +c.toString());
		
		Rectangle r = new Rectangle();
		System.out.println("Rectangle :\n"
				+ "length= " + r.getLength()
				+ " width= " + r.getWidth()
				+ " perimeter= " + r.getPerimeter()
				+ " area= " + r.getArea()
				+ " note(toString)= " + r.toString());
		
		Square s = new Square();
		System.out.println("Square :\n"
				+ "side= " + s.getSide()
				+ " perimeter= " + s.getPerimeter()
				+ " area= " + s.getArea()
				+ " note(toString)= " + s.toString());
		
	}
}
