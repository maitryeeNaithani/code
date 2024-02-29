package Spliwise.Model;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense( User payerUser, List<Split> splits, double amount, ExpenseMetadata expenseMetadata){
        super(payerUser,splits,amount,expenseMetadata);
    }

    public boolean validate(){

        for(Split split : getSplits()){
            if(!(split instanceof EqualSplit))
            {
                return false;
            }
        }
        return true;
    }
}
