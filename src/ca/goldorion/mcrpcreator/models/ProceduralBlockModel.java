package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.*;

import java.util.ArrayList;

public class ProceduralBlockModel {

    private StringProperty fileName;
    private StringProperty text;
    private ArrayList<String> extensions;
    private StringProperty toolbox;
    private IntegerProperty colour;
    private ArrayList<String> fields;
    private ArrayList<String> inputs;

    //Arguments
    private ArrayList<String> argType;
    private ArrayList<String> argName;
    private ArrayList<String> argSpecial;

    //Dependencies
    private BooleanProperty bool;
    private BooleanProperty direction;
    private BooleanProperty entity;
    private BooleanProperty integer;
    private BooleanProperty itemstack;
    private BooleanProperty map;
    private BooleanProperty string;
    private BooleanProperty world;

    private String blockType;

    public ProceduralBlockModel(String fileName) {
        this.fileName = new SimpleStringProperty(fileName);
        this.blockType = "Output";
        this.text = new SimpleStringProperty("");
        this.argType =new ArrayList<>();
        this.argName = new ArrayList<>();
        this.argSpecial = new ArrayList<>();
        this.extensions = new ArrayList();
        this.toolbox = new SimpleStringProperty("");
        this.colour = new SimpleIntegerProperty();
        this.fields = new ArrayList<>();
        this.inputs = new ArrayList<>();
        this.bool = new SimpleBooleanProperty(false);
        this.direction = new SimpleBooleanProperty(false);
        this.entity = new SimpleBooleanProperty(false);
        this.integer = new SimpleBooleanProperty(false);
        this.itemstack = new SimpleBooleanProperty(false);
        this.map = new SimpleBooleanProperty(false);
        this.string = new SimpleBooleanProperty(false);
        this.world = new SimpleBooleanProperty(false);

    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public ArrayList<String> getExtensions() {
        return extensions;
    }

    public void setExtensions(ArrayList<String> extensions) {
        this.extensions = extensions;
    }

    public String getToolbox() {
        return toolbox.get();
    }

    public StringProperty toolboxProperty() {
        return toolbox;
    }

    public void setToolbox(String toolbox) {
        this.toolbox.set(toolbox);
    }

    public int getColour() {
        return colour.get();
    }

    public IntegerProperty colourProperty() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour.set(colour);
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<String> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<String> getArgType() {
        return argType;
    }

    public void setArgType(ArrayList<String> argType) {
        this.argType = argType;
    }

    public ArrayList<String> getArgName() {
        return argName;
    }

    public void setArgName(ArrayList<String> argName) {
        this.argName = argName;
    }

    public ArrayList<String> getArgSpecial() {
        return argSpecial;
    }

    public void setArgSpecial(ArrayList<String> argSpecial) {
        this.argSpecial = argSpecial;
    }

    public boolean isBool() {
        return bool.get();
    }

    public BooleanProperty boolProperty() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool.set(bool);
    }

    public boolean isDirection() {
        return direction.get();
    }

    public BooleanProperty directionProperty() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction.set(direction);
    }

    public boolean isEntity() {
        return entity.get();
    }

    public BooleanProperty entityProperty() {
        return entity;
    }

    public void setEntity(boolean entity) {
        this.entity.set(entity);
    }

    public boolean isInteger() {
        return integer.get();
    }

    public BooleanProperty integerProperty() {
        return integer;
    }

    public void setInteger(boolean integer) {
        this.integer.set(integer);
    }

    public boolean isItemstack() {
        return itemstack.get();
    }

    public BooleanProperty itemstackProperty() {
        return itemstack;
    }

    public void setItemstack(boolean itemstack) {
        this.itemstack.set(itemstack);
    }

    public boolean isMap() {
        return map.get();
    }

    public BooleanProperty mapProperty() {
        return map;
    }

    public void setMap(boolean map) {
        this.map.set(map);
    }

    public boolean isString() {
        return string.get();
    }

    public BooleanProperty stringProperty() {
        return string;
    }

    public void setString(boolean string) {
        this.string.set(string);
    }

    public boolean isWorld() {
        return world.get();
    }

    public BooleanProperty worldProperty() {
        return world;
    }

    public void setWorld(boolean world) {
        this.world.set(world);
    }

    public String getBlockType() {
        return blockType;
    }
}
