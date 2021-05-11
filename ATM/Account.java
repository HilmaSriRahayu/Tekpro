package ATM;

public class Account {
	 private int accountNumber; // nomor akun
	 private int pin; // PIN untuk otentikasi
	 private double availableBalance; // dana tersedia untuk penarikan
	 private double totalBalance; // dana tersedia + setoran tertunda
	 // Konstruktor Account menginisialisasi atribut
	 public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
	 accountNumber = theAccountNumber; //inisialisasi atribut accountNumber
	 pin = thePIN; //inisialisasi atribut PIN
	 availableBalance = theAvailableBalance; //inisialisasi atribut Balance yang tersedia (Saldo)
	 totalBalance = theTotalBalance; //inisialisasi atribut Jumlah Saldo
	 }
	 // menentukan apakah PIN yang diinput pengguna cocok dengan PIN di database Bank
	 public boolean validatePIN(int userPIN) {
	 if (userPIN == pin) { //Jika PIN yang dimasukkan benar	(sesuai data), mengembalikan nilai true
		 return true;
	 }
	 else {
	 return false; //Jika PIN yang dimasukkan salah, ia akan mengembalikan nilai false
	 }
	 } 
	 public double getAvailableBalance() { //Mengembalikan nilai Saldo
	 return availableBalance;
	 } 
	 public double getTotalBalance() { //Mengembalikan nilai saldo
	 return totalBalance;
	 } 
	 //menambah sejumlah ke akun
	 public void credit(double amount) {
	 totalBalance += amount; 
	 }
	 //mengambil sejumlah uang dari akun
	 public void debit(double amount) {
	 availableBalance -= amount; // mengurangi saldo akun
	 totalBalance -= amount; // mengurangi total saldo akun
	 }
	 // mengembalikan nomor akun
	 public int getAccountNumber() {
	 return accountNumber; 
	 }
	} 

