import java.util.Random;

public class Car implements Runnable {
    String name;

    Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            long beginTime = System.currentTimeMillis();
            int runDistance = 0;
            int distance = 100;
            int step = 5;
            while (runDistance < distance) {
                try {
                    int speed = (new Random().nextInt(20));
                    runDistance += speed;
                    String process = "|";
                    int percentTravel = (runDistance*100) / distance;
                    for (int i = 0; i < distance; i += step) {
                        if (percentTravel >= i + step) {
                            process += "=";
                        } else if (percentTravel >= i && percentTravel < i + step) {
                            process += "o";
                        } else {
                            process += "-";
                        }
                    }
                    process += "|";

                    System.out.println("Car" + this.name + ": " + process + " " + Math.min(distance, runDistance) + "KM");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - beginTime) + "millisecond");
    }
}
