package ParkingLotService;

import ParkingLot.*;
import Spliwise.Model.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotManager {
    private static ParkingService parkingService;

    public static void main(String args[]) {
        parkingService= new ParkingService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (Command.valueOf(commandType)) {
                case Create:
                    int numberOfFloors = Integer.parseInt(commands[1]);
                    int numberOfSlots = Integer.parseInt(commands[2]);
                    parkingService.createParkingLot(numberOfFloors, numberOfSlots);
                    break;
                case Park:

                    String vehicleType = commands[1];
                    String registrationNUmber = commands[2];
                    String color = commands[3];
                    Ticket ticket=null;
                    switch (VehicleType.valueOf(vehicleType)) {

                        case Bike:
                            Bike bike = new Bike(registrationNUmber, color);
                            ticket= parkingService.park(bike);
                            break;
                        case Car:
                            Car car = new Car(registrationNUmber, color);
                            ticket=parkingService.park(car);
                            break;

                        case Truck:
                            Truck truck = new Truck(registrationNUmber, color);
                            ticket=parkingService.park(truck);
                            break;

                    }
                    System.out.println(ticket.getFloorId()+" ,"+ticket.getSlotid()+" ," +ticket.getTicketId());
                    break;
                case UnPark:
                    String ticketNumber = commands[1];
                    parkingService.unPark(ticketNumber);


            }
        }
    }
}
