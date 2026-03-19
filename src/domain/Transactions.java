package domain;

import java.time.LocalDateTime;

public class Transactions {
    private String id;
    private Type transaction;
    private String accountNumber;
    private Double amount;
    private LocalDateTime timestamp;
    private String note;

public Transactions(String id, Type transaction ,String accountNumber, Double amount, LocalDateTime timestamp, String note){
    this.id = id;
    this.transaction = transaction;
    this.accountNumber = accountNumber;
    this.amount = amount;
    this.timestamp = timestamp;
    this.note= note;
    }
        public String getAccountNumber(){
        return accountNumber;
    }
        public void setAccountNumber(){
            this.accountNumber = accountNumber;
        }

}
