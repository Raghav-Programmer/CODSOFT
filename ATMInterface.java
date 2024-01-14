import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    String accountHolderName;
    double accountBalance;

    // Constructor creates new bank account with the given name
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Methods to deposit, withdraw and check balance
    public void deposit(int amount) {
        accountBalance += amount;
        System.out.println(amount + " Successfully Credited To Your Acount!!\n");
    }

    public void withdraw(int amount) {
        if (amount > accountBalance) {
            System.out.println("Transaction Failed: Insufficient Balance!!\n");
        } else {
            accountBalance -= amount;
            System.out.println(amount + " Successfully Debited From Your Acount!!\n");
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Account Balance is: " + accountBalance + "\n");
    }
}

// Class representing ATM machine
class ATM {
    BankAccount bankAccount;

    // Constructor creates ATM object linked to specific bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Methods to make deposit, withdraw, and checkBalance calls to bank account
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        bankAccount.withdraw(amount);
    }

    public void checkBalance() {
        bankAccount.checkBalance();
    }
}

// Main class with ATM logic
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = "";

        // Welcome message to open account
        System.out.println("Hi!! Let's Open An Account For You");
        System.out.print("Enter Your Name: ");
        userName = scan.nextLine();
        System.out.println();

        // Creating new bank account with given name and ATM object from the account
        BankAccount bankAccount = new BankAccount(userName);
        ATM atm = new ATM(bankAccount);

        // Loop for ATM options and handling user choices
        boolean continueChoicesLoop = true;
        while (continueChoicesLoop) {
            System.out.println(1 + " Deposit Money");
            System.out.println(2 + " Withdraw Money");
            System.out.println(3 + " Check Account Balance");
            System.out.println(0 + " Exit\n");

            // Prompt for user choice
            int choice = 0;
            System.out.print("Enter Choice: ");
            choice = scan.nextInt();
            System.out.println();
            int amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter Amount To Deposit: ");
                    amount = scan.nextInt();
                    System.out.println();
                    atm.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter Amount To Withdraw: ");
                    amount = scan.nextInt();
                    System.out.println();
                    atm.withdraw(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                default:
                    continueChoicesLoop = false;
                    break;
            }
        }

        scan.close();
    }
}
