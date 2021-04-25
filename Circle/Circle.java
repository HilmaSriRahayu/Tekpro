package Circle;

/*
 * The circle models a circle with a radius and colour
 */
public class Circle { 
	// variabel instance private, tidak dapat diakses dari luar kelas ini
	private double radius;
	private String color;
	
	//Constructors (overload)
	/* constructor default */
	public Circle (){ //constructor default
		radius = 1.0; 
		color = "red";
	}
	
	/*constructor default dengan parameter double*/
	public Circle(double r){ //constructor  kedua
		radius = r;
		color = "red";
	}
	
	//Task 1.1
	public Circle(double r, String c){ //constructor ketiga
		radius = r;
		color = c;
	}
	
	//Getter radius
	public double getRadius(){
		return radius;
	}
	
	//Setter radius
	public void setRadius(double r){
		radius = r;
	}
	
	//Getter color
	public String getColor(){
		return color;
	}
	
	//Setter color
	public void setColor(String c){
		color = c;
	
	}
	//Getter luas lingkaran
	public double getArea(){
		return radius*radius*Math.PI;
	}
	
	/*Return string deskriptif sendiri dari contoh ini dalam bentuk
	Circle [radius = ?, color =?] */
	
	public String toString(){
		return "Circle[radius=" + radius + " color=" + color + "]";
	}
	
}
