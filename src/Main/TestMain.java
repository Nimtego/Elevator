package Main;

import Thread.CreateBuilding;

/**
 * Created by myasnikov on 16.02.2017.
 */
public class TestMain {
    public static void main(String[] args) throws Exception {

        CreateBuilding.request();

/*        Random rand = new Random();
        Building building = new Building(9, 1);
        System.out.println(building);
        Header header = new Header(building);
        int numberButton = 0;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3000; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    PassengersGenerator.getRandomPassenger(building);
                }
            }
        });
        thread.start();
        for(;;) {
            Thread.sleep(1);
            Visual.visual(building);
        }*/
/*        for (int i = 0; i < 300; i++) {
            int randomFloor = rand.nextInt(9);
            if (randomFloor > 0 && randomFloor < 8)
                numberButton = 1;
            building.getFloor(randomFloor).getButtonPanel().pushButton(numberButton);
            numberButton = 0;
        }*/
    }
}
