import java.util.Random;

public class VehicleRace {
    public static Random rand = new Random();

    public static final int INITIAL_SPEED_MIN = 105;
    public static final int INITIAL_SPEED_MAX = 110;
    public static final int DISTANCE_TO_FINISH = 500;

    public static final int MILLIDELAY = 500;

    public static void main(String[] args) {
        Vehicle car1 = new Vehicle("Toyota", 108, 2);
        Vehicle car2 = new Vehicle("Ford", 106, 2);
        System.out.println(car1.getBrand() + ", " + car1.getSpeed() + ", " + car1.getDistance());
        System.out.println(car2.getBrand() + ", " + car2.getSpeed() + ", " + car2.getDistance());
        System.out.println(car1.getBrand() + " vs. " + car2.getBrand() + "!");
        System.out.println("LET THE RACE BEGIN!");
        results(car1, car2);
    }

    public static void results(Vehicle v1, Vehicle v2) {
        while(!(v1.Won()) && !(v2.Won())) {
            raceCars(v1, v2);
            if (v2.Won()) {
                System.out.println(v1.getBrand() + " lost. " + v2.getBrand() + " won!");
            } else {
                if (v1.Won()) {
                    System.out.println(v2.getBrand() + " lost " + v1.getBrand() + " won!");
                }
            }
        }
    }

    public static void raceCars(Vehicle v1, Vehicle v2){
        int speed = rand.nextInt(v1.getSpeed());
        v1.setDistance(v1.getDistance() + speed);
        System.out.println(v1.getBrand() + " traveled at an average speed of " + v1.getSpeed() + " and has moved " + v1.getDistance() + " miles");

        speed = rand.nextInt(v2.getSpeed());
        v2.setDistance(v2.getDistance() + speed);
        System.out.println(v2.getBrand() + " traveled at an average speed of " + v2.getSpeed() + " and has moved " + v2.getDistance() + " miles");
    }

    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
