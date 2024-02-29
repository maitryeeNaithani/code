package Splitwise.service;

import Spliwise.Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager(){
        expenses= new ArrayList<Expense>();
        userMap=new HashMap<String, User>();
        balanceSheet= new HashMap<String,Map<String,Double> >();
    }

    public void addUser(User user){
        userMap.put(user.getId(),user);
        balanceSheet.put(user.getId(),new HashMap<String,Double>());
    }

    public void AddExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetadata expenseMetadata){
        Expense expense= ExpenseService.createExpense(expenseType,amount,userMap.get(paidBy),splits,expenseMetadata);
        expenses.add(expense);

        for(Split split: expense.getSplits()){
            String paidTo= split.getUser().getId();
            Map<String,Double> balances= balanceSheet.get(paidBy);
            if(!balances.containsKey(paidTo)){
                balances.put(paidTo,0.0);
            }
            balances.put(paidTo,balances.get(paidTo)+split.getAmount());

            balances= balanceSheet.get(paidTo);
            if(!balances.containsKey(paidBy)){
                balances.put(paidBy,0.0);
            }
            balances.put(paidBy,balances.get(paidBy)-split.getAmount());
        }
    }

    public void showBalance(String userId){
        boolean isEmpty=true;

        for(Map.Entry<String, Double> userBalance :balanceSheet.get(userId).entrySet()){
            if(userBalance.getValue()!=0){
                isEmpty= false;
                printBalance(userId, userBalance.getKey(),userBalance.getValue());
            }
        }
        if(isEmpty){
            System.out.println("No Balance");
        }
    }

    public void showBalances(){
        boolean isEmpty= true;
        for(Map.Entry<String, Map<String, Double>> allBalances :balanceSheet.entrySet()){

            for(Map.Entry<String, Double> userBalance: allBalances.getValue().entrySet()){
                if(userBalance.getValue()>0){
                    isEmpty=false;
                    printBalance(allBalances.getKey(),userBalance.getKey(),userBalance.getValue());
                }
            }

        }

    }

    private void printBalance(String user1, String user2, double amount){
        String userName1= userMap.get(user1).getName();
        String userName2= userMap.get(user2).getName();
        if(amount>0){
            System.out.println(userName2+ " owes "+ Math.abs(amount) +"to "+ userName1);
        }
        else
            System.out.println(userName1+ " owes "+ Math.abs(amount) +"to "+ userName2);

    }

}
