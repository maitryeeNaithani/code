package Service;
import java.util.*;

public class DiceService{

    public DiceService(){

    }
    public int roll(){
        return new Random().nextInt(6)+1;
    }

}