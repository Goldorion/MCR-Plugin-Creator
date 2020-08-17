package ca.goldorion.mcrpcreator.io;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.io.jsons.Dependencies;
import ca.goldorion.mcrpcreator.io.jsons.MCreator;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Export {

    public static void OutputProcedureBlock(MainApp mainApp, TableView<BlockOutputModel> blockTable, BlockOutputModel selectedBlock){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "JSON files", "*.json");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if(file != null) {
            if(!file.getPath().endsWith(".json")) {
                file = new File(file.getPath() + ".json");
            }

            //Dependencies object

            //ArrayList to store all dependencies used in the JSON
            ArrayList dependencies = new ArrayList();
            if(selectedBlock.isBool() == true){
                Dependencies depenBool = new Dependencies("boolean", "boolean");
                dependencies.add(depenBool);
            }
            if(selectedBlock.isDirection() == true){
                Dependencies depenDirec = new Dependencies("direction", "direction");
                dependencies.add(depenDirec);
            }
            if(selectedBlock.isEntity() == true){
                Dependencies depenEntity = new Dependencies("entity", "entity");
                dependencies.add(depenEntity);
            }
            if(selectedBlock.isInteger() == true){
                Dependencies depenX = new Dependencies("int", "x");
                dependencies.add(depenX);
                Dependencies depenY = new Dependencies("int", "y");
                dependencies.add(depenY);
                Dependencies depenZ = new Dependencies("int", "z");
                dependencies.add(depenZ);
            }
            if(selectedBlock.isItemstack() == true){
                Dependencies depenItemstack = new Dependencies("itemstack", "itemstack");
                dependencies.add(depenItemstack);;
            }
            if(selectedBlock.isMap() == true){
                Dependencies depenMap = new Dependencies("map", "cmdparams");
                dependencies.add(depenMap);
            }
            if(selectedBlock.isString() == true){
                Dependencies depenString = new Dependencies("string", "string");
                dependencies.add(depenString);
            }
            if(selectedBlock.isWorld() == true){
                Dependencies depenWorld = new Dependencies("world", "world");
                dependencies.add(depenWorld);
            }

            //MCreator object with the dependencies object
            MCreator mcreator = new MCreator(selectedBlock.getToolbox(),new ArrayList<Dependencies>(dependencies));

            //BlockOutput object with the mcreator object
            BlockOutput blockOutput = new BlockOutput(selectedBlock.getText(), selectedBlock.getExtensions(), selectedBlock.getType(), selectedBlock.getColour(), mcreator);

            //Create a Gson Builder and add the JSON in a String to create a file with the String
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            String json = gson.toJson(blockOutput);
            FileUtils.saveFile(file, json);
            System.out.println(json);

        }
    }
}
