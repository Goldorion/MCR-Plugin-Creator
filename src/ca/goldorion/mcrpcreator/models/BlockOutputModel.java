package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.*;

public class BlockOutputModel {

    private StringProperty fileName;
    private StringProperty text;
    private StringProperty type;
    private StringProperty toolbox;
    private IntegerProperty colour;
    private BooleanProperty bool;
    private BooleanProperty direction;
    private BooleanProperty entity;
    private BooleanProperty integer;
    private BooleanProperty itemstack;
    private BooleanProperty map;
    private BooleanProperty string;
    private BooleanProperty world;
    private final String blockType;

    public BlockOutputModel(String fileName) {
        this.fileName = new SimpleStringProperty(fileName);
        this.blockType = "Output";

        this.text = new SimpleStringProperty("");
        this.type = new SimpleStringProperty("");
        this.toolbox = new SimpleStringProperty("");
        this.colour = new SimpleIntegerProperty();
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

    public boolean isBool() {
        return bool.get();
    }

    public BooleanProperty getBoolProperty() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool.set(bool);
    }

    public boolean isDirection() {
        return direction.get();
    }

    public BooleanProperty getDirectionProperty() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction.set(direction);
    }

    public boolean isEntity() {
        return entity.get();
    }

    public BooleanProperty getEntityProperty() {
        return entity;
    }

    public void setEntity(boolean entity) {
        this.entity.set(entity);
    }

    public boolean isInteger() {
        return integer.get();
    }

    public BooleanProperty getIntegerProperty() {
        return integer;
    }

    public void setInteger(boolean integer) {
        this.integer.set(integer);
    }

    public boolean isItemstack() {
        return itemstack.get();
    }

    public BooleanProperty getItemstackProperty() {
        return itemstack;
    }

    public void setItemstack(boolean itemstack) {
        this.itemstack.set(itemstack);
    }

    public boolean isMap() {
        return map.get();
    }

    public BooleanProperty getMapProperty() {
        return map;
    }

    public void setMap(boolean map) {
        this.map.set(map);
    }

    public boolean isString() {
        return string.get();
    }

    public BooleanProperty getStringProperty() {
        return string;
    }

    public void setString(boolean string) {
        this.string.set(string);
    }

    public boolean isWorld() {
        return world.get();
    }

    public BooleanProperty getWorldProperty() {
        return world;
    }

    public void setWorld(boolean world) {
        this.world.set(world);
    }

    public String getBlockType() {
        return blockType;
    }
}
