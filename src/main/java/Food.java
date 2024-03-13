public class Food extends Items {


    private int healthPoints;

    public Food (String name, String description, int healthPoints) {
        super(name, description);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }


}
