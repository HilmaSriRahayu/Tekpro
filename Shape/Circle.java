package Shape;

public class Circle extends Shape {
	private double radius;
	
	public Circle(){
		super();
		radius = 1.0;
	}
	
	public Circle(double radius){
		super();
		radius = 1.0;
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color,filled);
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	//jari-jari
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	//Luas
	public double getArea(){
		return radius*radius*Math.PI;
	}
	
	//keliling
	public double getPerimeter(){
		return 2*radius*Math.PI;
	}
	
	@Override
	public String toString() {
		return "A Circle with radius=" + radius
		         + ", which is a sublclass of " + super.toString();
	}
   
}
