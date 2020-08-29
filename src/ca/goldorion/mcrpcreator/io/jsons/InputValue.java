package ca.goldorion.mcrpcreator.io.jsons;

public class InputValue {

    private String type;
    private String name;
    private String check;

    public InputValue(String type, String name, String check) {
        this.type = type;
        this.name = name;
        this.check = check;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
