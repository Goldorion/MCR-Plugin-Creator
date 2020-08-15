package ca.goldorion.mcrpcreator.io.jsons;

public class MCreator {
    private String toolbox_id;
    private Dependencies[] dependencies;

    public String getToolbox_id() {
        return toolbox_id;
    }

    public void setToolbox_id(String toolbox_id) {
        this.toolbox_id = toolbox_id;
    }

    public Dependencies[] getDependencies() {
        return dependencies;
    }

    public void setDependencies(Dependencies[] dependencies) {
        this.dependencies = dependencies;
    }

    public MCreator(String toolbox_id, Dependencies[] dependencies) {
        this.toolbox_id = toolbox_id;
        this.dependencies = dependencies;
    }
}
