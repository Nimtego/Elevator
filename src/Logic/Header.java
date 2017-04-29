package Logic;

import Building.*;
import Button.*;
import Passenger.Passenger;
import View.Visual;

import java.util.*;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class Header implements ObserverElevator, ObserverFloor {
    private Building building;
    private MoveElevator moveElevator = new MoveElevator(null, null);
    public Header(final Building building) {
        this.building = building;
        setObserversSubjectElevators();
        setObserversSubjectFloor();
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
        if (elevator.getState().isLoading()) {
            System.out.println("BLOC REMOVE IN HEADER " +elevator.getSerialNumber() +" in " +elevator.getCurrentFloor().getNumberFloor());
 /*           for (Passenger passenger : elevator.getCurrentFloor().getPassengers()) {
                passenger.elevatorInFloor();
            }*/
            List<Passenger> passengers = elevator.getCurrentFloor().getPassengers();
            for (int i = 0; i < passengers.size(); i++) {   //foreach выбрасывает ConcurrentModificationException
                passengers.get(i).elevatorInFloor(elevator);
            }
        }
        Visual.visual(building);
    }

    @Override
    public void update(Floor floor, Button button) {
        Elevator elevator = ElevatorGetter.takeFreeElevator(building.getListOfElevators(), button);
    //    Elevator elevator = takeFreeElevator(floor);
        moveElevator.setFloor(floor);
        moveElevator.setElevator(elevator);
        Thread threadElevator = new Thread(moveElevator);
        threadElevator.start();
  //      MoveElevator.moveElevator(elevator, floor);
        floor.getButtonPanel().taskComplete(button);

    }

    @Override
    public void update() {
        Visual.visual(building);
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
                if (elevator == null) {
                    elevator = building.getListOfElevators().get(0);
                }
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
        Elevator elevator = sortByFloor(sortElevator).get(0);
        if (elevator == null) {   // TODO: 26.04.2017 костыль который не пашет
            return building.getListOfElevators().get(0);
        }
        return sortByFloor(sortElevator).get(0);
    }
    private boolean fellowTraveller(final Floor floor, final Elevator elevator)  {
        List<Button> button = floor.getButtonPanel().getButtons();
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
