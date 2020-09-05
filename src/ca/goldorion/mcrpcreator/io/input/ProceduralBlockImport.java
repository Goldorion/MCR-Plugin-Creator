package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockModel;

public class ProceduralBlockImport {

    public static void proceduralBlock(MainApp mainApp, BlockModel blockModel, ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock proceduralBlock){
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
        if(proceduralBlock.getMcreator().getDependencies() != null) {
            blockModel.setBool(proceduralBlock.getMcreator().getDependencies().contains("boolean"));
            blockModel.setDirection(proceduralBlock.getMcreator().getDependencies().contains("direction"));
            blockModel.setEntity(proceduralBlock.getMcreator().getDependencies().contains("entity"));
            blockModel.setInteger(proceduralBlock.getMcreator().getDependencies().contains("int"));
            blockModel.setItemstack(proceduralBlock.getMcreator().getDependencies().contains("itemstack"));
            blockModel.setMap(proceduralBlock.getMcreator().getDependencies().contains("map"));
            blockModel.setString(proceduralBlock.getMcreator().getDependencies().contains("string"));
            blockModel.setWorld(proceduralBlock.getMcreator().getDependencies().contains("world"));
        }

        mainApp.getBlockData().add(blockModel);

    }
}
