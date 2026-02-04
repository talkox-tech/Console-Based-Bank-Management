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
            System.out.println("Your Choice is " + Case);
            switch (Case) {
                case 1 -> openAccount(scanner, bankservice);
                case 2 -> deposit(scanner);
                case 3 -> withdraw(scanner);
                case 4 -> transfer(scanner);
                case 5 -> getStatement(scanner);
                case 6 -> accountlist(scanner, bankservice);
                case 7 -> searchAccount(scanner );
                case 0 -> running = false;
            }

        }
    }


    private static void openAccount(Scanner scanner, Bankservice bankservice) {
        System.out.println("Enter Customer Name: ");
        String customer = scanner.nextLine().trim();
        System.out.println("Enter email id: ");
       // String email = scanner.nextLine().trim();
        System.out.println("Enter Account Type (CURRENT/SAVING): ");
     //   String type = scanner.nextLine().trim();
        System.out.println("Enter initial amount to deposit (optional Eg. for blank enter 0): ");
      //  String initialAmount = scanner.nextLine().trim();
      //  Double amount = Double.valueOf(initialAmount);
      //  bankservice.openAccount(customer, email, type );
    }

    private static void deposit(Scanner scanner) {

    }

    private static void withdraw(Scanner scanner) {

    }

    private static void transfer(Scanner scanner) {

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