package Model;
public  class Ladders {
    private int start;
    private int end;

    public Ladders(int start, int end) throws Exception {
        if(end<=start)
            throw new Exception("End of ladder cannot be less than start");
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