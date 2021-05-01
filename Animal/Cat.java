package Animal;

public class Cat extends Animal{
	@Override
	public void sound(){
		System.out.println("Meow");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal obj = new Cat();
		obj.sound();
	}

}
