package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class ProceduralBlockImport {

    public static void proceduralBlock(MainApp mainApp, BlockModel blockModel, ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock proceduralBlock,
                                       JsonElement jsonElement){
        blockModel.setText(proceduralBlock.getMessage0());
        blockModel.setBlockType("Procedural Block");
        blockModel.setInputsInline(proceduralBlock.isInputsInline());
        blockModel.setExtensions(proceduralBlock.getExtensions());
        blockModel.setNextStatement(proceduralBlock.isNextStatement());
        blockModel.setColour(proceduralBlock.getColour());
        blockModel.setToolbox(proceduralBlock.getMcreator().getToolbox_id());
        blockModel.setFields(proceduralBlock.getMcreator().getFields());
        blockModel.setInputs(proceduralBlock.getMcreator().getInputs());

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

    public static BlockModel proceduralBlockReturn(MainApp mainApp, BlockModel blockModel, ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock proceduralBlock,
                                                   JsonElement jsonElement){
        blockModel.setText(proceduralBlock.getMessage0());
        blockModel.setBlockType("Procedural Block");
        blockModel.setInputsInline(proceduralBlock.isInputsInline());
        blockModel.setExtensions(proceduralBlock.getExtensions());
        blockModel.setNextStatement(proceduralBlock.isNextStatement());
        blockModel.setColour(proceduralBlock.getColour());
        blockModel.setToolbox(proceduralBlock.getMcreator().getToolbox_id());
        blockModel.setFields(proceduralBlock.getMcreator().getFields());
        blockModel.setInputs(proceduralBlock.getMcreator().getInputs());

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
