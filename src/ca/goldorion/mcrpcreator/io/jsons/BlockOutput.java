package ca.goldorion.mcrpcreator.io.jsons;

import java.util.ArrayList;

public class BlockOutput {
    private String message0;
    private ArrayList args0;
    private String output;
    private int colour;
    private ArrayList extensions;
    private MCreator mcreator;

    public String getMessage0() {
        return message0;
    }

    public ArrayList getArgs() { return args0; }

    public ArrayList getExtensions() {
        return extensions;
    }

    public String getOutput() {
        return output;
    }

    public int getColour() {
        return colour;
    }

    public MCreator getMcreator() {
        return mcreator;
    }


    public BlockOutput(String message0, ArrayList args, ArrayList extensions, String output, int colour, MCreator mcreator) {
        this.message0 = message0;
        this.args0 = args;
        this.extensions = extensions;
        this.output = output;
        this.colour = colour;
        this.mcreator = mcreator;
    }
}
