package Button;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class MovementButton extends Button {
    private int targetToMove;
    public MovementButton(final int targetToMove) {
        super(new MoveAction(), null, null); // TODO: 22.02.2017
        this.targetToMove = targetToMove;
    }

    @Override
    public void registerObserver(ObserverButton observer) {
        observerButtons.add(observer);
    }

    @Override
    public void removeObserver(ObserverButton observer) {
        observerButtons.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (ObserverButton o : observerButtons) {
        //    o.update();
        }
    }
}
