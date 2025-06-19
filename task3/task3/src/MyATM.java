import java.util.Scanner;

class Account {
    private double balance;

    Account(double bal) {
        balance = bal;
    }

    double getBalance() {
        return balance;
    }

    boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }
}

class ATMSystem {
    private Account acc;
    private Scanner sc;

    ATMSystem(Account acc) {
        this.acc = acc;
        sc = new Scanner(System.in);
    }

    void menu() {
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Balance: Rs" + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Deposit Rs: ");
                    double d = sc.nextDouble();
                    if (acc.deposit(d))
                        System.out.println("Deposited.");
                    else
                        System.out.println("Invalid amount.");
                    break;
                case 3:
                    System.out.print("Withdraw Rs: ");
                    double w = sc.nextDouble();
                    if (acc.withdraw(w))
                        System.out.println("Withdrawn.");
                    else
                        System.out.println("Failed. Check balance.");
                    break;
                case 4:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Choose valid option.");
            }
        }
    }
}

public class MyATM {
    public static void main(String[] args) {
        Account a = new Account(5000);
        ATMSystem atm = new ATMSystem(a);
        atm.menu();
    }
}
