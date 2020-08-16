package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import static ca.goldorion.mcrpcreator.MainApp.*;

import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.io.jsons.Dependencies;
import ca.goldorion.mcrpcreator.io.jsons.MCreator;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.preferences.Preferences;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class RootLayoutController {

    @FXML
    private TableView<BlockOutputModel> blockTable;
    @FXML
    private TableColumn<BlockOutputModel, String> fileNameColumn;

    private MainApp mainApp;
    private Preferences preferences;

    @FXML
    private void handleNew(){
        mainApp.getBlockData().clear();
        preferences.setBlockFilePath(null);
    }

    @FXML
    private void handleOpen(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if(file != null) {
            Gson gson = new Gson();
            try {
                BlockOutput blockOutput = gson.fromJson(new BufferedReader(new FileReader(file)), BlockOutput.class);
                BlockOutputModel blockModel = new BlockOutputModel(file.getName().replace(".json", ""));
                blockModel.setFileName(file.getName().replace(".json", ""));
                blockModel.setText(blockOutput.getMessage0());
                blockModel.setType(blockOutput.getOutput());
                blockModel.setColour(blockOutput.getColour());
                blockModel.setToolbox(blockOutput.getMcreator().getToolbox_id());
                Dependencies dependencies = blockOutput.getMcreator().getDependencies()[0];
                blockModel.setDependencies(dependencies.getType());
                mainApp.getBlockData().add(blockModel);

            } catch (FileNotFoundException e) {
                AlertWindows.error("File Not Found", "Please select a file");
                e.printStackTrace();
            }
        } else {
            AlertWindows.error("File Not Found", "Please select a file");
        }

    }

    @FXML
    private void handleAbout(){
        AlertWindows.info("About", "About", "MCR Plugin Creator is an unofficial software to help users to create their own plugins.\n\n" +
                "The current version of the software is: " + version);
        System.out.println("appelé");
    }

    @FXML
    private void handleSaveAs(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                "JSON files", "*.json");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if(file != null) {
            if(!file.getPath().endsWith(".json")) {
                file = new File(file.getPath() + ".json");
            }
            BlockOutputModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
            //Dependencies object
            Dependencies dependencies = new Dependencies(selectedBlock.getDependencies(), selectedBlock.getDependencies());

            //MCreator object with the dependencies object
            MCreator mcreator = new MCreator(selectedBlock.getToolbox(), new Dependencies[]{dependencies});

            //BlockOutput object with the mcreator object
            BlockOutput blockOutput = new BlockOutput(selectedBlock.getText(), selectedBlock.getType(), selectedBlock.getColour(), mcreator);

            System.out.println(selectedBlock.getDependencies());
            //Create a Gson Builder and add the JSON in a String to create a file with the String
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().create();
            String json = gson.toJson(blockOutput);
            FileUtils.saveFile(file, json);
            System.out.println(json);

        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
