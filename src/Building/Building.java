package Building;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class Building {
    private List<Elevator> listOfElevators;
    private Floor[] arrayOfFloor;
    private int countFloor;

    public Building(final int countFloor) {
        this.countFloor = countFloor;
    }
    public Building(int countElevators, int countFloor) {
        this.listOfElevators = new ArrayList<>();
        this.countFloor = countFloor;
        generateListOfElevators(countElevators);
        arrayOfFloor = new Floor[countFloor];
        generateArrayOfFloor(countFloor);
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

    public Floor[] getArrayOfFloor() {
        return arrayOfFloor;
    }

    public void setArrayOfFloor(Floor[] arrayOfFloor) {
        this.arrayOfFloor = arrayOfFloor;
    }

    private void generateListOfElevators(final int countElevators) {
        for (int i = 0; i < countElevators; i++ ) {
            listOfElevators.add(new Elevator("Elevator ", countFloor, i));
        }
    }
    private void generateArrayOfFloor(final int countFloor) {
        for (int i = 0; i < countFloor; i++ ) {
            arrayOfFloor[i] = new Floor(i + 1, countFloor);
        }
        initialSituationElevators(0);
    }
    private void initialSituationElevators(final int situation) {
        for (Elevator e : listOfElevators) {
            arrayOfFloor[situation].putElevator(e);
        }
    }
    public Floor getFloor(final int numberFloor) {
        if (numberFloor < 0 || numberFloor > arrayOfFloor.length - 1)
            throw new ArrayIndexOutOfBoundsException();
        return arrayOfFloor[numberFloor];
    }
    public void setAndRemoveElevator(Floor toSet, Elevator elevator) throws Exception {
        if (toSet.getElevator(elevator)) {
            throw new Exception();
        }
        Floor clear = elevator.getCurrentFloor();
        toSet.putElevator(elevator);
        clear.removeElevator(elevator);
    }
    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Building count floor ");
        build.append(countFloor);
        build.append("\n\n");
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
