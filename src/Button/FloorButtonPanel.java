package Button;


import Building.Floor;

import java.util.List;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class FloorButtonPanel extends ButtonPanel {
    private Floor owner;
    public FloorButtonPanel(List<Button> buttons, final Floor owner) {
        super("Floor Button Panel " +owner.getInformation(), buttons);
        this.owner = owner;
    }

    @Override
    public void update(Button button) {
        // TODO: 21.02.2017
    }

    @Override
    public void notificationOfPressing(Button button) {
        owner.update(button);
    }

    @Override
    public void taskComplete(Button button) {

    }
    public Floor getOwner() {
        return owner;
    }
}
