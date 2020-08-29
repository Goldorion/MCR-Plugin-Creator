package ca.goldorion.mcrpcreator.models;

public class ArgumentGeneral {

    private String type;
    private String name;
    private String check;
    private boolean checked;

    public ArgumentGeneral(String type, String name, String check, boolean checked) {
        this.type = type;
        this.name = name;
        this.check = check;
        this.checked = checked;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
