package ParkingLot;

public abstract class vehicle {
    String registartionNo;
    String color;
    public vehicle(String registrationNo, String color){
        this.registartionNo= registrationNo;
        this.color= color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegistartionNo(String registartionNo) {
        this.registartionNo = registartionNo;
    }

    public String getRegistartionNo(){
        return this.registartionNo;
    }
}
