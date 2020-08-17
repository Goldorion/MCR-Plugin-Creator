package ca.goldorion.mcrpcreator.io.input;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import com.google.gson.Gson;

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
            if(blockOutput.getOutput() != null){
                ca.goldorion.mcrpcreator.io.input.BlockOutput.blockOutput(mainApp, blockModel, blockOutput);
            } else{
                AlertUtils.error("Block Not supported", "The block you tried to import is not supported. Please import a supported block only.");
            }
        } catch (FileNotFoundException e) {
            AlertUtils.error("File Not Found", "Please select a file");
            e.printStackTrace();
        }


    }



}
