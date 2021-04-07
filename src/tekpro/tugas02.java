package tekpro;

class Ig{
	private String username;
	private String email;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername (String newUsername){
		username = newUsername;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail (String newEmail){
		email = newEmail;
	}
	
	public void menampilkanData(){
		System.out.println("INSTAGRAM");
		System.out.println("Username	: " + username);
		System.out.println("Email		: " + email);
		System.out.println();
	}
}

class Line{
	private String username;
	private String id;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername (String newUsername){
		username = newUsername;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId (String newId){
		id = newId;
	}
	
	public void menampilkanData(){
		System.out.println("LINE");
		System.out.println("Username	: " + username);
		System.out.println("ID		: " + id);
		System.out.println();
	}
}
public class tugas02 {
	public static void main (String[]args){
		Ig Hilmasrir = new Ig();
		Line Hilma = new Line();
		Hilmasrir.setUsername("Hilmasrir_");
		Hilmasrir.setEmail("hilmasrirahayu11@gmail.com");
		Hilmasrir.menampilkanData();
		
		Hilma.setUsername("Hilma");
		Hilma.setId("Hilmasrir_");
		Hilma.menampilkanData();
	}
}