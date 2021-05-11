package ATM;

//Keypad.java
//Represents the keypad of the ATM
import java.util.Scanner; // Program menggunakan Scanner untuk mendapatkan input pengguna
public class Keypad {
private Scanner input; // membaca data dari baris perintah

//konstruktor menginisialisasi Scanner
public Keypad() {
input = new Scanner(System.in); 
} 
// mengembalikan nilai integer yang dimasukkan oleh pengguna
public int getInput() {
return input.nextInt(); //kami berasumsi bahwa pengguna memasukkan nilai integer
} 

}