package Building;
import Button.ButtonPanelFabric;
import java.util.ArrayList;

import static Building.Constant.*;

/**
 * Created by myasnikov on 17.04.2017.
 */
public class ElevatorsFabric {

    private static int serialNumber = 0;

    // TODO: 17.04.2017
    public static Elevator simple(final int countFloor, final Floor currentFloor) {

        Elevator elevator = Elevator.builder().name("Elevator \"simple\" ").countFloor(countFloor)
                .maxWeight(1000000/*MAX_WEIGHT_SIMPLE*/).weightLoading(0).currentFloor(currentFloor).state(new State())
                .serialNumber(serialNumber++).build();
        currentFloor.putElevator(elevator);
        elevator.setButtonPanel(ButtonPanelFabric.elevatorButtonPanelEasy(elevator));
        elevator.setObserverElevator(new ArrayList<>());
        elevator.setPassengers(new ArrayList<>());
        return elevator;

    }
    public static Elevator cargo(final int countFloor, final Floor currentFloor) {

        Elevator elevator = Elevator.builder().name("Elevator \"cargo\" ").countFloor(countFloor)
                .maxWeight(MAX_WEIGHT_CARGO).weightLoading(0).currentFloor(currentFloor).state(new State())
                .serialNumber(serialNumber++).build();
        currentFloor.putElevator(elevator);
        elevator.setButtonPanel(ButtonPanelFabric.elevatorButtonPanelEasy(elevator));
        elevator.setObserverElevator(new ArrayList<>());
        elevator.setPassengers(new ArrayList<>());
        return elevator;

    }
}


/*     private String name;
 private int countFloor;
 private Floor currentFloor;
 private State state;
 private int serialNumber;
 private int weightLoading;
 private int maxWeight;
 private ButtonPanel buttonPanel;
 private List<ObserverElevator> observerElevators; --
 private List<Passenger> passengers;--  */