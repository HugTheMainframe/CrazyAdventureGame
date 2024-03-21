public abstract class Weapon extends Items {

    protected int numDice; //Number of dice for damage
    protected int diceType; // Type of dice (for example 4, 6, 12 etc.)

    public Weapon(String name, String description, int numDice, int diceType) {
        super(name, description);
        this.numDice = numDice;
        this.diceType = diceType;
    }

    public abstract int remainingUses();

    public abstract void useWeapon();

    public abstract String weaponStatus();

    public abstract int getDamage();



}
