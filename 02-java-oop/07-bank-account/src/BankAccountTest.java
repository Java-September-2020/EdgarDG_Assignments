
public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount myBankAccount = new BankAccount();
		myBankAccount.depositMoney(10, "savings");
		myBankAccount.depositMoney(100, "checking");
		myBankAccount.getTotalMoney();
		myBankAccount.getTotalAccounts();
		myBankAccount.getAccountNumber();
		myBankAccount.checkBankAccountTotals();
		myBankAccount.withdrawMoney(1000, "Checking");
	}
}
