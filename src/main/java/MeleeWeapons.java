public class MeleeWeapons extends Weapon{

    private int durability;
    public MeleeWeapons(String name, String description, int damage, int durability) {
        super(name, description, damage);
        this.durability = durability;
    }


    //Note to self: Consider implementing a durability method for melee weapons (done)
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


}
