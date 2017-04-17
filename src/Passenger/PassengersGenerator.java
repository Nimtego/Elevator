package Passenger;

import Building.Building;
import Building.Floor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by myasnikov on 17.03.2017.
 */
public class PassengersGenerator {

    private static ArrayList<String> name = new ArrayList<>();
    private static int countOfPassenger = 0;

    public static Passenger getRandomPassanger(Building building) {
        return new Passenger(getName(), getWeight(), getFloor(building));
    }
    private static String getName() {
        countOfPassenger++;
        String generatedName = "P-" +countOfPassenger;
        name.add(generatedName);
        return generatedName;
    }
    private static int getWeight() {
        Random rand = new Random();
        return rand.nextInt(100) + 21;
    }
    private static Floor getFloor(final Building building) {
        Random random = new Random();
        return building.getFloor(random.nextInt(building.getCountFloor()) + 1);
    }
}
