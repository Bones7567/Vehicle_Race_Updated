import java.util.Random;

public class Kart extends Vehicle{
    public static Random rand = new Random();
    private SpecialItem[] items = new SpecialItem[3];
    public Kart(String type, int speed, int delay){
        super(type, speed, delay);
        items[0] = new SpecialItem("Green Shell",  7, ConsoleColors.RED);
        items[1] = new SpecialItem("Boomerang",5, ConsoleColors.BLUE);
        items[2] = new SpecialItem("Banana", 1, ConsoleColors.YELLOW);
    }

    public SpecialItem detailedAttack(){
        int random_index = rand.nextInt(items.length-1);
        return items[random_index];
    }
}
