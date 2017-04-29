package Button;


import Building.Elevator;

import java.util.List;

/**
 * Created by myasnikov on 17.02.2017.
 */
public class ElevatorButtonPanel extends ButtonPanel {

    public Elevator owner;

    public ElevatorButtonPanel(List<Button> buttons, final Elevator owner) {
        super("Elevator Button Panel " +owner.getName(), buttons);
        this.owner = owner;
    }

    public Elevator getOwner() {
        return owner;
    }

    @Override
    public void update(Button button) {

    }

    @Override
    public void notificationOfPressing(Button button) {

    }

    @Override
    public void taskComplete(Button button) {

    }
/*
    public void setOwner(Elevator owner) {
        this.owner = owner;
    }
    @Override
    public void registerObserver(ObserverButton observer) {
        observerButton.add(observer);
    }

    @Override
    public void removeObserver(ObserverButton observer) {
        observerButton.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (ObserverButton observerButton : this.observerButton) {
            observerButton.update();
        }
    }*/

}
