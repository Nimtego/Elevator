package Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myasnikov on 17.02.2017.
 */
public abstract class ButtonPanel implements ObserverButton{
    private String name;
    private List<Button> buttons;
    protected List<ObserverButton> observerButton;

    ButtonPanel(String name, List<Button> buttons) {
        this.name = name;
        this.buttons = buttons;
        this.observerButton = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public List<ObserverButton> getObserverButton() {
        return observerButton;
    }
    public Button getIsActive() {
        for (Button button : buttons) {
            if (button.getAction().isPush()) {
                return button;
            }
        }
        return null;
    }
    public void pushButton(final int number) {
        buttons.get(number).push();
    }

    public void setObserverButton(List<ObserverButton> observerButton) {
        this.observerButton = observerButton;
    }
    public abstract void notificationOfPressing(Button button);
    public abstract void taskComplete(final Button button);

}
