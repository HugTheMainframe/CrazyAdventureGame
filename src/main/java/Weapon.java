public abstract class Weapon extends Items {

    protected int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract int remainingUses();

    public abstract void useWeapon();

    public abstract String weaponStatus();

    public int getDamage() {
        return damage;
    }

}
