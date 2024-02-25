package src._2024_02_21.taski2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private double amount;

    private boolean isSuccess;

    public Transaction(double amount, boolean isSuccess) {
        this.amount = amount;
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
