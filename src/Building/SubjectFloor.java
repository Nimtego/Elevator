package Building;

/**
 * Created by myasnikov on 17.02.2017.
 */
public interface SubjectFloor {
    public void registerObserver(ObserverFloor observer);
    public void removeObserver(ObserverFloor observer);
    public void notifyObserver();
}
