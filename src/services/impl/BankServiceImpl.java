package services.impl;

import domain.Account;
import repository.AccountRepository;
import services.Bankservice;

import java.util.UUID;

public class BankServiceImpl implements Bankservice {
    public final AccountRepository accountRepository = new AccountRepository();

    @Override
    public String openAccount(String name, String email, String accountType  ) {
    String customerId = UUID.randomUUID().toString();
    String accountNumber = getAccountNumber();
    Account account = new Account(accountNumber, customerId, (double) 0, accountType  );
    accountRepository.save(account);
        return accountNumber;
    }
        //Account number logic
    private String getAccountNumber() {
        int size = accountRepository.findall().size() + 1;
        return String.format("AC%06d", size);
    }
}
