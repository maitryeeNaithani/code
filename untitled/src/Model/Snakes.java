
package Model;
public class Snakes{
    private int start;
    private int end;

    public Snakes(int start, int end) throws Exception {
        if(end>=start)
            throw new Exception("Start of Snakes cannot be less than End");
        this.start= start;
        this.end= end;
    }

    public int getStart(){
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }
}
