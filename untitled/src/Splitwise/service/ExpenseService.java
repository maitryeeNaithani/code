package Splitwise.service;

import Spliwise.Model.*;

import java.util.List;

import static Spliwise.Model.ExpenseType.*;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {

            case EXACT:
                return new ExactExpense(paidBy, splits, amount, expenseMetadata);

            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) amount / totalSplits);
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount * totalSplits));
                return new EqualExpense(paidBy, splits, amount, expenseMetadata);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount(amount * ((PercentSplit) split).getPercentage() / 100.0);
                }
                return new PercentExpense(paidBy, splits, amount, expenseMetadata);


            default:
                throw new IllegalStateException("Unexpected value: " + expenseType);
        }
    }
}
