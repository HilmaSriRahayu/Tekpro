package ATM;

public class Withdrawal extends Transaction {
	 private int amount; // jumlah yang akan ditarik
	 private Keypad keypad; // menampung nilai keypad
	 private CashDispenser cashDispenser; // menampung nilai value uang
	 // constant corresponding to menu option to cancel
	 private final static int CANCELED = 6;
	 //Konstruktor untuk menarik uang
	 public Withdrawal(int userAccountNumber, Screen atmScreen, 
	 BankDatabase atmBankDatabase, Keypad atmKeypad, 
	 CashDispenser atmCashDispenser) {
	 // menginisialisasi variabel superclass
	 super(userAccountNumber, atmScreen, atmBankDatabase);
	 
	 // menginisialisasi nilai variabel keypad dan cashDispenser
	 keypad = atmKeypad;
	 cashDispenser = atmCashDispenser;
	 }
	 // lakukan transaksi
	 @Override
	 public void execute() { 
	 boolean cashDispensed = false; // uang belum ditarik
	 double availableBalance; // jumlah uang yang dapat ditarik
	 // mendapat nilai dari Bank Database dan screen
	 BankDatabase bankDatabase = getBankDatabase(); 
	 Screen screen = getScreen();
	 do {
	 // Jumlah nilai penarikan yang dipilih dari pengguna
	 amount = displayMenuOfAmounts();
	 
	 // periksa apakah pengguna memilih menarik uang atau dibatalkan
	 if (amount != CANCELED) {
	 // Nilai saldo akun yang tersedia
	 availableBalance = 
	 bankDatabase.getAvailableBalance(getAccountNumber());
	 
	 // periksa apakah pengguna memiliki cukup uang di rekeningnya
	 if (amount <= availableBalance) {
	 // periksa apakah mesin ATM memiliki cukup uang
	 if (cashDispenser.isSufficientCashAvailable(amount)) {
	 //Perbaharui akun setelah penarikan
	 bankDatabase.debit(getAccountNumber(), amount);
	 cashDispenser.dispenseCash(amount); // Uang telah ditarik
	 cashDispensed = true; // Value booelan untuk menyatakan uang telah ditarik
	 // Tampilan layar setelah penarikan oleh pengguna
	 screen.displayMessageLine("\nYour cash has been" +
	 " dispensed. Please take your cash now.");
	 } 
	 else { // mesin ATM tidak memiliki uang yang cukup untuk ditarik
	 screen.displayMessageLine(
	 "\nInsufficient cash available in the ATM." +
	 "\n\nPlease choose a smaller amount.");
	 }
	 }
	 else { // Uang yang ditarik tidak cukup
	 screen.displayMessageLine(
	 "\nInsufficient funds in your account." +
	 "\n\nPlease choose a smaller amount."); 
	 } 
	 } 
	 else { // Pilihan pengguna saat membatalkan transaksi di ATM
	 screen.displayMessageLine("\nCanceling transaction...");
	 return; // return to main menu because user canceled
	 } 
	 } while (!cashDispensed);
	 } 
	 // Tampilkan ke layar jumlah uang yang ditarik pengguna beserta pilihannya
	 // mengembalikan nilai 0 bila pengguna membatalkan
	 private int displayMenuOfAmounts() {
	 int userChoice = 0;// variabel lokal untuk menyimpan nilai pengembalian
	 Screen screen = getScreen(); //Membuat screen baru untuk menampilkan layar
	 
	 // larik jumlah yang sesuai dengan nomor menu
	 int[] amounts = {0, 20, 40, 60, 100, 200};
	 // loop sampai tidak ada pilihan yang valid telah dibuat
	 while (userChoice == 0) {
	 // display the withdrawal menu
	 screen.displayMessageLine("\nWithdrawal Menu:");
	 screen.displayMessageLine("1 - $20");
	 screen.displayMessageLine("2 - $40");
	 screen.displayMessageLine("3 - $60");
	 screen.displayMessageLine("4 - $100");
	 screen.displayMessageLine("5 - $200");
	 screen.displayMessageLine("6 - Cancel transaction");
	 screen.displayMessage("\nChoose a withdrawal amount: ");
	 int input = keypad.getInput(); //Mendapat nilai dari input nasabah
	 // tentukan bagaimana melanjutkan berdasarkan nilai input
	 switch (input) {
	 case 1: // if the user chose a withdrawal amount 
	 case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
	 case 3: // corresponding amount from amounts array
	 case 4:
	 case 5:
	 userChoice = amounts[input]; //menyimpan pilihan nasabah
	 break; 
	 case CANCELED: // pengguna memilih untuk membatalkan transaksi
	 userChoice = CANCELED; //Simpan pilihan pengguna
	 break;
	 default:// pengguna tidak memasukkan nilai dari 1-6
	 screen.displayMessageLine(
	 "\nInvalid selection. Try again.");
	 } 
	 } 
	 return userChoice; // kembalikan jumlah nilai penarikan atau DIBATALKAN
	 }
	} 

