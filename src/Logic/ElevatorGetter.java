package Logic;

import Building.Elevator;
import Building.Floor;
import Button.Button;
import Button.FloorButtonPanel;
import Button.ButtonPanel;
import Button.CallAction;
import Button.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by myasnikov
 * on 28.04.2017.
 */
public class ElevatorGetter {
    public static Elevator takeFreeElevator(final List<Elevator> elevatorList, Button button) {  // TODO: 28.04.2017 есть нуллпоинтэксепшен
        int maxDistance = elevatorList.get(0).getCountFloor();
        CallAction action = (CallAction)button.getAction();
        Floor floorCall = ((FloorButtonPanel)button.getOwner()).getOwner();
        Elevator totalElevator;

        List<Elevator> fellowTravellerElevators = fellowTraveller(elevatorList, floorCall, action);
        List<Elevator> standbyElevators = standby(elevatorList, floorCall, action);

        if (!floorCall.getCurrent().isEmpty()) {
            return floorCall.getCurrent().get(0);
        }

        for (int i = 0; i < fellowTravellerElevators.size(); i++) {
            int numberFloor = fellowTravellerElevators.get(i).getCurrentFloor().getNumberFloor();
            if (floorCall.getNumberFloor() -  numberFloor < maxDistance) {
                maxDistance = numberFloor;
                fellowTravellerElevators.add(0, fellowTravellerElevators.remove(i));
            }
        }
        maxDistance = elevatorList.get(0).getCountFloor();
        for (int i = 0; i < standbyElevators.size(); i++) {
            int numberFloor = standbyElevators.get(i).getCurrentFloor().getNumberFloor();
            if (floorCall.getNumberFloor() -  numberFloor < maxDistance) {
                maxDistance = numberFloor;
                standbyElevators.add(0, standbyElevators.remove(i));
            }
        }
        if (fellowTravellerElevators.get(0) != null && standbyElevators.get(0) != null) {
            if (floorCall.getNumberFloor() - fellowTravellerElevators.get(0).getCurrentFloor().getNumberFloor() <
                    floorCall.getNumberFloor() - standbyElevators.get(0).getCurrentFloor().getNumberFloor()) {
                totalElevator = fellowTravellerElevators.get(0);
                return totalElevator;
            }
        }
        totalElevator = standbyElevators.get(0);
        return totalElevator == null ? elevatorList.get(0) : totalElevator;
    }

    private static List<Elevator> fellowTraveller(List<Elevator> elevators, Floor floorCall, CallAction action) {
        List<Elevator> fellowTraveller = new ArrayList<>();
        for (Elevator elevator : elevators) {
            if (action.isUpOrDawn()) {
                if (elevator.getCurrentFloor().getNumberFloor() < floorCall.getNumberFloor()
                        && elevator.checkAllowableWeight()) {
                    fellowTraveller.add(elevator);
                }
            }
            if (!action.isUpOrDawn()) {
                if (elevator.getCurrentFloor().getNumberFloor() > floorCall.getNumberFloor()
                        && elevator.checkAllowableWeight()) {
                    fellowTraveller.add(elevator);
                }
            }
        }
        return fellowTraveller;
    }
    private static List<Elevator> standby(List<Elevator> elevators, Floor floorCall, CallAction action) {
        List<Elevator> standbyElevators = new ArrayList<>();
        for (Elevator elevator : elevators) {
            if (elevator.getState().isFree()) {
                standbyElevators.add(elevator);
            }
        }
        return standbyElevators;
    }


}
