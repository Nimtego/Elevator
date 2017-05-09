package Test;

import Building.Building;
import Building.Elevator;
import Building.ElevatorsFabric;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by myasnikov
 * on 26.04.2017.
 */
public class BuildingTest {

    private Building buildingTest;
    private final int countFloor = 5;
    private final int countElevators = 2;

    @Before
    public void setUp() throws Exception {
        buildingTest = new Building(countFloor, countElevators);
    }

    @Test
    public void getListOfElevators() throws Exception {
        List<Elevator> listOfElevators = new ArrayList<>();
        for (int i = 0; i < countElevators; i++) {
            listOfElevators.add(ElevatorsFabric.simple(countFloor, buildingTest.getFloor(1)));
        }
        assertEquals(2, buildingTest.getListOfElevators().size());
    }

    @Test
    public void setListOfElevators() throws Exception {
        List<Elevator> listOfElevators = new ArrayList<>();
        for (int i = 0; i < countElevators; i++) {
            listOfElevators.add(ElevatorsFabric.simple(countFloor, buildingTest.getFloor(1)));
        }
        buildingTest.setListOfElevators(listOfElevators);
    }

    @Test
    public void getCountFloor() throws Exception {

    }

    @Test
    public void setCountFloor() throws Exception {

    }

    @Test
    public void getArrayOfFloor() throws Exception {

    }

    @Test
    public void setArrayOfFloor() throws Exception {

    }

    @Test
    public void getFloor() throws Exception {

    }

    @Test
    public void setAndRemoveElevator() throws Exception {

    }

}