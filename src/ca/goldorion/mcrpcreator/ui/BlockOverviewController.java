package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.BlockSerializationManager;
import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import ca.goldorion.mcrpcreator.io.jsons.Dependencies;
import ca.goldorion.mcrpcreator.io.jsons.MCreator;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.File;


public class BlockOverviewController {

    @FXML
    private TableView<BlockOutputModel> blockTable;
    @FXML
    private TableColumn<BlockOutputModel, String> fileNameColumn;
    @FXML
    private TableColumn<BlockOutputModel, String> typeColumn;

    @FXML
    private Label fileNameLabel;
    @FXML
    private Label textLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label colourLabel;
    @FXML
    private Label toolboxLabel;
    @FXML
    private Label dependenciesLabel;

    private MainApp mainApp;
    private BlockSerializationManager blockSerializationManager;

    public BlockOverviewController(){
    }

    @FXML
    private void initialize(){
        // Initialize the person table with the two columns.
        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().fileNameProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        // Clear person details.
        showBlockDetails(null);

        // Listen for selection changes and show the person details when changed.
        blockTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBlockDetails(newValue));
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        blockTable.setItems(mainApp.getBlockData());
    }

    private void showBlockDetails(BlockOutputModel block) {
        if(block != null){
            fileNameLabel.setText(block.getFileName());
            textLabel.setText(block.getText());
            typeLabel.setText(block.getBlockType() + " - "+ block.getType());
            colourLabel.setText(Integer.toString(block.getColour()));
            toolboxLabel.setText(block.getToolbox());
            dependenciesLabel.setText(block.getDependencies());
        } else {
            fileNameLabel.setText("None");
            textLabel.setText("None");
            typeLabel.setText("None");
            colourLabel.setText("None");
            toolboxLabel.setText("None");
            dependenciesLabel.setText("None");
        }
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteBlock(){
        int selectedIndex = blockTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            blockTable.getItems().remove(selectedIndex);
        } else {
            AlertWindows.warning(mainApp, "No selection", "No Block Selected", "Please select a block in the table!");
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new block.
     */
    @FXML
    private void handleNewBlock(){
        mainApp.showBlockTypeSelector();
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected block.
     */
    @FXML
    private void handleEditBlock(){
        BlockOutputModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
        if(selectedBlock != null){
            boolean okClicked = mainApp.showBlockOutputEditDialog(selectedBlock);
            if(okClicked){
                showBlockDetails(selectedBlock);
            }

        } else {
            AlertWindows.error(mainApp, "No Block Selected", "Please select a block in the table");

        }
    }

    /**
     * Called when the user clicks the export button. Save the block
     * in a JSON file at the user directory the parameters.
     */
    @FXML
    private void handleExportBlock(){
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
            Dependencies dependencies = null;
                BlockOutputModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
            if(dependenciesLabel.getText() == null || dependenciesLabel.getText().length() == 0) {
                 dependencies = new Dependencies(selectedBlock.getDependencies(), selectedBlock.getDependencies());
            }

                //MCreator object with the dependencies object
                MCreator mcreator = new MCreator(selectedBlock.getToolbox(), new Dependencies[]{dependencies});

                //BlockOutput object with the mcreator object
                BlockOutput blockOutput = new BlockOutput(selectedBlock.getText(), selectedBlock.getType(), selectedBlock.getColour(), mcreator);

                System.out.println(selectedBlock.getDependencies());
                //Create a Gson Builder and add the JSON in a String to create a file with the String
                Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                String json = gson.toJson(blockOutput);
                FileUtils.saveFile(file, json);
                System.out.println(json);

        }
    }
}
