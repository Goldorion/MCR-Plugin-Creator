package ca.goldorion.mcrpcreator.io.jsons;

import java.util.ArrayList;

public class MCreator {
    private String toolbox_id;
    private ArrayList<String> fields;
    private ArrayList<String> inputs;
    private ArrayList<Dependencies> dependencies;

    public MCreator(String toolbox_id, ArrayList<String> fields, ArrayList<String> inputs, ArrayList<Dependencies> dependencies) {
        this.toolbox_id = toolbox_id;
        this.dependencies = dependencies;
        this.fields = fields;
        this.inputs = inputs;
    }

    public String getToolbox_id() {
        return toolbox_id;
    }

    public ArrayList<Dependencies> getDependencies() {
        return dependencies;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }
}
