package Button;


import Building.Elevator;
import Building.Floor;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class CallAction implements Action {
    private boolean upOrDawn;
    private boolean isPush;

    public CallAction(){}

    public CallAction(boolean upOrDawn) {
        this.upOrDawn = upOrDawn;
        this.isPush = false;
    }

    @Override
    public void use() {
        isPush = true;
    }

    public boolean isUpOrDawn() {
        return upOrDawn;
    }

    public void setUpOrDawn(boolean upOrDawn) {
        this.upOrDawn = upOrDawn;
    }

    @Override
    public boolean isPush() {
        return isPush;
    }

    public void setPush(boolean push) {
        isPush = push;
    }
}
