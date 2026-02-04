package domain;

public class Account {
    private String accountNumber;
    private String customerID;
    private Double balance;
    private String accountType;

    public Account(String accountNumber, String customerID, Double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.customerID = customerID;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public String getcustomerID(){
        return  customerID;
    }
    public Double getbalance (){
        return balance;
    }
    public String getAccountType(){
        return accountType;
    }
}
