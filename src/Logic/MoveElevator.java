package Logic;

import Building.Elevator;
import Building.Floor;

/**
 * Created by myasnikov on 22.02.2017.
 */
public class MoveElevator {
    public static void setNewPositionOnBuilding(Elevator elevator, Floor floor) {
        elevator.changeFloor(floor);
    }
}
