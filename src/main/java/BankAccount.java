/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 5.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/5/">Lab 5 Description</a>
 */
public class BankAccount {

    /**
     * You may want to use this to distinguish between different kinds of accounts.
     */
    public enum BankAccountType {
        /**
         * Account is a checking account.
         */
        CHECKINGS,
        /**
         * Account is a savings account.
         */
        SAVINGS,
        /**
         * Account is a student  account.
         */
        STUDENT,
        /**
         * Account is a workplace account.
         */
        WORKPLACE
    }

    /**
     * ID number associated with the account.
     */
    private int accountNumber;
    /**
     * Type of account with the bank.
     */
    private BankAccountType accountType;
    /**
     * Amount of money in the account.
     */
    private double accountBalance;
    /**
     * Name of the accounts owner.
     */
    private String ownerName;
    /**
     * Rate at which interest accumulates.
     */
    private double interestRate;
    /**
     * Total interest earned.
     */
    private double interestEarned;

    /**
     * @param name name of the account owner.
     * @param accountCategory type of the account.
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        ownerName = name;
        accountType = accountCategory;
        int numberOfAccounts = Bank.getTotalAccounts();
        Bank.setTotalAccounts(numberOfAccounts + 1);
    }

    /**
     * @param setAccountNumber sets account number.
     */
    public void setAccountNumber(final int setAccountNumber) {
        accountNumber = setAccountNumber;
    }

    /**
     * @return account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    /**
     * @param setAccountBalance sets account balance.
     */
    public void setAccountBalance(final double setAccountBalance) {
        accountBalance = setAccountBalance;
    }

    /**
     * @return account balance.
     */
    public double getAccountBalance() {
        return accountBalance;
    }
    /**
     * @param setInterestRate sets interest rate.
     */
    public void setInterestRate(final double setInterestRate) {
        interestRate = setInterestRate;
    }

    /**
     * @return interest rate.
     */
    public double getInterestRate() {
        return interestRate;
    }
    /**
     * @param setInterestEarned sets interest earned.
     */
    public void setInterestEarned(final double setInterestEarned) {
        interestEarned = setInterestEarned;
    }

    /**
     * @return interest earned.
     */
    public double getInterestEarned() {
        return interestEarned;
    }
    /**
     * @param setOwnerName sets owner name.
     */
    public void setOwnerName(final String setOwnerName) {
        ownerName = setOwnerName;
    }

    /**
     * @return owner name.
     */
    public String getOwnerName() {
        return ownerName;
    }
    /**
     * @param setAccountType sets account type.
     */
    public void setAccountType(final BankAccountType setAccountType) {
        accountType = setAccountType;
    }

    /**
     * @return account type.
     */
    public BankAccountType getAccountType() {
        return accountType;
    }
}
