package Splitwise.service;

import Spliwise.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Spliwise.Model.ExpenseType.*;

public class SplitwiseService {

    public static void main(String args[]){
        ExpenseManager expenseManager= new ExpenseManager();
        expenseManager.addUser(new User("u1","User1","maitryee.naithani98@gmail.com","7906648049"));
        expenseManager.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner sc= new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "Show":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else
                        expenseManager.showBalance(commands[1]);
                    break;
                case "Expense":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int numberOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "Equal":
                            for (int i = 0; i < numberOfUsers; ++i) {
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[5 + i])));
                            }
                            expenseManager.AddExpense(EQUAL, amount, paidBy, splits, null);
                            break;
                        case "Exact":
                            for (int i = 0; i < numberOfUsers; ++i) {
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[5 + i]), Double.parseDouble(commands[5 + numberOfUsers + i])));
                            }
                            expenseManager.AddExpense(EXACT, amount, paidBy, splits, null);
                            break;
                        case "Percent":
                            for (int i = 0; i < numberOfUsers; ++i) {
                                splits.add(new PercentSplit(expenseManager.userMap.get(commands[5 + i]), Double.parseDouble(commands[5 + numberOfUsers + i])));
                            }
                            expenseManager.AddExpense(PERCENT, amount, paidBy, splits, null);
                            break;

                        default:
                            throw new IllegalStateException("Unexpected value: " + expenseType);
                    }
            }
        }}}




