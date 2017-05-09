package Thread;

import Building.Building;
import Logic.Header;
import Passenger.Passenger;

/**
 * Created by myasnikov
 * on 27.04.2017.
 */
public abstract class CreateBuilding {
    private static void createBuilding(int floor, int elevator) {
        elevator = elevator > 0 ? elevator : 1;
        floor = floor > 1 ? floor : 2;
        Building building = new Building(floor, elevator);
        Header header = new Header(building);
        PassengerThread passengerThread = new PassengerThread(building);
        Thread passengerThreadGenerator = new Thread(passengerThread);
        passengerThreadGenerator.start();
    }
    public static void request() {
        System.out.println("Building spawn");
        createBuilding(9, 5);
    }
}
