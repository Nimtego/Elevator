package Building;


/**
 * Created by myasnikov on 17.02.2017.
 */
public interface SubjectElevator {
    void registerObserver(ObserverElevator observer);
    void removeObserver(ObserverElevator observer);
    void notifyObserver();
}
