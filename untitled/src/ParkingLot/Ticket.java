package ParkingLot;

public class Ticket {
    private String ticketId;
    private final String parkingLotId= "PR1234";
    private int floorId;
    private int slotid;
    private vehicle vehicle;

    public  Ticket(int floorId,int slotid,vehicle vehicle){
        this.floorId=floorId;
        this.slotid=slotid;
        this.ticketId=parkingLotId+'_'+floorId+'_'+slotid;
        this.vehicle= vehicle;

    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(int floorId,int slotid) {
        this.ticketId = parkingLotId+'_'+floorId+'_'+slotid;
    }

    public String getParkingLotFloor(){
        return parkingLotId;

    }

    public void setVehicle(vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public vehicle getVehicle() {
        return vehicle;
    }
}
