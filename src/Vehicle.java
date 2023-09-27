public class Vehicle {
    private String brand;
    private int speed;
    private int distance;


    public Vehicle() {
        this.brand = "";
        this.speed = 1;
        this.distance = 0;
    }

    public Vehicle(String brand, int speed, int distance){
        setBrand(brand);
        setSpeed(speed);
        setDistance(distance);
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void updateDistance(int speed){
        distance = distance + speed;
    }

    public boolean Won() {
        if (getDistance() >= 500){
            return true;
        }
        return false;
    }


}
