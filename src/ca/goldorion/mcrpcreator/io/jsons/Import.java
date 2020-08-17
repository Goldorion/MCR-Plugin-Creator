package ca.goldorion.mcrpcreator.io.jsons;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import com.google.gson.Gson;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Import {

    public static void importFile(MainApp mainApp, File file){
        Gson gson = new Gson();
        try {
            BlockOutput blockOutput = gson.fromJson(new BufferedReader(new FileReader(file)), BlockOutput.class);
            BlockOutputModel blockModel = new BlockOutputModel(file.getName().replace(".json", ""));
            blockModel.setFileName(file.getName().replace(".json", ""));
            if(!blockModel.getType().isEmpty()){
                blockOutput(mainApp, blockModel, blockOutput);
            } else{
                AlertUtils.error("Block Not supported", "The block you tried to import is not supported. Please import a supported block only.");
            }
        } catch (FileNotFoundException e) {
            AlertUtils.error("File Not Found", "Please select a file");
            e.printStackTrace();
        }


    }


    private static void blockOutput(MainApp mainApp, BlockOutputModel blockModel, BlockOutput blockOutput){
        blockModel.setText(blockOutput.getMessage0());
        blockModel.setType(blockOutput.getOutput());
        blockModel.setColour(blockOutput.getColour());
        blockModel.setToolbox(blockOutput.getMcreator().getToolbox_id());
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
