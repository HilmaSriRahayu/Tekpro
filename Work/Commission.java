package Work;

public class Commission extends Hourly{
	private double totalSales;
	private double comRates;
	
	public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double com){
		super(eName, eAddress, ePhone, socSecNumber, rate);
		comRates = com;
	}
	
	public void addSales(double totalSales){
		this.totalSales += totalSales;
	}
	
	public double pay(){
		double payment = super.pay() + totalSales*comRates;
		
		totalSales = 0.0;
		
		return payment;
	}
	
	public String toString(){
		String result = super.toString();
		
		result += "\nCurrent sales: " + totalSales;
		return result;
	}
	
}
