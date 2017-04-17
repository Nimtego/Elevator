package View;
import Building.*;

/**
 * Created by myasnikov on 20.02.2017.
 */
public class Visual {
/*    public static Building localBuilding;
    public static int currentFloor;
    public static int arrayOfFloor;
    public static int countOfElevators;
    public static String markerElevator = " ";
    public static String choice = ""; */

    public static void visual(final Building building) {  // TODO: 17.04.2017 опять херобора
        int arrayOfFloor = building.getCountFloor();
        int countOfElevators = building.getListOfElevators().size();
        String markerElevator = Constant.MARKER_ELEVATOR;
        System.out.println(arrayOfFloor + " " + countOfElevators);
        for (int i = 0; i < arrayOfFloor; i++) {
            System.out.print("(" + (arrayOfFloor - i) + ") ");
            if (building.getArrayOfFloor()[arrayOfFloor - i - 1].getCurrent().isEmpty()) {
                for (int k = 0; k < countOfElevators; k++) {
                    System.out.print("[=]");
                }
                System.out.println();
                continue;
            }
            for (int j = 0; j < countOfElevators; j++) {
                for (Elevator el : building.getFloor(i).getCurrent()) {
                    System.out.println(el.getCurrentFloor().getNumberFloor());
                    System.out.println(el.getSerialNumber());
                }
                if (!building.getFloor(i).checkSerialNumber(j)) {
                    System.out.print("[" +markerElevator +"]");
                    continue;
                }
                System.out.print("[+]");
            }
            System.out.println();
        }
    }

    /*public static void visualBuilding(final Building building) { // TODO: 01.03.2017 рабочая но херобора
        System.out.println(building.getArrayOfFloor().toString());
            localBuilding = building;
            currentFloor = randomChoice(building.getCountFloor());
            arrayOfFloor = building.getCountFloor();
            countOfElevators = building.getListOfElevators().size();
            String markerElevator = " ";
            String choice = "";
            System.out.println(arrayOfFloor + " " + countOfElevators);
            for (int i = 0; i < arrayOfFloor; i++) {
                System.out.print("(" + (arrayOfFloor - i) + ") ");
                for (int j = 0; j < countOfElevators; j++) {
                    if (!building.getArrayOfFloor()[arrayOfFloor - i - 1].getCurrent().isEmpty()) {
                        for (Elevator elevator : building.getArrayOfFloor()[arrayOfFloor - i - 1].getCurrent()) {
                            if (elevator.getSerialNumber() == j) {
                                markerElevator = "#";
                            }
                        }
                    }
                    System.out.print("[" + markerElevator + "]");
                    markerElevator = " ";
                }
                if (arrayOfFloor == currentFloor) {
                    System.out.print("[*]");
                }
                System.out.println();
            }
    }
    private static void visualChoiceFloor(final int currentFloor) {
        System.out.println("You are in " +currentFloor +". Choice up(1) or dawn(2)");
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(!(choice.equals("1")) || !(choice.equals("2"))) {
            try {
                choice = read.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            print();
            localBuilding.getArrayOfFloor()[currentFloor].getButtonPanel().pushButton(Integer.parseInt(choice));
        }
    }
    private static int randomChoice(final int floor) {
        Random rand = new Random();
        return rand.nextInt(floor);
    }
    private static void changeFloorElevator() {
        Elevator elevator = localBuilding.getListOfElevators().get(1);
        for (Elevator ele : localBuilding.getListOfElevators()) {
            if (currentFloor - ele.getCurrentFloor().getNumberFloor()
                    < currentFloor - elevator.getCurrentFloor().getNumberFloor()) {
                elevator = ele;
            }
        }

        try {
            int tmp = elevator.getCurrentFloor().getNumberFloor();
            while (tmp != currentFloor) {
                localBuilding.setAndRemoveElevator(localBuilding.getFloor(tmp++), elevator);
                print();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void print() {
        for (int i = 0; i < arrayOfFloor; i++) {
            System.out.print("(" + (arrayOfFloor - i) + ") ");
            for (int j = 0; j < countOfElevators; j++) {
                if (!localBuilding.getArrayOfFloor()[arrayOfFloor - i - 1].getCurrent().isEmpty()) {
                    for (Elevator elevator : localBuilding.getArrayOfFloor()[arrayOfFloor - i - 1].getCurrent()) {
                        if (elevator.getSerialNumber() == j) {
                            markerElevator = "#";
                        }
                    }
                }
                System.out.print("[" + markerElevator + "]");
                markerElevator = " ";
            }
            if (arrayOfFloor == currentFloor) {
                System.out.print("[*]");
            }
            System.out.println();
        }
    }*/
    public static void visualQuest(final Building building){

    }

}
