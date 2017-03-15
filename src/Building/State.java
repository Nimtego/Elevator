package Building;

/**
 * Created by myasnikov on 22.02.2017.
 */
public class State {
    private boolean borrow;
    private boolean loading;
    private boolean movementUp;
    private boolean movementDawn;

    public State() {
        this(false, false, false, false);
    }
    public State(boolean borrow, boolean loading, boolean movementUp, boolean movementDawn) {
        this.borrow = borrow;
        this.loading = loading;
        this.movementUp = movementUp;
        this.movementDawn = movementDawn;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isMovementUp() {
        return movementUp;
    }

    public void setMovementUp(boolean movementUp) {
        this.movementUp = movementUp;
    }

    public boolean isMovementDawn() {
        return movementDawn;
    }

    public void setMovementDawn(boolean movementDawn) {
        this.movementDawn = movementDawn;
    }
    public boolean isFree() {
        return !borrow && !loading && !(movementDawn || movementUp);
    }
}
