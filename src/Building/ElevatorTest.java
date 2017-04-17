package Building;

import Button.ButtonPanel;
import Passenger.Passenger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by myasnikov on 21.03.2017.
 */
public class ElevatorTest {
    private Elevator elevatorTest;

    @Before
    public void init() { elevatorTest = ElevatorsFabric.simple(6, new Building(1, 6).getFloor(1)); }
    @After
    public void tearDown() { elevatorTest = null; }

    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(ElevatorTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

/*   @Before
    public void setUp() throws Exception {

    }*/

    @Test
    public void changeFloor() throws Exception {
        Floor changedFloor = new Floor(2, 10);
        elevatorTest.changeFloor(changedFloor);
        assertEquals(changedFloor, elevatorTest.getCurrentFloor());
    }

    @Test
    public void checkAllowableWeight() throws Exception {
        assertEquals(true, elevatorTest.checkAllowableWeight());
    }

    @Test
    public void registerObserver() throws Exception {

    }

    @Test
    public void removeObserver() throws Exception {

    }

    @Test
    public void notifyObserver() throws Exception {

    }


    @Test
    public void getName() throws Exception {

    }

    @Test
    public void setName() throws Exception {

    }

    @Test
    public void getCountFloor() throws Exception {

    }

    @Test
    public void setCountFloor() throws Exception {

    }

    @Test
    public void getCurrentFloor() throws Exception {

    }

    @Test
    public void setCurrentFloor() throws Exception {

    }

    @Test
    public void getSerialNumber() throws Exception {

    }

    @Test
    public void setSerialNumber() throws Exception {

    }

    @Test
    public void putPassenger() throws Exception {

    }

    @Test
    public void removePassenger() throws Exception {

    }

    @Test
    public void getWeightLoading() throws Exception {

    }

    @Test
    public void setWeightLoading() throws Exception {

    }

    @Test
    public void getButtonPanel() throws Exception {

    }

    @Test
    public void setButtonPanel() throws Exception {

    }

    @Test
    public void getPassengers() throws Exception {

    }

    @Test
    public void setPassengers() throws Exception {

    }

    @Test
    public void getState() throws Exception {

    }

    @Test
    public void setState() throws Exception {

    }

    @Test
    public void getMaxWeight() throws Exception {

    }

    @Test
    public void setMaxWeight() throws Exception {

    }

    @Test
    public void compareTo() throws Exception {

    }

}