
import Building.Building;
import Building.Elevator;
import Building.Floor;
import Logic.Header;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        Building building = new Building(4, 9);
        Header header = new Header(building);
        for (Elevator elevator : building.getListOfElevators()) {
            elevator.registerObserver(header);
        }
        for (Floor floors : building.getArrayOfFloor()) {
            floors.registerObserver(header);
        }
        System.out.println(building);
/*        System.out.println(building);
        Visual.visual(building);
        building.getListOfElevators().get(1).changeFloor(building.getFloor(3));
        for (Floor floor : building.getArrayOfFloor()) {
            for (Elevator elevator1 : floor.getCurrent()) {
                System.out.print(elevator1.getSerialNumber());
            }
            System.out.println();
        }
        System.out.println(building);*/



/*        Elevator elevator = building.getListOfElevators().get(0);
        elevator.changeFloor(building.getFloor(4));
        System.out.println(elevator.getCurrentFloor());
        for (Elevator elevator1 : building.getListOfElevators()) {
            System.out.println(elevator1.getCurrentFloor().getNumberFloor());
        }
        building.getListOfElevators().get(3).changeFloor(building.getFloor(7));
        for (Floor floor : building.getArrayOfFloor()) {
            for (Elevator elevator1 : floor.getCurrent()) {
                System.out.print(elevator1.getSerialNumber());
            }
            System.out.println();
        }*/

/*        int floor = 9;
        int elevators = 10;
        Random rand = new Random();
        Building building = new Building(elevators, floor);
        Header header = new Header(building);
       for (Elevator elevator :building.getListOfElevators()) {
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
            building.getListOfElevators().get(rand.nextInt(building.getListOfElevators().size()))
                    .changeFloor(building.getArrayOfFloor()[rand.nextInt(building.getCountFloor())]);
        }*/
    /*    //Visual.visualBuilding(building);
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
