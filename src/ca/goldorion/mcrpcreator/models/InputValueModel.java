package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InputValueModel {

    private StringProperty argName;
    private StringProperty argCheck;

    public InputValueModel(BlockOutputModel blockOutputModel) {
        this.argName = new SimpleStringProperty("");
        this.argCheck = new SimpleStringProperty("");
    }

    public String getArgName() {
        return argName.get();
    }

    public void setArgName(String argName) {
        this.argName.set(argName);
    }

    public String getArgCheck() {
        return argCheck.get();
    }

    public void setArgCheck(String argCheck) {
        this.argCheck.set(argCheck);
    }
}
