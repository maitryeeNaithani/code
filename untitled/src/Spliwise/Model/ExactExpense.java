package Spliwise.Model;

import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(User payerUser, List<Split> splits, double amount, ExpenseMetadata expenseMetadata){
        super(payerUser,splits,amount,expenseMetadata);
    }

    public boolean validate(){
       double totalAmount=0.0;
        for(Split split : getSplits()){
            if(!(split instanceof ExactSplit))
            {
                return false;
            }
           totalAmount+=split.getAmount();

        }
        if(totalAmount == getAmount())
             return true;
        return false;
    }
}

