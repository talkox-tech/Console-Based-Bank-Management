package services;

import domain.Account;

import java.util.List;

public interface Bankservice {
    String openAccount(String name,  String email, String accountType);
    List<Account> listAccount();

    void deposit(String accountNumber, Double amount, String deposit);

    void withdraw(String accountNumber, Double amount, String withdrawl);

    void transfer(String fromAccount, String toAccount, Double amount, String transfer);
}
