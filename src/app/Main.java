package app;

import services.Bankservice;
import services.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bankservice bankservice = new BankServiceImpl();
        System.out.println("Welcome to Console Bank");
        boolean running = true;
        while (running) {
            System.out.println("""
                            1) Open Account
                            2) Deposit
                            3) Withdraw
                            4) Transfer
                            5) Account Statement
                            6) List Accounts
                            7) Search Account By Customer Name
                            0) Exit
                    """);
            System.out.println("CHOOSE (Kindly enter only Integer Value) : ");
            int Case = scanner.nextInt();
            scanner.nextLine();    //after entering integer leftover new line to consume
            System.out.println("Your Choice is " + Case);
            switch (Case) {
                case 1 -> openAccount(scanner, bankservice);
                case 2 -> deposit(scanner, bankservice);
                case 3 -> withdraw(scanner, bankservice);
                case 4 -> transfer(scanner, bankservice);
                case 5 -> getStatement(scanner);
                case 6 -> accountlist(scanner, bankservice);
                case 7 -> searchAccount(scanner );
                case 0 -> running = false;
            }

        }
    }


    private static void openAccount(Scanner scanner, Bankservice bankservice) {
        System.out.println("Enter Customer Name: ");
        String customer = scanner.nextLine();
        System.out.println("Enter email id: ");
       String email = scanner.nextLine().trim();
        System.out.println("Enter Account Type (CURRENT/SAVING): ");
      String type = scanner.nextLine().trim();
        System.out.println("Enter initial amount to deposit (optional Eg. for blank enter 0): ");
      String initialAmount = scanner.nextLine().trim();
      Double OpeningAmount = Double.valueOf(initialAmount);
      String accountNumber = bankservice.openAccount(customer, email, type );
      if(OpeningAmount>0)
          bankservice.deposit(accountNumber,OpeningAmount,"Iniatial Deposit");
      System.out.println("Your Account is opened, and Your account number is " + accountNumber);
    }


    private static void deposit(Scanner scanner, Bankservice bankservice) {
        System.out.println("Enter the Account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Enter the amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankservice.deposit(accountNumber, amount, "Deposit");
        System.out.println("Deposited");

    }

    private static void withdraw(Scanner scanner, Bankservice bankservice) {
        System.out.println("Enter the Account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Enter the amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankservice.withdraw(accountNumber, amount, "Withdrawl");
        System.out.println("Withdrawn");
    }

    private static void transfer(Scanner scanner, Bankservice bankservice) {
        System.out.println("From Account: ");
        String fromAccount = scanner.nextLine().trim();
        System.out.println("TO Account: ");
        String toAccount = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankservice.transfer(fromAccount,toAccount,amount,"Transfer");
        System.out.println("Transfer from " + fromAccount + " to Account "+ toAccount +" "+ amount + " amount successfully");

    }

    private static void getStatement(Scanner scanner) {

    }

    private static void accountlist(Scanner scanner, Bankservice bankservice) {
        bankservice.listAccount().forEach(a ->{
            System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getbalance());
        });
    }

    private static void searchAccount(Scanner scanner) {

    }
}