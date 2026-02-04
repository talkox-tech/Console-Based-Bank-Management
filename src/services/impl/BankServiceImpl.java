package services.impl;

import domain.Account;import services.Bankservice;

import java.util.UUID;

public class BankServiceImpl implements Bankservice {

    @Override
    public String openAccount(String name, String email, String accountType  ) {
    String customerId = UUID.randomUUID().toString();

    //Change Later
    String accountNumber = UUID.randomUUID().toString();
    Account a = new Account(accountNumber, customerId, (double) 0, accountType  );
        return "";
    }
}
