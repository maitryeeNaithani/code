package ParkingLot;

import java.util.List;

public class ParkingLot {

    private final String parkingLotId= "PR1234";
    private List<ParkingLotFloor> parkingLotFloors;

    public ParkingLot(List<ParkingLotFloor> parkingLotFloors){
        this.parkingLotFloors=parkingLotFloors;
    }

    public void setParkingLotFloors(List<ParkingLotFloor> parkingLotFloors) {
        this.parkingLotFloors = parkingLotFloors;
    }

    public List<ParkingLotFloor> getParkingLotFloors() {
        return parkingLotFloors;
    }
}
