public class RangedWeapons extends Weapon {

    private int ammunition;

    public RangedWeapons(String name, String description, int damage, int ammunition) {
        super(name, description, damage);
        this.ammunition = ammunition;
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


}
