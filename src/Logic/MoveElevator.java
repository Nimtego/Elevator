package Logic;

import Building.Constant;
import Building.Elevator;
import Building.Floor;

import java.util.Map;

/**
 * Created by myasnikov on 22.02.2017.
 */
public class MoveElevator implements Runnable{

    private Elevator elevator;
    private Floor floor;

    public MoveElevator(Elevator elevator, Floor floor) {
        this.elevator = elevator;
        this.floor = floor;
    }

    @Override
    public void run() {
        moveElevator(elevator, floor);
    }

    public void moveElevator(Elevator elevator, Floor floor) {
        try {
            Thread.sleep(Constant.SPEED_ELEVATOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int elevatorFloor = elevator.getCurrentFloor().getNumberFloor();
        int targetFloor = floor.getNumberFloor();
        if (elevatorFloor > targetFloor) {
            Floor previous = elevator.getCurrentFloor().getPrevious();
            if (previous != null) {
                elevator.changeFloor(previous);
            }
            moveElevator(elevator, floor);
        }
        if  (elevatorFloor < targetFloor) {
            Floor next = elevator.getCurrentFloor().getNext();
            if (next != null) {
                try {
                    Thread.sleep(Constant.SPEED_ELEVATOR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevator.changeFloor(next);

            }
            moveElevator(elevator, floor);
        }
        elevator.openDoor();
    }
    private void move(final boolean up){}

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
