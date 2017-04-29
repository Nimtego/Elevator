package View;
import Building.*;

import java.util.List;

/**
 * Created by myasnikov on 20.02.2017.
 */
public class Visual {
    public static void visual(final Building building) {
        int arrayOfFloor = building.getCountFloor();
        int countOfElevators = building.getListOfElevators().size();
        List<Floor> listFloor = building.getArrayOfFloor();
        int countOfPassengers;
        String markerElevator = Constant.MARKER_ELEVATOR;
        System.out.println(arrayOfFloor + " " + countOfElevators);
        for (int i = 0; i < arrayOfFloor; i++) {
            System.out.print("(" + (arrayOfFloor - i) + ") ");
            for (int count = 0; count < countOfElevators; count++) {
                System.out.print("[");
                if (checkSerialNumber(building.getFloor(arrayOfFloor - i - 1).getCurrent(), count)) {
                    System.out.print(markerElevator + "]");
                    continue;
                }
                System.out.print(" ]");
            }
            countOfPassengers = listFloor.get(arrayOfFloor - 1 - i).getPassengers().size();
            System.out.print("  <" +countOfPassengers +">\n");
        }
        List<Elevator> ele = building.getListOfElevators();
        for (Elevator elev : ele)
            System.out.print(elev.getWeightLoading() +" ");
        System.out.println();
    }
    public static boolean checkSerialNumber(final List<Elevator> elevators, final int serialNumber) {
        for (Elevator elevator : elevators) {
            if (elevator.getSerialNumber() == serialNumber)
                return true;
        }
        return false;
    }

}
