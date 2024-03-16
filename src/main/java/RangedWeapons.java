public class RangedWeapons extends Weapon {

    private int ammunition;

    public RangedWeapons(String name, String description, int damage, int ammunition) {
        super(name, description, damage);
        this.ammunition = ammunition;
    }

    @Override
    public String remainingUses() {
    return "Remaining uses for " + super.getItemName() + ": " + ammunition;
    }

    public void consumeAmmunition() {
        if (ammunition > 0) {
            ammunition--;
        }
    }
}
