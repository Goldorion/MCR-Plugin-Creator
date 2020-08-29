package ca.goldorion.mcrpcreator.io.jsons;

public class FieldCheckbox {

    private String type;
    private String name;
    private boolean checked;

    public FieldCheckbox(String type, String name, boolean checked) {
        this.type = type;
        this.name = name;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
