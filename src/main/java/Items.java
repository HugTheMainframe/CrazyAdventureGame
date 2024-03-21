import java.util.ArrayList;

public class Items {

    protected String name;
    protected String description;
    protected boolean unlocksSomething;


    public Items(String name, String description) {
        this.name = name;
        this.description = description;
        this.unlocksSomething = unlocksSomething;

    }

    public String getDescription() {
        return description;
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
        result += "\n" + name + ": " + description;
        return result;
    }
}
