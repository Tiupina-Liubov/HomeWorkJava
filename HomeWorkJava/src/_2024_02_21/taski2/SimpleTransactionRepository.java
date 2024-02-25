package src._2024_02_21.taski2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//todo
@Getter
public class SimpleTransactionRepository implements TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public boolean processTransaction(double amount) {
        // Положительная сумма считается успешной транзакцией.
        boolean isSuccess = amount > 0;
        Transaction transaction = new Transaction(amount, isSuccess);
        transactions.add(transaction);

        System.out.println("Transaction processed: Amount = " + amount + ", Success = " + isSuccess);

        return isSuccess;
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}