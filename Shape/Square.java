package Shape;

public class Square extends Rectangle{
	public Square(){
		super();
		//lebar&panjang sama ukuran rectangle
		double side = 1.0;
	}
	
	public Square(double side){
		super(side,side); //Call superclass Rectangle(double, double)
		side = side;
	}
	
	public Square(double side, String color, boolean filled){
		super(side,side,color,filled);
		side = side;
	}
	//sisi persegi
	public double getSide(){
		return super.getWidth();
	}
	// hitung sisi persegi 
	public void setSide(double side){
		super.setWidth(side);
		super.setLength(side);
	}
	//Luas
	public double getArea(){
		return getSide()*getSide();
	}
	//Keliling
	public double getPerimeter(){
		return 4*getSide();
	}
	
	@Override
	public String toString(){
		return "A Square with side= " + getSide()
		+", which is a subclass of " +super.toString();
	}
	
}

