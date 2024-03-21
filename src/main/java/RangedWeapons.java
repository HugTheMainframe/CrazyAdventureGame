import java.util.Random;
public class RangedWeapons extends Weapon {

    private int ammunition;
    private Random random;

    public RangedWeapons(String name, String description, int numDice, int diceType, int ammunition) {
        super(name, description, numDice, diceType);
        this.ammunition = ammunition;
        this.random = new Random();
    }

    @Override
    public int remainingUses() {
    return ammunition;
    }

    @Override
    public void useWeapon() {
        if (ammunition > 0){
            ammunition--;
        }
    }

    @Override
    public String weaponStatus() {
        return super.getItemName() + " is empty";
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
