package Shape;

public class Shape {
	//deklarasi 2 variable
	private String color;
	private boolean filled;
	
	//contructor no arg
	public Shape(){
		color = "green";
		filled = true;
	}
	//contructor 2
	public Shape(String color1, boolean filled1){
		color = color1;
		filled = filled1;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		if (filled==true){
			return true;
		} else{
			return false;
		}
	}
	
	public void setFilled (boolean filled){
		this.filled = filled;
	}
	
	public String toString(){
		String toString = "";
		if(isFilled() == false){
			toString = "not";
		} return "A Shape with color of " +color +" and is " +toString +"filled.";
	}
	
}