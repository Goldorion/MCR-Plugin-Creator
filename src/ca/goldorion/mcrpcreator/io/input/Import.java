package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Import {

    public static void importFile(MainApp mainApp, File file){
        Gson gson = new Gson();
        JsonElement jsonElement;
        try {
            jsonElement = gson.fromJson(new BufferedReader(new FileReader(file)), JsonElement.class);
            BlockOutput blockOutput = gson.fromJson(new BufferedReader(new FileReader(file)), BlockOutput.class);
            ProceduralBlock proceduralBlock = gson.fromJson(new BufferedReader(new FileReader(file)), ProceduralBlock.class);
            BlockModel blockModel = new BlockModel(file.getName().replace(".json", ""));
            blockModel.setFileName(file.getName().replace(".json", ""));
            if(blockOutput.getOutput() != null){
                BlockOutputImport.blockOutput(mainApp, blockModel, blockOutput, jsonElement, file);
            } else if(proceduralBlock.isPreviousStatement() == true) {
                ProceduralBlockImport.proceduralBlock(mainApp, blockModel, proceduralBlock, jsonElement);
            } else{
                AlertUtils.error("Block Not supported", "The block you tried to import is not supported. Please import a supported block only.");
            }
        } catch (FileNotFoundException e) {
            AlertUtils.error("File Not Found", "Please select a file");
            e.printStackTrace();
        }


    }

    public static BlockModel importFileReturn(MainApp mainApp, File file){
        Gson gson = new Gson();
        JsonElement jsonElement;
        BlockModel blockModel = new BlockModel(file.getName().replace(".json", ""));
        try {
            jsonElement = gson.fromJson(new BufferedReader(new FileReader(file)), JsonElement.class);
            BlockOutput blockOutput = gson.fromJson(new BufferedReader(new FileReader(file)), BlockOutput.class);
            ProceduralBlock proceduralBlock = gson.fromJson(new BufferedReader(new FileReader(file)), ProceduralBlock.class);
            blockModel.setFileName(file.getName().replace(".json", ""));
            if(blockOutput.getOutput() != null){
                blockModel = BlockOutputImport.blockOutputReturn(mainApp, blockModel, blockOutput, jsonElement, file);
            } else if(proceduralBlock.isPreviousStatement() == true) {
                blockModel =  ProceduralBlockImport.proceduralBlockReturn(mainApp, blockModel, proceduralBlock, jsonElement);
            } else{
                AlertUtils.error("Block Not supported", "The block you tried to import is not supported. Please import a supported block only.");
            }
        } catch (FileNotFoundException e) {
            AlertUtils.error("File Not Found", "Please select a file");
            e.printStackTrace();
        }
        return blockModel;
    }



}
