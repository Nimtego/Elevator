
import Building.Building;
import Building.Elevator;
import Building.Floor;
import Logic.Header;

import java.util.Random;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        int floor = 9;
        int elevators = 10;
        Random rand = new Random();
        Building building = new Building(elevators, floor);
        Header header = new Header(building);
        for (Elevator elevator : building.getListOfElevators()) {
            elevator.registerObserver(header);
        }
        for (Floor floors : building.getArrayOfFloor()) {
            floors.registerObserver(header);
        }
        for (;;) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("******");
            building.setAndRemoveElevator(building.getFloor(rand.nextInt(floor)),
                    building.getElevator(rand.nextInt(elevators)));
        }
        //Visual.visualBuilding(building);

        /*
        Random rand = new Random();
        int floor = 9;
        int elevators = 10;
        Building building = new Building(elevators, floor);
        Visual.visualBuilding(building);
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 200; j++) {
                System.out.println();
            }
            try {
                building.setAndRemoveElevator(building.getFloor(rand.nextInt(floor)),
                        building.getListOfElevators().get(rand.nextInt(elevators)));
            } catch (Exception e) {
                continue;
            }
            Visual.visualBuilding(building);
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
