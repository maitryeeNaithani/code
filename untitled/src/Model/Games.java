package Model;
import java.util.*;
public class Games {

    //private List<Player> player;
    private HashMap<String, Integer> playerCurrentPos;
    private SnakesAndLaddersBoard snakesAndLaddersBoard;

    public Games(){
     //this.player=new ArrayList<>();
     this.playerCurrentPos= new HashMap<>();
    }
    public void setPlayerCurrentPos(HashMap<String, Integer> playerCurrentPos) {
        this.playerCurrentPos = playerCurrentPos;
    }

    public Map<String, Integer> getPlayerCurrentPos() {
        return playerCurrentPos;
    }

}
