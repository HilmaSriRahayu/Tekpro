package ATM;

public class ATM {
	 private boolean userAuthenticated; // whether user is authenticated
	 private int currentAccountNumber; // current user's account number
	 private Screen screen; // ATM's screen
	 private Keypad keypad; // ATM's keypad
	 private CashDispenser cashDispenser; // ATM's cash dispenser
	 private DepositSlot depositSlot; // ATM's deposit slot
	 private BankDatabase bankDatabase; // account information database
	 // konstanta yang sesuai dengan opsi menu utama
	 private static final int BALANCE_INQUIRY = 1;
	 private static final int WITHDRAWAL = 2;
	 private static final int DEPOSIT = 3; 
	 private static final int EXIT = 4;
	 // Konstruktor ATM yang menginisialisasi variabel tujuan
	 public ATM() {
	 userAuthenticated = false; // user is not authenticated to start
	 currentAccountNumber = 0; // no current account number to start
	 screen = new Screen(); // create screen
	 keypad = new Keypad(); // create keypad 
	 cashDispenser = new CashDispenser(); // create cash dispenser
	 depositSlot = new DepositSlot(); // create deposit slot
	 bankDatabase = new BankDatabase(); // create acct info database
	 }
	 //memulai program ATM 
	 public void run() {
	 // welcome and authenticate user; perform transactions
	 while (true) {
	 // loop while user is not yet authenticated
	 while (!userAuthenticated) {
	 screen.displayMessageLine("\nWelcome!"); 
	 authenticateUser(); // authenticate user
	 }
	 
	 performTransactions(); // user is now authenticated
	 userAuthenticated = false; // reset before next ATM session
	 currentAccountNumber = 0; // reset before next ATM session
	 screen.displayMessageLine("\nThank you! Goodbye!");
	 }
	 }
	 // Method untuk mencoba untuk mengotentikasi pengguna terhadap database
	 private void authenticateUser() {
	 screen.displayMessage("\nPlease enter your account number: ");
	 int accountNumber = keypad.getInput(); // input account number
	 screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
	 int pin = keypad.getInput(); // input PIN
	 
	 // set userAuthenticated to boolean value returned by database
	 userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
	 
	 // check whether authentication succeeded
	 if (userAuthenticated) {
		 currentAccountNumber = accountNumber; // save user's account #
	 } 
	 else {
	 screen.displayMessageLine(
	 "Invalid account number or PIN. Please try again.");
	 } 
	 } 
	 
	 //Modifikasi method performTransactions()
	 // tampilkan menu utama dan lakukan transaksi
	 private void performTransactions() {
	 // local variable to store transaction currently being processed
	 Transaction currentTransaction = null;
	 boolean userExited = false; // user has not chosen to exit
	 // loop while user has not chosen option to exit system
	 while (!userExited) {
	 // show main menu and get user selection
	 int mainMenuSelection = displayMainMenu();
	 // putuskan bagaimana melanjutkan berdasarkan pilihan menu pengguna
	 switch (mainMenuSelection) {
	 // pengguna memilih untuk melakukan salah satu dari tiga jenis transaksi
	 case BALANCE_INQUIRY:
	 createTransaction(BALANCE_INQUIRY);
	 break;
	 case WITHDRAWAL:
	 createTransaction(WITHDRAWAL);
	 break;
	 case DEPOSIT:
	 createTransaction(DEPOSIT);
	 break;
	 case EXIT: // pengguna memilih untuk menghentikan penggunaan ATM
	 screen.displayMessageLine("\nExiting the system...");
	 userExited = true; // this ATM session should end
	 break;
	 default: // pengguna tidak memasukkan angka dari 1-4
	 screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
	 break;
	 }
	 }
	 }
	 // tampilkan menu utama dan mengembalikan nilai input
	 private int displayMainMenu() {
	 screen.displayMessageLine("\nMain menu:");
	 screen.displayMessageLine("1 - View my balance");
	 screen.displayMessageLine("2 - Withdraw cash");
	 screen.displayMessageLine("3 - Deposit funds");
	 screen.displayMessageLine("4 - Exit\n");
	 screen.displayMessage("Enter a choice: ");
	 return keypad.getInput(); // return user's selection
	 }
	 //Modifikasi Transaction
	 // return object of specified Transaction subclass
	 private Transaction createTransaction(int type) {
	 Transaction temp = null; // temporary Transaction variable
	 // tentukan jenis Transaksi yang akan dibuat
	 switch (type) {
	 case BALANCE_INQUIRY: // create new BalanceInquiry transaction
	 temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
	 temp.execute();
	 break;
	 case WITHDRAWAL: // create new Withdrawal transaction
	 temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, 
	cashDispenser);
	 temp.execute();
	 break;
	 case DEPOSIT: // create new Deposit transaction
	 temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, 
	depositSlot);
	 temp.execute();
	 break;
	 }
	 return temp; // return the newly created object
	 }
	}