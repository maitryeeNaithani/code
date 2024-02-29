package Service;
import Model.*;

import java.util.*;


public class Driver{

    public static void main(String [] args)throws Exception{
        Scanner sc= new Scanner(System.in);
        int numberOfSnakes= sc.nextInt();
        List <Snakes> snakes= new ArrayList<Snakes>();
        for(int i=0;i<numberOfSnakes;++i){
            snakes.add(new Snakes(sc.nextInt(),sc.nextInt()));
        }

        int numberOfLadders= sc.nextInt();
        List <Ladders> ladders= new ArrayList<Ladders>();
        for(int i=0;i<numberOfLadders;++i){
            ladders.add(new Ladders(sc.nextInt(),sc.nextInt()));
        }

        int boardSize= sc.nextInt();
        int numberOfPlayers= sc.nextInt();
        List <Player> players= new ArrayList<Player>();
        for(int i=0;i<numberOfPlayers;++i){
            players.add(new Player(sc.next()));
        }
        //SnakesAndLadderService snakesAndLadderService= new SnakesAndLadderService(boardSize);
        //snakesAndLadderService.setSnakes(snakes);
        //snakesAndLadderService.setLadders(ladders);
        //snakesAndLadderService.setPlayer(players);
        //snakesAndLadderService.startGame();

    }

}