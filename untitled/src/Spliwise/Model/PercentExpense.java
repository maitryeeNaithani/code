package Spliwise.Model;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(User payerUser, List<Split> splits, double amount, ExpenseMetadata expenseMetadata){
        super(payerUser,splits,amount,expenseMetadata);
    }

    public boolean validate(){
        double totalAmount=0.0;
        for(Split split : getSplits()){
            if(!(split instanceof PercentSplit))
            {
                return false;
            }
            totalAmount+=(getAmount() *((PercentSplit) split).getPercentage())/100;

        }
        if(totalAmount == getAmount())
            return true;
        return false;
    }
}

