package ca.goldorion.mcrpcreator.io.jsons;

import java.util.ArrayList;

public class BlockOutput {
    private String message0;
    private String output;
    private int colour;
    private ArrayList extensions;
    private MCreator mcreator;

    public String getMessage0() {
        return message0;
    }

    public void setMessage0(String message0) {
        this.message0 = message0;
    }

    public ArrayList getExtensions() {
        return extensions;
    }

    public void setExtensions(ArrayList extensions) {
        this.extensions = extensions;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public MCreator getMcreator() {
        return mcreator;
    }

    public void setMcreator(MCreator mcreator) {
        this.mcreator = mcreator;
    }

    public BlockOutput(String message0,ArrayList extensions, String output, int colour, MCreator mcreator) {
        this.message0 = message0;
        this.extensions = extensions;
        this.output = output;
        this.colour = colour;
        this.mcreator = mcreator;
    }
}
