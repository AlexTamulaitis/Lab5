/**
 * Implement a bank class.
 * <p>
 * In this lab we will model a bank. We have two classes: Bank and BankAccount. You should finish
 * both classes, by fixing checkstyle errors, defining constructors, getters and setters, and
 * accessing private variables.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/5/">Lab 5 Description</a>
 */
public class Bank {
    /**
     * Name of bank.
     */
    private String bankName;
    /**
     * @return name of bank.
     */
    public String getBankName() {
        return bankName;
    }
    /**
     * Constructor that establishes the bank's name.
     */
    public Bank() {
        bankName = "Illini Bank";
    }

    /**
     * Withdraw money from an account.
     * <p>
     * Subtracts the amount of money from bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to withdraw money from.
     * @param amount to withdraw (double)
     * @return boolean
     */
    public boolean withdrawMoney(final BankAccount bankAccount, final double amount) {
        double x = bankAccount.getAccountBalance();
        if (x - amount <= 0.0) {
            System.out.println("Sorry, amount requested for withdrawal exceeds account balance.");
            return false;
        } else {
            bankAccount.setAccountBalance(x - amount);
            System.out.println(bankAccount.getOwnerName() + "'s account balance is " + bankAccount.getAccountBalance());
            return true;
        }
    }

    /**
     * Deposit money in an account.
     * <p>
     * Adds the amount of money to bank account's balance. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param bankAccount to deposit money to.
     * @param amount to deposit
     * @return boolean
     */
    public boolean depositMoney(final BankAccount bankAccount, final double amount) {
        double x = bankAccount.getAccountBalance();
        bankAccount.setAccountBalance(x + amount);
        System.out.println(bankAccount.getOwnerName() + "'s account balance is " + bankAccount.getAccountBalance());
        return true;
    }

    /**
     * Transfer money from one account to another.
     * <p>
     * Transfer the amount of money from one back account to another. Returns true if transaction is
     * successful, false otherwise.
     *
     * @param source bank account to transfer money from.
     * @param destination bank account to transfer money to.
     * @param amount to transfer
     * @return boolean
     */

    public boolean transferMoney(final BankAccount source, final BankAccount destination,
            final double amount) {
        double sourceBalance = source.getAccountBalance();
        double destinationBalance = destination.getAccountBalance();
        if (sourceBalance < amount) {
            System.out.println("Sorry, amount requested for transfer exceeds account balance.");
            return false;
        } else {
            source.setAccountBalance(sourceBalance - amount);
            destination.setAccountBalance(destinationBalance + amount);
            System.out.println(source.getOwnerName() + "'s account balance is " + source.getAccountBalance());
            System.out.println(destination.getOwnerName() + "'s account balance is " + destination.getAccountBalance());
            return true;
        }
    }

    /**
     * Change back account owner name.
     *
     * @param bankAccount to change
     * @param name new name to set
     */

    public void changeOwnerName(final BankAccount bankAccount, final String name) {
        bankAccount.setOwnerName(name);
        System.out.println("New owner's name is " + bankAccount.getOwnerName());
    }

    /**
     * number of accounts with the bank.
     */
    private static int totalAccounts = 0;

    /**
     * @param setTotalAccounts setter for total accounts.
     */
    public static void setTotalAccounts(final int setTotalAccounts) {
        totalAccounts = setTotalAccounts;
    }
    /**
     * @return totalAccounts
     */
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    /**
     * Uses static variable to get number of bank accounts opened.
     *
     * returns the total number of accounts
     */
    public static void getNumberOfAccount() {
        Bank.getTotalAccounts();
    }

    /**
     * Main method for testing.
     *
     * @param unused unused input arguments
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(final String[] unused) {
        Bank bank = new Bank();
        System.out.println("Welcome to " + bank.bankName);
        System.out.println("We are excited to have you banking with us!\n\n");

        // Create Bank Accounts
        BankAccount account1 = new BankAccount("John Doe", BankAccount.BankAccountType.CHECKINGS);
        System.out.println("Bank account for John Doe created");

        BankAccount account2 = new BankAccount("Jony Ive", BankAccount.BankAccountType.STUDENT);
        System.out.println("Bank account for Johy Ive created\n\n");

        // Deposit money to both accounts and print new balance
        bank.depositMoney(account1, 1000.0);
        bank.depositMoney(account2, 5000.0);

        // Withdraw money from Account 2 and print new balance
        bank.withdrawMoney(account2, 1000.0);

        // Transfer money from Account 2 to Account 1 and print new balances
        bank.transferMoney(account2, account1, 4000.0);

        // Print number of accounts
        System.out.print("Number of active accounts at " + bank.bankName + " are ");
        System.out.println(Bank.totalAccounts);

        // Change owner of account 2
        bank.changeOwnerName(account2, "Jimmy Neutron");
    }
}
