package Building;

/**
 * Created by myasnikov on 17.02.2017.
 */
public interface SubjectFloor {
    void registerObserver(ObserverFloor observer);
    void removeObserver(ObserverFloor observer);
    void notifyObserver();
    void notifyObserverForVisual();
}
