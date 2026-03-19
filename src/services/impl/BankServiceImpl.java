package services.impl;

import domain.Account;
import domain.Transactions;
import domain.Type;
import repository.AccountRepository;
import repository.TransactionRepository;
import services.Bankservice;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements Bankservice {
    public final AccountRepository accountRepository = new AccountRepository();
    public final TransactionRepository transactionRepository = new TransactionRepository();

    @Override
    public String openAccount(String name, String email, String accountType  ) {
    String customerId = UUID.randomUUID().toString();
    String accountNumber = getAccountNumber();
    Account account = new Account(accountNumber, customerId, (double) 0, accountType  );
    accountRepository.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccount(){
        return accountRepository.findall().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String note) {
            Account account = accountRepository.findByAccountNumber(accountNumber)
                    .orElseThrow(() -> new RuntimeException("Account Not Found: " + accountNumber));
            account.setBalance(Double.valueOf(account.getbalance()+ amount));

        Transactions transaction = new Transactions(UUID.randomUUID().toString(),
                Type.DEPOSIT, account.getAccountNumber(),amount, LocalDateTime.now(),note);
            transactionRepository.add(transaction);
    }

    @Override
    public void withdraw(String accountNumber, Double amount, String note) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account Not Found: " + accountNumber));
        if (account.getbalance().compareTo(amount)<0)
            throw new RuntimeException("Insufficient balance");
        account.setBalance(Double.valueOf(account.getbalance()- amount));
        Transactions transaction = new Transactions(UUID.randomUUID().toString(),
                Type.WITHDRAW, account.getAccountNumber(),amount, LocalDateTime.now(),note);
        transactionRepository.add(transaction);
    }
    @Override
    public void transfer(String fromAccount, String toAccount, Double amount, String note){
        if (fromAccount.equals(toAccount))
            throw new RuntimeException("Cannot transfer to own Account");
        Account fromAcc = accountRepository.findByAccountNumber(fromAccount)
                .orElseThrow(()->new RuntimeException("Account Not found "+ fromAccount));
        Account toAcc = accountRepository.findByAccountNumber(toAccount)
                .orElseThrow(()->new RuntimeException("Account not found" + toAccount));
        if(fromAcc.getbalance().compareTo(amount)<0)
            throw new RuntimeException("Insufficient Balance");
        fromAcc.setBalance(Double.valueOf(fromAcc.getbalance() - amount));
        toAcc.setBalance(Double.valueOf(toAcc.getbalance() + amount));
        Transactions toTransaction = new Transactions(UUID.randomUUID().toString(),
                Type.TRANSFER_IN,toAcc.getAccountNumber(),amount,LocalDateTime.now(),note);

        transactionRepository.add(toTransaction);
        Transactions fromTransactions = new Transactions(UUID.randomUUID().toString(),
                Type.TRANSFER_OUT,fromAcc.getAccountNumber(),amount,LocalDateTime.now(),note);
        transactionRepository.add(fromTransactions);

    }

    //Account number logic
    private String getAccountNumber() {
        int size = accountRepository.findall().size() + 1;
        return String.format("AC%06d", size);
    }

}
