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

    public String attack() {
        if (ammunition > 0) {
            ammunition--;
            return "You attack with " + super.getItemName() + " for " + super.getDamage() + " damage";
        } else {
            return super.getItemName() + " is empty. Equip a new weapon";
        }
    }


}
