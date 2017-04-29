package Building;
import Button.*;
import Passenger.Passenger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class Floor implements SubjectFloor, ObserverButton {

    private String information = "Floor";
    private Floor next;
    private Floor previous;
    private int maxValueFloor;
    private int numberFloor;
    private List<Elevator> current;
    private ButtonPanel buttonPanel;
    private List<ObserverFloor> observerFloors;
    private List<Passenger> passengers;

    public Floor(final int numberFloor, final int maxValueFloor) {
        this(numberFloor, maxValueFloor, null);
    }

    public Floor(final int numberFloor, final int maxValueFloor, final Elevator elevator) {
        this.maxValueFloor = maxValueFloor;
        this.numberFloor = numberFloor;
        this.current = new ArrayList<>();
        if (elevator != null)
            putElevator(elevator);
        this.buttonPanel = ButtonPanelFabric.floorButtonPanelEasy(this);
        this.observerFloors = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getInformation() {
        return information;
    }
    public void setInformation(final String information) {
        this.information = information;
    }
    public int getNumberFloor() {
        return numberFloor;
    }
    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
    public List <Elevator> getCurrent() {
        return current;
    }
    public void setCurrent(final List<Elevator> current) {
        this.current = current;
    }
    public void putElevator(final Elevator elevator) {
        current.add(0, elevator);
    }
    public boolean checkSerialNumber(final int serialNumber) {
        if (!current.isEmpty()) {
            for (Elevator elevator : current) {
                if (elevator.getSerialNumber() == serialNumber) {
                    return true;
                }
            }
        }
        return false;
    }
    public void removeElevator(Elevator elevator) {
        current.remove(elevator);
    }
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
    public int getMaxValueFloor() {
        return maxValueFloor;
    }
    public void setMaxValueFloor(int maxValueFloor) {
        this.maxValueFloor = maxValueFloor;
    }
    public Elevator getElevator() {
        return current.get(0);
    }
    public Elevator getElevator(final int index) {
        return current.get(index);
    }
    public boolean getElevator(Elevator elevator) {
        return current.contains(elevator);
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    public void putPassenger(final Passenger passenger) {
        this.passengers.add(passenger);
        notifyObserverForVisual();
    }
    public void removePassenger(final Passenger passenger) {
        this.passengers.remove(passenger);
    }
    public Floor getNext() {
        return next;
    }
    public void setNext(Floor next) {
        this.next = next;
    }
    public Floor getPrevious() {
        return previous;
    }
    public void removeAllPassengers() {
        passengers = new ArrayList<>();
    }

    public void setPrevious(Floor previous) {
        this.previous = previous;
    }
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(information);
        build.append(" number ");
        build.append(numberFloor);
        build.append("\nCount of elevators in floor: ");
        if (current.isEmpty()) {
            build.append("Empty");
        }
        else
            build.append(current.size());
        return build.toString();
    }

    @Override
    public void registerObserver(ObserverFloor observer) {
        observerFloors.add(observer);
    }

    @Override
    public void removeObserver(ObserverFloor observer) {
        observerFloors.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (ObserverFloor observer : observerFloors) {
            observer.update(this, buttonPanel.getIsActive());
        }
    }

    @Override
    public void notifyObserverForVisual() {
        for (ObserverFloor observer : observerFloors) {
            observer.update();
        }
    }

    @Override
    public void update(Button button) {
        notifyObserver();
    }
}
