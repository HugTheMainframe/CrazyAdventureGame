public abstract class Weapon extends Items {

    protected int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }


    public abstract void canUse();

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
