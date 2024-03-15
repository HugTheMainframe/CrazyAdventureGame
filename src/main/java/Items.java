import java.util.ArrayList;

public class Items {

    protected String name;
    protected String description;
    protected boolean unLockSomething;


    public Items(String name, String description) {
        this.name = name;
        this.description = description;

    }
    public Items(String name, String description, boolean unLockSomething){
        this.name = name;
        this.description = description;
        this.unLockSomething = unLockSomething;
    }

    public String getDescription() {
        return description;
    }
    public boolean getUnlockSomething(){
        return unLockSomething;
    }

    public void setUnLockSomething(boolean unLockSomething) {
        this.unLockSomething = unLockSomething;
    }

    public String getItemName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String result = "";
        result += "\n" + name + " " + description;
        return result;
    }
}
