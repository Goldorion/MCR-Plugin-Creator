package ca.goldorion.mcrpcreator.io.jsons;

import java.util.ArrayList;

public class MCreator {
    private String toolbox_id;
    private ArrayList<String> fields;
    private ArrayList<Dependencies> dependencies;

    public String getToolbox_id() {
        return toolbox_id;
    }

    public void setToolbox_id(String toolbox_id) {
        this.toolbox_id = toolbox_id;
    }

    public ArrayList<Dependencies> getDependencies() {
        return dependencies;
    }

    public void setDependencies(ArrayList<Dependencies> dependencies) {
        this.dependencies = dependencies;
    }

    public MCreator(String toolbox_id,ArrayList<String> fields, ArrayList<Dependencies> dependencies) {
        this.toolbox_id = toolbox_id;
        this.dependencies = dependencies;
        this.fields = fields;
    }

    public void setFields(ArrayList fields) {
        this.fields = fields;
    }

    public ArrayList<String> getFields() {
        return fields;
    }
}
