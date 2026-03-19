package repository;

import domain.Transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {
    private final Map<String, List<Transactions>> txByAccount = new HashMap<>();

    public void add(Transactions transactions){
        txByAccount.computeIfAbsent(transactions.getAccountNumber(),
                k-> new ArrayList<>()).add(transactions);

    }
}
