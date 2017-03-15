package Button;

import Building.Floor;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class CallButton extends Button {
    public CallButton(Action action, final ButtonPanel owner, ButtonState buttonState) {
        super(action, owner, buttonState);
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
        for (ObserverButton observerButton : this.observerButtons) {
            observerButton.update(this);
        }
    }
}
