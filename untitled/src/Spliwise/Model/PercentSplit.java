package Spliwise.Model;

public class PercentSplit extends Split{

    private double percentage;

    public PercentSplit(User user, double percentage){
        super(user);
        this.percentage= percentage;
    }
    public double getPercentage(){
        return percentage;
    }
    public void setAmount(double amount){
       super.setAmount(amount);
    }

}
