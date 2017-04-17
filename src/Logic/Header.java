package Logic;

import Building.*;
import Button.*;
import Exception.ElevatorException;
import View.Visual;

import java.util.*;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class Header implements ObserverElevator, ObserverFloor {
    private Building building;
    private Map<Floor, Elevator> turnOfTasks;

    public Header(final Building building) {
        this.building = building;
        this.turnOfTasks = new HashMap<>();
        setObserversSubjectElevators();
        setObserversSubjectFloor();
    }

    public Map<Floor, Elevator> getTurnOfTasks() {
        return turnOfTasks;
    }

    public void setTurnOfTasks(Map<Floor, Elevator> turnOfTasks) {
        this.turnOfTasks = turnOfTasks;
    }

    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public void update(Elevator elevator) {
        System.out.println("Update in Header is work");
        Visual.visual(building);
    }

    @Override
    public void update(Floor floor, Button button) {
        Elevator elevator = takeFreeElevator(floor);
        MoveElevator.setNewPositionOnBuilding(elevator, floor);

    }
    private void setObserversSubjectElevators() {
        for (Elevator elevator : building.getListOfElevators()) {
            elevator.registerObserver(this);
        }
    }
    private void setObserversSubjectFloor() {
        for (Floor floor : building.getArrayOfFloor()) {
            floor.registerObserver(this);
        }
    }
    private Elevator takeFreeElevator(final Floor floor) {
        List<Elevator> allElevator = building.getListOfElevators();
        List<Elevator> sortElevator = new ArrayList<>();
        for (Elevator elevator : allElevator) {
            if (elevator.getCountFloor() == floor.getNumberFloor() && elevator.getState().isFree()
                    && elevator.checkAllowableWeight()) { // TODO: 22.02.2017
                return elevator;
            }
            if (fellowTraveller(floor, elevator) && elevator.checkAllowableWeight()) {
                sortElevator.add(elevator);
                allElevator.remove(elevator);
            }
            if (elevator.getState().isFree()) {
                sortElevator.add(elevator);
            }
        }
        return sortByFloor(sortElevator).get(0);
    }
    private boolean fellowTraveller(final Floor floor, final Elevator elevator)  {
        Button[] button = floor.getButtonPanel().getButtons();
        for (Button butt : button) {
            if (butt.getButtonState() instanceof ButtonStateCall) {
                return (((ButtonStateCall) butt.getButtonState()).getUpOrDawn() && elevator.getState().isMovementUp()
                        && floor.getNumberFloor() < elevator.getCountFloor());
            }
        }
        return false;
    }
    private List<Elevator> sortByFloor(List<Elevator> elevators) {
        Collections.sort(elevators);
        return elevators;
    }

}
