package Building;

import View.Visual;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class Building {
    private List<Elevator> listOfElevators;
    private List<Floor> listOfFloor;
    private int countFloor;

    public Building(final int countFloor) {
        this(countFloor, 1);
    }
    public Building(final int countFloor, final int countElevators) {
        this.listOfElevators = new ArrayList<>();
        this.countFloor = countFloor;
        this.listOfFloor = new ArrayList<>();
        generateArrayOfFloor(countFloor);
        generateListOfElevators(countElevators);
    }

    public Building(List<Elevator> listOfElevators, int countFloor) {
        this.listOfElevators = listOfElevators;
        this.countFloor = countFloor;
    }

    public List<Elevator> getListOfElevators() {
        return listOfElevators;
    }

    public void setListOfElevators(List<Elevator> listOfElevators) {
        this.listOfElevators = listOfElevators;
    }

    public int getCountFloor() {
        return countFloor;
    }

    public void setCountFloor(int countFloor) {
        this.countFloor = countFloor;
    }

    public List<Floor> getArrayOfFloor() {
        return listOfFloor;
    }

    public void setArrayOfFloor(List<Floor> listOfFloor) {
        this.listOfFloor = listOfFloor;
    }

    private void generateListOfElevators(final int countElevators) {
        for (int i = 0; i < countElevators; i++ ) {
            listOfElevators.add(ElevatorsFabric.simple(countFloor, listOfFloor.get(0)));
        }
    }
    private void generateArrayOfFloor(final int countFloor) {
        for (int i = 0; i < countFloor; i++ ) {
            listOfFloor.add(new Floor(i + 1, countFloor));
        }
        for (int i = 0; i < countFloor; i++ ) {
            Floor floor = listOfFloor.get(i);
            if (i == 0) {
                floor.setPrevious(null);
                floor.setNext(listOfFloor.get(i + 1));
                continue;
            }
            if (i == countFloor - 1) {
                floor.setPrevious(listOfFloor.get(i - 1));
                floor.setNext(null);
                continue;
            }
            floor.setPrevious(listOfFloor.get(i - 1));
            floor.setNext(listOfFloor.get(i + 1));
        }
    }
    public Floor getFloor(final int numberFloor) {
        if (numberFloor < 0 || numberFloor > listOfFloor.size() - 1)
            throw new ArrayIndexOutOfBoundsException();
        return listOfFloor.get(numberFloor);
    }
    public void setAndRemoveElevator(Floor toSet, Elevator elevator) throws Exception {
/*        if (toSet.getElevator(elevator)) {
            throw new Exception();
        }*/
        Floor clear = elevator.getCurrentFloor();
        toSet.putElevator(elevator);
        clear.removeElevator(elevator);
    }
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Building count floor ");
        build.append(countFloor);
        build.append("\n");
        build.append("Count of elevators: ");
        build.append(listOfElevators.size());
        build.append("\n");
        for (Elevator e : listOfElevators) {
            build.append("\n");
            build.append(e);
        }
        return build.toString();
    }

}
