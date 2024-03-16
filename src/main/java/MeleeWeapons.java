public class MeleeWeapons extends Weapon{
    public MeleeWeapons(String name, String description, int damage) {
        super(name, description, damage);
    }


    //Note to self: Consider implementing a durability method for melee weapons.
    @Override
    public String remainingUses() {
    return null;
    }

    @Override
    public String attack() {
        return "You attack with " + super.getItemName() + " for " + super.getDamage() + " damage";
    }
}
