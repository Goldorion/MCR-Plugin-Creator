package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BlockOutputModel {

    private final StringProperty fileName;
    private final StringProperty text;
    private final StringProperty type;
    private final StringProperty toolbox;
    private final IntegerProperty colour;
    private final StringProperty dependencies;
    private final String blockType;

    public BlockOutputModel(String fileName) {
        this.fileName = new SimpleStringProperty(fileName);
        this.blockType = "Output";

        this.text = new SimpleStringProperty("");
        this.type = new SimpleStringProperty("");
        this.toolbox = new SimpleStringProperty("");
        this.colour = new SimpleIntegerProperty();
        this.dependencies = new SimpleStringProperty("");
    }

    public String getFileName() {
        return fileName.get();
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public StringProperty textProperty() {
        return text;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getToolbox() {
        return toolbox.get();
    }

    public void setToolbox(String toolbox) {
        this.toolbox.set(toolbox);
    }

    public StringProperty toolboxProperty() {
        return toolbox;
    }

    public int getColour() {
        return colour.get();
    }

    public void setColour(int colour) {
        this.colour.set(colour);
    }

    public IntegerProperty colourProperty() {
        return colour;
    }

    public String getDependencies() {
        return dependencies.get();
    }

    public void setDependencies(String dependencies) {
        this.dependencies.set(dependencies);
    }

    public StringProperty dependenciesProperty() {
        return dependencies;
    }

    public String getBlockType() {
        return blockType;
    }
}
