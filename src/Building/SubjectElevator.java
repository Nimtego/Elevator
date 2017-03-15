package Building;


/**
 * Created by myasnikov on 17.02.2017.
 */
public interface SubjectElevator {
    public void registerObserver(ObserverElevator observer);
    public void removeObserver(ObserverElevator observer);
    public void notifyObserver();
}
