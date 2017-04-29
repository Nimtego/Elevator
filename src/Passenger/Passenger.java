package Passenger;

import Building.Elevator;
import Building.Floor;
import Exception.ElevatorException;

/**
 * Created by myasnikov on 21.02.2017.
 */
public class Passenger {
    private String name;
    private int weight;
    private Floor countFloor;
    private Elevator countElevator;
    private Aim aim;

    public Passenger(String name, int weight, Floor countFloor) {
        this(name, weight, countFloor, null);
    }
    public Passenger(String name, int weight, Floor countFloor, Aim aim) {
        this.name = name;
        this.weight = weight;
        this.countFloor = countFloor;
        if (aim == null)
            aim = new Aim(this);
        this.aim = aim;
    }

    public void push() {
        aim.pushTheButton();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Floor getCountFloor() {
        return countFloor;
    }

    public void setCountFloor(Floor countFloor) {
        this.countFloor = countFloor;
    }

    public Elevator getCountElevator() {
        return countElevator;
    }

    public void setCountElevator(Elevator countElevator) {
        this.countElevator = countElevator;
    }

    public Aim getAim() {
        return aim;
    }

    public void elevatorInFloor(Elevator elevator) {
        try {
            elevator.putPassenger(this);
        } catch (ElevatorException e) {
            System.out.println("OVERLOAD");
        }
        countElevator = elevator;
        countFloor.removePassenger(this);
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name passenger ");
        stringBuilder.append(name);
        stringBuilder.append(" Floor ");
        stringBuilder.append(countFloor);
        stringBuilder.append(aim);
        return String.valueOf(stringBuilder);
    }
}
