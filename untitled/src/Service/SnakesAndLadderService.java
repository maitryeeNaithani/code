package Service;
import Model.*;
import java.util.*;

class GamesService{

    private SnakesAndLaddersBoard snakesAndLaddersBoard;
    private final int boardSize =100;
    private Queue<Player> players;
    private int initialNumberOfPlayers;
    private DiceService diceService;
    private Games games;


    public GamesService(int boardSize){
        this.snakesAndLaddersBoard= new SnakesAndLaddersBoard(boardSize);
        this.diceService= new DiceService();
        this.players = new LinkedList<>();
        this.games= new Games();


    }

    public void setPlayer(List<Player> players){
        this.players= new LinkedList<Player>();
        this.initialNumberOfPlayers= players.size();
        HashMap<String, Integer> playerCurrentPos= new HashMap<>();
        for(Player player :players) {
            this.players.add(player);
            playerCurrentPos.put(player.getId(), 0);
        }
            games.setPlayerCurrentPos(playerCurrentPos);
    }

    public void setSnakes(List<Snakes> snakes){
        snakesAndLaddersBoard.setSnakes(snakes);
    }
    public void setLadders(List<Ladders> ladders){
        snakesAndLaddersBoard.setLadders(ladders);
    }

    public int getTotalValueAfterDiceRoll(){
        return diceService.roll();
    }

    private boolean hasPlayerWon(Player player){
        int playerPosition= games.getPlayerCurrentPos().get(player.getId());
        int winningPosition= boardSize;
        return playerPosition==winningPosition;
    }

    private void movePlayer(Player player, int position){
        int oldPosition= games.getPlayerCurrentPos().get(player.getId());
        int newPosition= oldPosition+position;

        if(newPosition>boardSize){
            newPosition=oldPosition;
        }
        else
        {
            newPosition= getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }
       games.getPlayerCurrentPos().put(player.getId(),newPosition);
       System.out.println(player.getName()+" rolled a "+ position+" and moved to new position: "+newPosition );
    }

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition){
        int previousPosition;
        do{
            previousPosition=newPosition;
            for( Snakes snakes:snakesAndLaddersBoard.getSnakes()){
                if(newPosition== snakes.getStart()){
                    newPosition= snakes.getEnd();
                }
            }
            for( Ladders ladders: snakesAndLaddersBoard.getLadders()){
                if(newPosition== ladders.getStart()){
                    newPosition= ladders.getEnd();
                }
            }
        }
        while(previousPosition!= newPosition);
       return newPosition;
    }
   private boolean isGameCompleted(){
        int currentNumberOfPlayers= players.size();
        return currentNumberOfPlayers <initialNumberOfPlayers;
   }

   public void startGame(){

        while(!isGameCompleted()){
            int diceValue= getTotalValueAfterDiceRoll();
            Player currentPlayer= players.poll();
            movePlayer(currentPlayer,diceValue);
            if(hasPlayerWon( currentPlayer)){
                System.out.println(currentPlayer.getName()+"wins the game");
            }
            else
                players.add(currentPlayer);
        }
   }
}