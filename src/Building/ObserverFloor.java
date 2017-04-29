package Building;

import Button.Button;

/**
 * Created by myasnikov on 17.02.2017.
 */
public interface ObserverFloor {
    void update(Floor floor, Button button);
    void update();
}
