package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFloor {
    private int floorid;
    private int maxSlotSize;

    private List<BikeParkingSlot> bikeParkingSlots;
    private List<TruckParkingSlot> truckParkingSlots;
    private List<CarParkingSlot> carParkingSlots;

    public ParkingLotFloor(int floorId,int maxSlotSize){
        this.floorid=floorId;
        this.bikeParkingSlots=new ArrayList<BikeParkingSlot>();
        this.truckParkingSlots= new ArrayList<TruckParkingSlot>();
        this.carParkingSlots=new ArrayList<CarParkingSlot>();
        this.maxSlotSize=maxSlotSize;
    }

    public void setFloorid(int floorid) {
        this.floorid = floorid;
    }
    public int getFloorid(){
        return this.floorid;
    }

    public void setBikeParkingSlots(List<BikeParkingSlot> bikeParkingSlots){
        this.bikeParkingSlots=bikeParkingSlots;
    }

    public List<BikeParkingSlot> getBikeParkingSlots(){
        return this.bikeParkingSlots;
    }

    public void setTruckParkingSlots(List<TruckParkingSlot> truckParkingSlots){
        this.truckParkingSlots=truckParkingSlots;
    }

    public List<TruckParkingSlot> getTruckParkingSlots(){
        return this.truckParkingSlots;
    }

    public void setCarParkingSlots(List<CarParkingSlot> carParkingSlots) {
        this.carParkingSlots = carParkingSlots;
    }

    public List<CarParkingSlot> getCarParkingSlots(){
        return this.carParkingSlots;
    }


    public boolean isBikeFull(){
        return this.bikeParkingSlots.size()==this.maxSlotSize;
    }


    public boolean isCarFull(){
        return this.carParkingSlots.size()==this.maxSlotSize;
    }

    public boolean isTruckFull(){
        return this.truckParkingSlots.size()==this.maxSlotSize;
    }

}
