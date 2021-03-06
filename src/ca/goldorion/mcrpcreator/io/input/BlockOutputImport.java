package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.models.BlockModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.File;

public class BlockOutputImport {

    public static void blockOutput(MainApp mainApp, BlockModel blockModel, ca.goldorion.mcrpcreator.io.jsons.BlockOutput blockOutput,
                                   JsonElement jsonElement, java.io.File file){
        blockModel.setText(blockOutput.getMessage0());
        blockModel.setBlockType("Output Block");
        if(file.getPath().contains("aitasks")){
            blockModel.setBlockElement("aitasks");
        }else if(file.getAbsolutePath().contains("procedures")){
            blockModel.setBlockElement("procedures");
        }
        blockModel.setInputsInline(blockOutput.isInputsInline());
        blockModel.setExtensions(blockOutput.getExtensions());
        blockModel.setType(blockOutput.getOutput());
        blockModel.setColour(blockOutput.getColour());
        blockModel.setToolbox(blockOutput.getMcreator().getToolbox_id());
        blockModel.setFields(blockOutput.getMcreator().getFields());
        blockModel.setInputs(blockOutput.getMcreator().getInputs());

        //Dependencies
        if (jsonElement.getAsJsonObject().get("mcreator").getAsJsonObject().get("dependencies") != null) {
            JsonArray dependencies = jsonElement.getAsJsonObject().get("mcreator").getAsJsonObject()
                    .get("dependencies").getAsJsonArray();
            for (JsonElement spawn : dependencies) {
                String type = spawn.getAsJsonObject().get("type").getAsString();
                switch (type) {
                    case "advancement":
                        blockModel.setAdvancement(true);
                    case "boolean":
                        blockModel.setBool(true);
                        break;
                    case "direction":
                        blockModel.setDirection(true);
                        break;
                    case "entity":
                        blockModel.setEntity(true);
                        break;
                    case "int":
                        blockModel.setInteger(true);
                        break;
                    case "itemstack":
                        blockModel.setItemstack(true);
                        break;
                    case "map":
                        blockModel.setMap(true);
                        break;
                    case "string":
                        blockModel.setString(true);
                        break;
                    case "world":
                        blockModel.setWorld(true);
                        break;
                }
            }
        }

            mainApp.getBlockData().add(blockModel);

    }

    public static BlockModel blockOutputReturn(MainApp mainApp, BlockModel blockModel, BlockOutput blockOutput,
                                               JsonElement jsonElement, File file){
        blockModel.setText(blockOutput.getMessage0());
        blockModel.setBlockType("Output Block");
        if(file.getPath().contains("aitasks")){
            blockModel.setBlockElement("aitasks");
        }else if(file.getAbsolutePath().contains("procedures")){
            blockModel.setBlockElement("procedures");
        }
        blockModel.setInputsInline(blockOutput.isInputsInline());
        blockModel.setExtensions(blockOutput.getExtensions());
        blockModel.setType(blockOutput.getOutput());
        blockModel.setColour(blockOutput.getColour());
        blockModel.setToolbox(blockOutput.getMcreator().getToolbox_id());
        blockModel.setFields(blockOutput.getMcreator().getFields());
        blockModel.setInputs(blockOutput.getMcreator().getInputs());

        //Dependencies
        if (jsonElement.getAsJsonObject().get("mcreator").getAsJsonObject().get("dependencies") != null) {
            JsonArray dependencies = jsonElement.getAsJsonObject().get("mcreator").getAsJsonObject()
                    .get("dependencies").getAsJsonArray();
            for (JsonElement spawn : dependencies) {
                String type = spawn.getAsJsonObject().get("type").getAsString();
                switch (type) {
                    case "advancement":
                        blockModel.setAdvancement(true);
                    case "boolean":
                        blockModel.setBool(true);
                        break;
                    case "direction":
                        blockModel.setDirection(true);
                        break;
                    case "entity":
                        blockModel.setEntity(true);
                        break;
                    case "int":
                        blockModel.setInteger(true);
                        break;
                    case "itemstack":
                        blockModel.setItemstack(true);
                        break;
                    case "map":
                        blockModel.setMap(true);
                        break;
                    case "string":
                        blockModel.setString(true);
                        break;
                    case "world":
                        blockModel.setWorld(true);
                        break;
                }
            }
        }

        return blockModel;

    }
}
