package Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 17.02.2017.
 */
public abstract class Button implements SubjectButton{
    private String name;
    private Action action;
    private ButtonState buttonState;
    private ButtonPanel owner;
    protected List<ObserverButton> observerButtons;

    public Button(Action action, ButtonPanel owner, ButtonState buttonState) {
        this.action = action;
        this.owner = owner;
        this.buttonState = buttonState;
        this.observerButtons = new ArrayList<>();
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void push() {
        action.use();
        owner.notificationOfPressing(this);
    }
    public ButtonPanel getOwner() {
        return owner;
    }

    public void setOwner(final ButtonPanel owner) {
        this.owner = owner;
    }

    public ButtonState getButtonState() {
        return buttonState;
    }

    public void setButtonState(ButtonState buttonState) {
        this.buttonState = buttonState;
    }
}
