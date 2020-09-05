package ca.goldorion.mcrpcreator.io.jsons;

import java.util.ArrayList;

public class ProceduralBlock {
    private String message0;
    private ArrayList args0;
    private boolean inputsInline;
    private boolean nextStatement;
    private boolean previousStatement;
    private int colour;
    private ArrayList extensions;
    private MCreator mcreator;


    public ProceduralBlock(String message0, ArrayList args0, boolean inputsInline,
                           boolean nextStatement, boolean previousStatement, int colour,
                           ArrayList extensions, MCreator mcreator) {
        this.message0 = message0;
        this.args0 = args0;
        this.inputsInline = inputsInline;
        this.nextStatement = nextStatement;
        this.previousStatement = previousStatement;
        this.colour = colour;
        this.extensions = extensions;
        this.mcreator = mcreator;
    }

    public String getMessage0() {
        return message0;
    }

    public void setMessage0(String message0) {
        this.message0 = message0;
    }

    public ArrayList getArgs0() {
        return args0;
    }

    public void setArgs0(ArrayList args0) {
        this.args0 = args0;
    }

    public boolean isInputsInline() {
        return inputsInline;
    }

    public void setInputsInline(boolean inputsInline) {
        this.inputsInline = inputsInline;
    }

    public boolean isNextStatement() {
        return nextStatement;
    }

    public void setNextStatement(boolean nextStatement) {
        this.nextStatement = nextStatement;
    }

    public boolean isPreviousStatement() {
        return previousStatement;
    }

    public void setPreviousStatement(boolean previousStatement) {
        this.previousStatement = previousStatement;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public ArrayList getExtensions() {
        return extensions;
    }

    public void setExtensions(ArrayList extensions) {
        this.extensions = extensions;
    }

    public MCreator getMcreator() {
        return mcreator;
    }

    public void setMcreator(MCreator mcreator) {
        this.mcreator = mcreator;
    }
}
