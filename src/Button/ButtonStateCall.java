package Button;

/**
 * Created by myasnikov on 22.02.2017.
 */
public class ButtonStateCall extends ButtonState {
    private boolean upOrDawn;

    public ButtonStateCall(boolean upOrDawn) {
        super(false);
        this.upOrDawn = upOrDawn;
    }
    public boolean getUpOrDawn() {
        return upOrDawn;
    }
    public void setUpOrDawn(boolean upOrDawn) {
        this.upOrDawn = upOrDawn;
    }
}
