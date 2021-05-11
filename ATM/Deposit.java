package ATM;

public class Deposit extends Transaction {
	 private double amount; // amount to deposit
	 private Keypad keypad; // reference to keypad
	 private DepositSlot depositSlot; // reference to deposit slot
	 private final static int CANCELED = 0; // constant for cancel option
	 // Konstruktor Deposit
	 public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase 
	atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
	 // menginisialisasi variabel superclass
	 super(userAccountNumber, atmScreen, atmBankDatabase);
	 // menginisialisasi keypad
	 keypad = atmKeypad;
	 depositSlot = atmDepositSlot;
	 } 
	 // perform transaction
	 @Override
	 public void execute() {
	 BankDatabase bankDatabase = getBankDatabase(); // menggunakan method getBankDatabase
	 Screen screen = getScreen(); // menggunakan method getScreen
	 
	 amount = promptForDepositAmount(); // dapatkan jumlah setoran dari	pengguna
	 // check whether user entered a deposit amount or canceled
	 if (amount != CANCELED) {
	 // request deposit envelope containing specified amount
	 screen.displayMessage(
	 "\nPlease insert a deposit envelope containing ");
	 screen.displayDollarAmount(amount);
	 screen.displayMessageLine(".");
	 // receive deposit envelope
	 boolean envelopeReceived = depositSlot.isEnvelopeReceived();
	 // periksa apakah uang yang disetorkan telah diterima
	 if (envelopeReceived) {
	 screen.displayMessageLine("\nYour envelope has been " + 
	 "received.\nNOTE: The money just deposited will not " + 
	 "be available until we verify the amount of any " +
			 "enclosed cash and your checks clear.");
	 
	 // credit account to reflect the deposit
	 bankDatabase.credit(getAccountNumber(), amount); 
	 } 
	 else { // deposit envelope not received
	 screen.displayMessageLine("\nYou did not insert an " +
	 "envelope, so the ATM has canceled your transaction.");
	 } 
	 } 
	 else { // user canceled instead of entering amount
	 screen.displayMessageLine("\nCanceling transaction...");
	 }
	 }
	 // minta pengguna untuk memasukkan jumlah setoran dalam sen
	 private double promptForDepositAmount() {
	 Screen screen = getScreen(); // get reference to screen
	 // menampilkan layar input setoran
	 screen.displayMessage("\nPlease enter a deposit amount in " + 
	 "CENTS (or 0 to cancel): ");
	 int input = keypad.getInput(); // menerima input dari jumlah setoran
	 
	 // periksa apakah pengguna membatalkan atau memasukkan jumlah yang valid
	 if (input == CANCELED) {
	 return CANCELED;
	 }
	 else {
	 return (double) input / 100; // return dollar amount
	 }
	 }
	} 