package ca.goldorion.mcrpcreator.io.jsons;

public class Arguments {

    private String type;
    private String name;
    private String check;

    public Arguments(String type, String name, String check) {
        this.type = type;
        this.name = name;
        this.check = check;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getCheck() {
        return check;
    }
}
