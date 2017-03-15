package Button;

/**
 * Created by myasnikov on 20.02.2017.
 */
public interface SubjectButton {
    void registerObserver(ObserverButton observer);
    void removeObserver(ObserverButton observer);
    void notifyObserver();
}
