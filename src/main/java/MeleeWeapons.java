import java.util.Random;
public class MeleeWeapons extends Weapon{
    private Random random;
    private int durability;
    public MeleeWeapons(String name, String description, int numDice, int diceType, int durability) {
        super(name, description, numDice, diceType);
        this.durability = durability;
        this.random = new Random();
    }

    @Override
    public int remainingUses() {
      return durability;
    }

    @Override
    public void useWeapon() {
        if (durability > 0) {
            durability--;
        }
    }

    @Override
    public String weaponStatus() {
        return super.getItemName() + " is broken";
    }

    @Override
    public int getDamage() {
        int rolledDamage = 0;
        for (int i = 0; i < numDice; i++) {
            int roll = random.nextInt(diceType) + 1; // Simulate rolling a die
            rolledDamage += roll;
        }
        return rolledDamage;
    }


}
