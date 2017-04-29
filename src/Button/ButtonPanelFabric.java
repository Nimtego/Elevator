package Button;
import Building.Elevator;
import Building.Floor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class ButtonPanelFabric {
    public static ButtonPanel elevatorButtonPanelEasy(final Elevator elevator) {
        List<Button> button = new ArrayList<>();
        for (int i = 0; i < elevator.getCountFloor(); i++) {
            button.add(new MovementButton(i));
        }
        return new ElevatorButtonPanel(button, elevator);
    }
    public static ButtonPanel floorButtonPanelEasy(final Floor floor) {
        List<Button> button;
        if (floor.getNumberFloor() == 0) {
            button = new ArrayList<>();
            button.add(new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(true)));
            return new FloorButtonPanel(button, floor);
        }
        if (floor.getNumberFloor() == floor.getMaxValueFloor()) {
            button = new ArrayList<>();
            button.add(new CallButton(new CallAction(false), new FloorButtonPanel(button, floor), new ButtonStateCall(false)));
            return new FloorButtonPanel(button, floor);
        }
        button = new ArrayList<>();
        button.add(new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(true)));
        button.add(new CallButton(new CallAction(true), new FloorButtonPanel(button, floor), new ButtonStateCall(false)));
        return new FloorButtonPanel(setObservers(button, floor), floor);
    }
    public static List<Button> setObservers(List<Button> buttons, Floor floor) {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).registerObserver(floor);
        }
        return buttons;
    }
}
