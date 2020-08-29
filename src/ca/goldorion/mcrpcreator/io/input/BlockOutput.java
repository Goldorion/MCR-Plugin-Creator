package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;

public class BlockOutput {

    public static void blockOutput(MainApp mainApp, BlockOutputModel blockModel, ca.goldorion.mcrpcreator.io.jsons.BlockOutput blockOutput){
        blockModel.setText(blockOutput.getMessage0());
        blockModel.setExtensions(blockOutput.getExtensions());
        blockModel.setType(blockOutput.getOutput());
        blockModel.setColour(blockOutput.getColour());
        blockModel.setToolbox(blockOutput.getMcreator().getToolbox_id());
        blockModel.setFields(blockOutput.getMcreator().getFields());
        blockModel.setInputs(blockOutput.getMcreator().getInputs());
        blockModel.setBool(blockOutput.getMcreator().getDependencies().contains("boolean"));
        blockModel.setDirection(blockOutput.getMcreator().getDependencies().contains("direction"));
        blockModel.setEntity(blockOutput.getMcreator().getDependencies().contains("entity"));
        blockModel.setInteger(blockOutput.getMcreator().getDependencies().contains("int"));
        blockModel.setItemstack(blockOutput.getMcreator().getDependencies().contains("itemstack"));
        blockModel.setMap(blockOutput.getMcreator().getDependencies().contains("map"));
        blockModel.setString(blockOutput.getMcreator().getDependencies().contains("string"));
        blockModel.setWorld(blockOutput.getMcreator().getDependencies().contains("world"));
        mainApp.getBlockData().add(blockModel);

    }
}