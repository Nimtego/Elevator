package Button;
import Building.Elevator;
import Building.Floor;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class ButtonPanelFabric {
    public static ButtonPanel elevatorButtonPanelEasy(final Elevator elevator) {
        Button[] button = new Button[elevator.getCountFloor()];
        for (int i = 0; i < elevator.getCountFloor(); i++) {
            button[i] = new MovementButton(i);
        }
        return new ElevatorButtonPanel(button, elevator);
    }
    public static ButtonPanel floorButtonPanelEasy(final Floor floor) {
        Button[] button;
        if (floor.getNumberFloor() == 0) {
            button = new Button[1];
            button[0] = new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(true));
            return new FloorButtonPanel(button, floor);
        }
        if (floor.getNumberFloor() == floor.getMaxValueFloor()) {
            button = new Button[1];
            button[0] = new CallButton(new CallAction(false), new FloorButtonPanel(button, floor), new ButtonStateCall(false));
            return new FloorButtonPanel(button, floor);
        }
        button = new Button[2];
        button[0] = new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(true));
        button[1] = new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(false));
        return new FloorButtonPanel(setObservers(button, floor), floor);
    }
    public static Button[] setObservers(Button[] buttons, Floor floor) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].registerObserver(floor);
        }
        return buttons;
    }
}
