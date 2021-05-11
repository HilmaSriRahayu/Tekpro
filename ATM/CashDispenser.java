package ATM;

public class CashDispenser {
	// jumlah awal tagihan di mesin ATM tunai
	 private final static int INITIAL_COUNT = 500;
	 private int count; // number of $20 bills remaining
	 
	 // Konstruktor CashDispenser menginisialisasi hitungan ke default
	 public CashDispenser() {
	 count = INITIAL_COUNT; // set count attribute to default
	 }
	 // mensimulasikan pengeluaran uang tunai dalam jumlah tertentu
	 public void dispenseCash(int amount) {
	 int billsRequired = amount / 20; // number of $20 bills required
	 count -= billsRequired; // memperbaharui data nilai
	 }
	 //menunjukkan apakah mesin ATM tunai dapat mengeluarkan jumlah yang diinginkan
	 public boolean isSufficientCashAvailable(int amount) {
	 int billsRequired = amount / 20; // number of $20 bills required
	 if (count >= billsRequired) {
	 return true; // enough bills available
	 }
	 else {
	 return false; // not enough bills available
	 }
	 }
	} 