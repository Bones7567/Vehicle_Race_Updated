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
        Vehicle MarioKart = new Kart("Mario Kart", 105, 2);
        System.out.println(MarioKart.getBrand() + ", " + MarioKart.getSpeed() + ", " + MarioKart.getDistance());
        System.out.println(car2.getBrand() + ", " + car2.getSpeed() + ", " + car2.getDistance());
        System.out.println(MarioKart.getBrand() + " vs. " + car2.getBrand() + "!");
        System.out.println(ConsoleColors.GREEN + "LET THE RACE BEGIN!");
        results(MarioKart, car2);

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

    public static void raceCars(Vehicle car1, Vehicle car2) {
        // Simulate a race step
        int speed1 = car1.getSpeed();
        int speed2 = car2.getSpeed();

        // Randomly vary the speeds slightly
        speed1 += rand.nextInt(21) - 10;
        speed2 += rand.nextInt(21) - 10;

        // Ensure speeds are positive
        speed1 = Math.max(speed1, 0);
        speed2 = Math.max(speed2, 0);

        car1.setSpeed(speed1);
        car2.setSpeed(speed2);

        int newspeed1 = checkForKart(car1,car2);
        if (!(newspeed1 == -1)){
            car2.setSpeed(newspeed1);
            speed2 = newspeed1;
        }
        int newspeed2 = checkForKart(car2,car1);
        if (!(newspeed2 == -1)){
            car1.setSpeed(newspeed2);
            speed1 = newspeed2;
        }

        // Update distances based on speeds
        car1.updateDistance(speed1);
        car2.updateDistance(speed2);

        System.out.println(car1.getBrand() + " advanced at an average speed of " + speed1 + "mph and has traveled " + car1.getDistance() + " miles");
        System.out.println(car2.getBrand() + " advanced at an average speed of " + speed2 + "mph and has traveled " + car2.getDistance() + " miles");
    }

    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


    public static int checkForKart(Vehicle attacker, Vehicle victim) {
        if(attacker instanceof Kart) {
            Kart k = (Kart) attacker;
            SpecialItem attack = k.detailedAttack();
            //kept the speed from going under zero
            int new_speed = Math.max(0, victim.getSpeed() - attack.getDelay());
            System.out.printf("%sThe %s slowed the %s by %d with a %s reducing the speed of %dmph to %dmph\n" + ConsoleColors.RESET,
                    attack.getTextColor(), attacker.getBrand(), victim.getBrand(), attack.getDelay(), attack.getItemType(), victim.getSpeed(), new_speed);
            return new_speed;
        }
        return -1;
    }
}
