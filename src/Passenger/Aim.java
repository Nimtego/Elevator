package Passenger;

import Building.Floor;

import java.util.Random;

/**
 * Created by myasnikov on 21.02.2017.
 */
public class Aim {
    private int targetFloor;
    private Passenger owner;

    public Aim(Passenger owner) {
        this.owner = owner;
        Random random = new Random();
        int target;
        for(;;) {
            target = random.nextInt(owner.getCountFloor().getMaxValueFloor());
            if (target != owner.getCountFloor().getNumberFloor()) {
                break;
            }
        }
        this.targetFloor = target;

    }
    public Aim(final int targetFloor, Passenger owner) {
        this.targetFloor = targetFloor;
        this.owner = owner;
    }

    public int getFloor() {
        return targetFloor;
    }

    public void setFloor(final int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public Passenger getOwner() {
        return owner;
    }

    public void setOwner(Passenger owner) {
        this.owner = owner;
    }
}
