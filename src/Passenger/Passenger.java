package Passenger;

import Building.Elevator;
import Building.Floor;

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

    public void setAim(Aim aim) {
        this.aim = aim;
    }
}
