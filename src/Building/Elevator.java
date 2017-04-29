package Building;

import Button.ButtonPanel;
import Button.ButtonPanelFabric;
import Exception.ElevatorException;
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

    static Builder builder() {
        return new Elevator().new Builder();
    }

    private Elevator(){}

    public class Builder {
        private Builder() {}


        public Builder name(final String name) {
            Elevator.this.name = name;
            return this;
        }

        public Builder countFloor(final int countFloor) {
            Elevator.this.countFloor = countFloor;
            return this;
        }

        public Builder currentFloor(final Floor currentFloor) {
            Elevator.this.currentFloor = currentFloor;
            return this;
        }
        public Builder state(final State state) {
            Elevator.this.state = state;
            return this;
        }
        public Builder serialNumber(final int serialNumber) {
            Elevator.this.serialNumber = serialNumber;
            return this;
        }
        public Builder weightLoading(final int weightLoading) {
            Elevator.this.weightLoading = weightLoading;
            return this;
        }
        public Builder maxWeight(final int maxWeight) {
            Elevator.this.maxWeight = maxWeight;
            return this;
        }
        /*        public Builder buttonPanel(final ButtonPanel buttonPanel) {
                    Elevator.this.buttonPanel = buttonPanel;
                    return this;
                }
                public Builder observerElevators(final List<ObserverElevator> observerElevators) {
                    Elevator.this.observerElevators = observerElevators;
                    return this;
                }
                public Builder passengers(final List<Passenger> passengers) {
                    Elevator.this.passengers = passengers;
                    return this;
                }*/
        public Elevator build() {
            Elevator elevator = new Elevator();
            elevator.name = Elevator.this.name;
            elevator.countFloor = Elevator.this.countFloor;
            elevator.currentFloor = Elevator.this.currentFloor;
            elevator.state = Elevator.this.state;
            elevator.serialNumber = Elevator.this.serialNumber;
            elevator.weightLoading = Elevator.this.weightLoading;
            elevator.maxWeight = Elevator.this.maxWeight;
            elevator.buttonPanel = Elevator.this.buttonPanel;
            elevator.observerElevators = Elevator.this.observerElevators;
            elevator.passengers = Elevator.this.passengers;

            return elevator;
        }
    }

    public void changeFloor(final Floor currentFloor) {
        this.currentFloor.removeElevator(this);
        this.currentFloor = currentFloor;
        this.currentFloor.putElevator(this);
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
        return name +serialNumber +" moves with 0 on " +countFloor +"\n" +currentFloor;
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

    public void putPassenger(final Passenger passenger) throws ElevatorException {
        if (passenger.getWeight() + weightLoading > maxWeight) {
            throw new ElevatorException();
        }
        this.passengers.add(passenger);
        this.weightLoading += passenger.getWeight();
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

    public void setObserverElevator(final List<ObserverElevator> observerElevators) {
        this.observerElevators = observerElevators;
    }

    public void openDoor() {
        state.loadingProcess();
        notifyObserver();
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


/**    public Elevator(final String name, final int countFloor, final int serialNumber) {
 this(name, countFloor, serialNumber, new Floor(0, countFloor));
 }
 public Elevator(final String name, final int countFloor, final int serialNumber, final Floor currentFloor) {
 this.name = name;
 this.countFloor = countFloor;
 this.serialNumber = serialNumber;
 this.currentFloor = currentFloor;
 this.currentFloor.putElevator(this);
 this.state = new State();
 this.weightLoading = 0;
 this.maxWeight = Constant.MAX_WEIGHT;
 this.buttonPanel = ButtonPanelFabric.elevatorButtonPanelEasy(this);
 this.observerElevators = new ArrayList<>();
 this.passengers = new ArrayList<>();
 }*/