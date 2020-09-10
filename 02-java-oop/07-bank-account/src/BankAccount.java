import java.util.Random;

public class BankAccount {

	//attributes
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int totalAccounts;
	private static double totalMoney;
		
	//constructors
	public BankAccount () {
		this.accountNumber = this.newAccountNumber();
		totalAccounts++;
	}
	
	//methods
	private String newAccountNumber() {
		//TO DO -- return 1 random 10 digit number in a string.
		Random r = new Random();
		String account = "";
		for (int i = 0; i < 10; i++) {
			account = account.concat(String.valueOf(r.nextInt(10)));
		}
		return account;
	}
	
	public void depositMoney(double money, String accountType) {
		if (accountType.toLowerCase().equals("checking")) {
			this.setCheckingBalance(this.getCheckingBalance() + money);
			totalMoney = totalMoney + money;
		} else if (accountType.toLowerCase().equals("savings")) {
			this.setSavingsBalance(this.getSavingsBalance() + money);
			totalMoney = totalMoney + money;
		} else {
			System.out.println("Invalid account type.");
		}
	}
	public void withdrawMoney(double money, String accountType) {
		if (accountType.toLowerCase().equals("checking")) {
			if (this.getCheckingBalance() - money >= 0) {
				this.setCheckingBalance(this.getCheckingBalance() - money);
				totalMoney = totalMoney - money;
			} else {
				System.out.println("Not sufficient funds.");
			}
		} else if (accountType.toLowerCase().equals("savings")) {
			if ((this.getSavingsBalance() - money) >= 0) {
				this.setSavingsBalance(this.getSavingsBalance() - money);
				totalMoney = totalMoney - money;
			} else {
				System.out.println("Not sufficient funds.");
				}
		}
			else {
			System.out.println("Invalid account type.");
		}
	}
	public void checkBankAccountTotals() {
		System.out.println(this.getCheckingBalance() + this.getSavingsBalance());
	}
	
	//getters and setters
	public void getTotalAccounts() {
		System.out.println(totalAccounts + " Total Account.");
	}
	public void getTotalMoney() {
		System.out.println("$" + totalMoney + " Dollars");
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	private void setCheckingBalance(double money) {
		this.checkingBalance = money;
	}
	private void setSavingsBalance(double money) {
		this.savingsBalance = money;
	}
}
