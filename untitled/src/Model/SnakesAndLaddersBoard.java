
package Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakesAndLaddersBoard {

    private int size;
    private List<Snakes> snakes;
    private List<Ladders> ladders;



    public SnakesAndLaddersBoard(int size) {
        this.size = size;
        snakes = new ArrayList<Snakes>();
        ladders = new ArrayList<Ladders>();
    }

    public void setSnakes(List<Snakes> snakes) {
        this.snakes = snakes;
    }

    public List<Snakes> getSnakes() {
        return snakes;
    }

    public void setLadders(List<Ladders> ladders) {
        this.ladders = ladders;
    }

    public List<Ladders> getLadders() {
        return ladders;
    }


}




