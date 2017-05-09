package Thread;

import Building.Building;
import Passenger.PassengersGenerator;
import View.Visual;

/**
 * Created by myasnikov
 * on 27.04.2017.
 */
public class PassengerThread implements Runnable{
    private Building building;

    public PassengerThread(Building building) {
        this.building = building;
    }

    @Override
    public void run() {
        for  (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PassengersGenerator.getRandomPassenger(building).push();
        }
    }
    public void removeThread() {
    }

}
