package ParkingLotService;

import ParkingLot.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingService<hashMap> {

    private ParkingLot parkinglot;
    private int numberOfSlots;
    private List<Ticket> ticketsGenerated;


    public ParkingService() {
        parkinglot = null;
        ticketsGenerated = new ArrayList<Ticket>();


    }

    public void createParkingLot(int numberOfFloors, int numOfSlots) {
        List<ParkingLotFloor> parkingLotFloors = new ArrayList<>();
        this.numberOfSlots = numOfSlots;
        for (int i = 0; i < numberOfFloors; ++i) {
            ParkingLotFloor parkingLotFloor = new ParkingLotFloor(i, numOfSlots);
            parkingLotFloors.add(parkingLotFloor);
        }
        this.parkinglot = new ParkingLot(parkingLotFloors);
    }

    public Ticket park(vehicle vehicle) {
        ParkingLotFloor parkinglotfloor = null;
        ParkingSlot parkingSlot = null;
        if (vehicle instanceof Bike) {

            parkinglotfloor = this.parkinglot.getParkingLotFloors().stream()
                    .filter(floor -> !floor.isBikeFull())
                    .findFirst().get();
            parkingSlot = new BikeParkingSlot(parkinglotfloor.getBikeParkingSlots().size() + 1, parkinglotfloor.getFloorid(), vehicle, false);

            parkinglotfloor.getBikeParkingSlots().add((BikeParkingSlot) parkingSlot);

        } else if (vehicle instanceof Car) {
            parkinglotfloor = parkinglot.getParkingLotFloors().stream()
                    .filter(floor -> !floor.isCarFull())
                    .findFirst().get();
            parkingSlot = new CarParkingSlot(parkinglotfloor.getCarParkingSlots().size() + 1, parkinglotfloor.getFloorid(), vehicle, false);
            parkinglotfloor.getCarParkingSlots().add((CarParkingSlot) parkingSlot);
        } else if (vehicle instanceof Truck) {

            parkinglotfloor = parkinglot.getParkingLotFloors().stream()
                    .filter(floor -> !floor.isTruckFull())
                    .findFirst().get();
            parkingSlot = new TruckParkingSlot(parkinglotfloor.getTruckParkingSlots().size() + 1, parkinglotfloor.getFloorid(), vehicle, false);
            parkinglotfloor.getTruckParkingSlots().add((TruckParkingSlot) parkingSlot);
        }
        Ticket ticketGenerated = new Ticket(parkinglotfloor.getFloorid(), parkingSlot.getSlotId(), vehicle);
        ticketsGenerated.add(ticketGenerated);
        return ticketGenerated;
    }

    public vehicle unPark(String ticketId) {
        Optional<Ticket> optionalTicket = ticketsGenerated.stream().filter(x -> x.getTicketId().equals(ticketId)).findFirst();
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();

            ParkingLotFloor floorParkedOn = parkinglot.getParkingLotFloors().stream().filter(x -> x.getFloorid() == ticket.getFloorId()).findFirst().get();

            if (ticket.getVehicle() instanceof Car) {
                List<CarParkingSlot> updatedCarSlots = floorParkedOn.getCarParkingSlots().stream()
                        .filter(slot -> !(slot.getSlotId() == ticket.getSlotid())).collect(Collectors.toList());
                floorParkedOn.setCarParkingSlots(updatedCarSlots);

            } else if (ticket.getVehicle() instanceof Bike) {
                List<BikeParkingSlot> updatedBikeSlots = floorParkedOn.getBikeParkingSlots().stream()
                        .filter(slot -> !(slot.getSlotId() == ticket.getSlotid())).collect(Collectors.toList());
                floorParkedOn.setBikeParkingSlots(updatedBikeSlots);

            } else if (ticket.getVehicle() instanceof Truck) {
                List<TruckParkingSlot> updatedTruckSlots = floorParkedOn.getTruckParkingSlots().stream()
                        .filter(slot -> !(slot.getSlotId() == ticket.getSlotid())).collect(Collectors.toList());
                floorParkedOn.setTruckParkingSlots(updatedTruckSlots);

            }


            return ticket.getVehicle();

        }
        return null;
    }
}





