package ParkingLot;

public abstract class ParkingSlot {
    private int slotId;
    private int  floorId;
    private boolean isEmpty;
    private vehicle parkedVehicle;

    public ParkingSlot(int slotId, int floorId, vehicle parkedVehicle, boolean isEmpty){
        this.slotId=slotId;
        this.floorId= floorId;
        this.parkedVehicle=parkedVehicle;
        this.isEmpty= isEmpty;
    }

    public int getfloorId(){
        return this.floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSlotId(){
        return this.slotId;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }
}

