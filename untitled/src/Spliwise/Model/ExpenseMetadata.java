package Spliwise.Model;

public class ExpenseMetadata {
    private String notes;
    private String name;
    private String imgUrl;

    public ExpenseMetadata(String notes,String name, String imgUrl){
        this.notes= notes;
        this.name= name;
        this.imgUrl= imgUrl;
    }

    public void setNotes(String notes){
        this.notes= notes;
    }
    public String getNotes(){
      return this.notes;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl= imgUrl;
    }
    public String getImgUrl(){
        return this.imgUrl;
    }

    public void setName(String name){
        this.name= name;
    }
    public String getName(){
        return this.name;
    }

}
