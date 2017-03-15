package Building;

import Button.ButtonPanel;
import Button.ButtonPanelFabric;
import Passenger.Passenger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class Elevator implements SubjectElevator, Comparable<Elevator>{
    private String name;
    private int countFloor;
    private Floor currentFloor;
    private State state;
    private int serialNumber;
    private int weightLoading;
    private int maxWeight;
    private ButtonPanel buttonPanel;
    private List<ObserverElevator> observerElevators;
    private List<Passenger> passengers;

    public Elevator(final String name, final int countFloor, final int serialNumber) {
        this(name, countFloor, serialNumber, new Floor(0, countFloor));
    }
    public Elevator(final String name, final int countFloor, final int serialNumber, final Floor currentFloor) {
        this.name = name;
        this.countFloor = countFloor;
        this.serialNumber = serialNumber;
        currentFloor.putElevator(this);
        this.state = new State();
        this.weightLoading = 0;
        this.maxWeight = Constant.MAX_WEIGHT;
        this.buttonPanel = ButtonPanelFabric.elevatorButtonPanelEasy(this);
        this.observerElevators = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void changeFloor(final Floor currentFloor) {
        this.currentFloor = currentFloor;
        notifyObserver();
    }
    public boolean checkAllowableWeight() {
        return weightLoading < maxWeight - Constant.AVERAGE_WEIGHT;
    }
    @Override
    public void registerObserver(ObserverElevator observer) {
        observerElevators.add(observer);
    }

    @Override
    public void removeObserver(ObserverElevator observer) {
        observerElevators.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (ObserverElevator observer : observerElevators) {
            System.out.println("Update in Elevator observer is work");
            observer.update(this);
        }
    }
    @Override
    public String toString() {
        return name +serialNumber +" moves with 0 on " +countFloor /*+"\nCurrent floor "
                +(currentFloor == null ? "NOT SET ELEVATOR" : currentFloor.getCurrent()) +" | Loading weight: "
                +weightLoading*/+"\n" +currentFloor;
    }

 /*   public boolean fellowTraveller(final Floor floor) {
        floor.getButtonPanel().
    }*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountFloor() {
        return countFloor;
    }

    public void setCountFloor(int countFloor) {this.countFloor = countFloor;}

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void putPassenger(final Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void removePassenger(final Passenger passenger) {
        this.passengers.remove(passenger);
    }

    public int getWeightLoading() {
        return weightLoading;
    }

    public void setWeightLoading(int weightLoading) {
        this.weightLoading = weightLoading;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public int compareTo(@NotNull Elevator other) {
        if(this.currentFloor.getNumberFloor() > other.currentFloor.getNumberFloor())
            return 1;
        if(this.currentFloor.getNumberFloor() < other.currentFloor.getNumberFloor())
            return -1;
        return 0;
    }
}
