package Button;

import Building.Floor;

/**
 * Created by myasnikov on 22.02.2017.
 */
public class ButtonStateToFloor extends ButtonState {
    private Floor toFloor;

    public ButtonStateToFloor(final Floor toFloor) {
        super(false);
        this.toFloor = toFloor;
    }

    public Floor getToFloor() {
        return toFloor;
    }

    public void setToFloor(Floor toFloor) {
        this.toFloor = toFloor;
    }
}
