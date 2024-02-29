package Spliwise.Model;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User payerUser;
    private List<Split> splits;
    private ExpenseMetadata metadata;

    public Expense(User payerUser, List<Split> splits,double amount, ExpenseMetadata expenseMetadata){

        this.payerUser=payerUser;
        this.splits=splits;
        this.amount= amount;
        this.metadata= expenseMetadata;
    }

    public void setPayerUser(User payerUser){
        this.payerUser= payerUser;
    }
    public User getPayerUser(){
        return payerUser;
    }
    public void setSplits(List<Split> splits){
        this.splits= splits;
    }
    public List<Split> getSplits(){
        return this.splits;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setMetadata(ExpenseMetadata expenseMetadata){
        this.metadata= metadata;
    }
    public ExpenseMetadata getMetadata(){
        return metadata;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract boolean validate();

}
