package Button;

/**
 * Created by myasnikov on 22.02.2017.
 */
public abstract class ButtonState {
    private boolean isPush;
    public ButtonState(boolean isPush) {
        this.isPush = isPush;
    }
    public boolean isPush() {
        return isPush;
    }
    public void setPush(boolean push) {
        isPush = push;
    }

}
