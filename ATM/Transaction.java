package ATM;

public abstract class Transaction {
	 private int accountNumber; // Menampilkan nomor akun
	 private Screen screen; // Layar ATM
	 private BankDatabase bankDatabase; // data akun pengguna
	 // Konstruktor transaksi yang dipanggil oleh subclass menggunakan super()
	 public Transaction(int userAccountNumber, Screen atmScreen, 
	 BankDatabase atmBankDatabase) {
	 accountNumber = userAccountNumber;
	 screen = atmScreen;
	 bankDatabase = atmBankDatabase;
	 }
	 // return account number 
	 public int getAccountNumber() {
	 return accountNumber; 
	 } 
	 // mengembalikan nilai layar
	 public Screen getScreen() {
	 return screen;
	 } 
	 // mengembalikan data layar
	 public BankDatabase getBankDatabase() {
	 return bankDatabase;
	 } 
	 // melakukan transaksi (diganti oleh setiap subkelas)
	 abstract public void execute();
	} 