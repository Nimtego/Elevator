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

    public void pushTheButton() {
        int numberOfButton;
        int countFloor = owner.getCountFloor().getNumberFloor();
        if (countFloor < targetFloor) {
            numberOfButton = countFloor > 0 ? 1 : 0;
            owner.getCountFloor().getButtonPanel().pushButton(numberOfButton);
        }
        if (countFloor > targetFloor) {
            numberOfButton = countFloor < owner.getCountFloor().getMaxValueFloor() ? 1 : 0;
            owner.getCountFloor().getButtonPanel().pushButton(numberOfButton);
        }

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Target floor ");
        stringBuilder.append(targetFloor);
        return String.valueOf(stringBuilder);
    }
}
