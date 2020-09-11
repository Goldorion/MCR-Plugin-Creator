package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.*;

import java.util.ArrayList;

public class BlockModel {

    private StringProperty fileName;
    private StringProperty blockType;
    private StringProperty blockElement;
    private StringProperty text;
    private BooleanProperty inputsInline;
    private BooleanProperty nextStatement;
    private ArrayList<String> extensions;
    private StringProperty type;
    private StringProperty toolbox;
    private IntegerProperty colour;
    private ArrayList<String> fields;
    private ArrayList<String> inputs;

    //Arguments
    private ArrayList<String> argType;
    private ArrayList<String> argName;
    private ArrayList<String> argSpecial;
    private ArrayList<String> argsListCode;

    //Dependencies
    private BooleanProperty bool;
    private BooleanProperty direction;
    private BooleanProperty entity;
    private BooleanProperty integer;
    private BooleanProperty itemstack;
    private BooleanProperty map;
    private BooleanProperty string;
    private BooleanProperty world;

    public BlockModel(String fileName) {
        this.fileName = new SimpleStringProperty(fileName);
        this.blockType = new SimpleStringProperty("");
        this.blockElement = new SimpleStringProperty("");
        this.text = new SimpleStringProperty("");
        this.argType = new ArrayList<>();
        this.argName = new ArrayList<>();
        this.argSpecial = new ArrayList<>();
        this.argsListCode = new ArrayList<>();
        this.inputsInline = new SimpleBooleanProperty(true);
        this.nextStatement = new SimpleBooleanProperty(true);
        this.extensions = new ArrayList();
        this.type = new SimpleStringProperty("");
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

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public String getBlockType() {
        return blockType.get();
    }

    public void setBlockType(String blockType) {
        this.blockType.set(blockType);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
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

    public int getColour() {
        return colour.get();
    }

    public void setColour(int colour) {
        this.colour.set(colour);
    }
    public boolean isBool() {
        return bool.get();
    }

    public void setBool(boolean bool) {
        this.bool.set(bool);
    }

    public boolean isDirection() {
        return direction.get();
    }

    public void setDirection(boolean direction) {
        this.direction.set(direction);
    }

    public boolean isEntity() {
        return entity.get();
    }

    public void setEntity(boolean entity) {
        this.entity.set(entity);
    }

    public boolean isInteger() {
        return integer.get();
    }

    public void setInteger(boolean integer) {
        this.integer.set(integer);
    }

    public boolean isItemstack() {
        return itemstack.get();
    }

    public void setItemstack(boolean itemstack) {
        this.itemstack.set(itemstack);
    }

    public boolean isMap() {
        return map.get();
    }

    public void setMap(boolean map) {
        this.map.set(map);
    }

    public boolean isString() {
        return string.get();
    }

    public void setString(boolean string) {
        this.string.set(string);
    }

    public boolean isWorld() {
        return world.get();
    }

    public void setWorld(boolean world) {
        this.world.set(world);
    }

    public ArrayList getExtensions() {
        return extensions;
    }

    public ArrayList setExtensions(ArrayList extensions) {
        this.extensions = extensions;
        return extensions;
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

    public boolean isInputsInline() {
        return inputsInline.get();
    }

    public void setInputsInline(boolean inputsInline) {
        this.inputsInline.set(inputsInline);
    }

    public boolean isNextStatement() {
        return nextStatement.get();
    }

    public BooleanProperty nextStatementProperty() {
        return nextStatement;
    }

    public void setNextStatement(boolean nextStatement) {
        this.nextStatement.set(nextStatement);
    }

    public String getBlockElement() {
        return blockElement.get();
    }

    public void setBlockElement(String blockElement) {
        this.blockElement.set(blockElement);
    }

    public ArrayList<String> getArgsListCode() {
        return argsListCode;
    }

    public void setArgsListCode(ArrayList<String> argsListCode) {
        this.argsListCode = argsListCode;
    }
}
