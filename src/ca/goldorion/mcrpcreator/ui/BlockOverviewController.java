package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.export.Export;
import ca.goldorion.mcrpcreator.io.export.PluginJsonExport;
import ca.goldorion.mcrpcreator.io.jsons.PluginJson;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.models.PluginJsonModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BlockOverviewController {

    @FXML
    private TableView<BlockModel> blockTable;
    @FXML
    private TableColumn<BlockModel, String> fileNameColumn;

    @FXML
    private TextField pluginId;
    @FXML
    private TextField pluginMin;
    @FXML
    private TextField pluginName;
    @FXML
    private TextField pluginDesc;
    @FXML
    private TextField pluginVersion;
    @FXML
    private TextField pluginAuthor;

    private MainApp mainApp;



    public BlockOverviewController(){
    }

    @FXML
    private void initialize(){
        loadPluginJson();

        // Initialize the block table
        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().fileNameProperty());
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        blockTable.setItems(mainApp.getBlockData());
    }

    @FXML
    private void handleSavePluginInfoButton(){
        PluginJsonModel pluginJsonModel = new PluginJsonModel();
        if(isInputValid()) {
            pluginJsonModel.setId(pluginId.getText());
            if(!pluginMin.getText().isEmpty()) {
                pluginJsonModel.setMinversion(Long.parseLong(pluginMin.getText()));
            }

            pluginJsonModel.setName(pluginName.getText());
            if(!pluginDesc.getText().isEmpty()){
                pluginJsonModel.setDescription(pluginDesc.getText());
            }
            if(!pluginVersion.getText().isEmpty()){
                pluginJsonModel.setVersion(pluginVersion.getText());
            }
            if(!pluginAuthor.getText().isEmpty()){
                pluginJsonModel.setAuthor(pluginAuthor.getText());
            }

            PluginJsonExport.pluginJson(pluginJsonModel);
        }
    }

    @FXML
    private void handleDeleteBlock(){
        int selectedIndex = blockTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            blockTable.getItems().remove(selectedIndex);
        } else {
            AlertUtils.warning(mainApp, "No selection", "No Block Selected", "Please select a block in the table!");
        }
    }

    @FXML
    private void handleNewBlock(){
        BlockModel blockModel = new BlockModel("");
        mainApp.getBlockData().add(blockModel);
        mainApp.showBlockEditDialog(blockModel);
    }

    @FXML
    private void handleEditBlock(){
        BlockModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
        if(selectedBlock != null){
            mainApp.showBlockEditDialog(selectedBlock);

        } else {
            AlertUtils.error(mainApp, "No Block Selected", "Please select a block in the table");

        }
    }

    /**
     * Called when the user clicks the export button. Save the block
     * in a JSON file at the user directory the parameters.
     */
    @FXML
    private void handleExportBlock(){
        BlockModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
            Export.export(mainApp, selectedBlock);
    }

    private boolean isInputValid() {
        String message = "";
        if(pluginId.getText() == null || pluginId.getText().length() == 0){
            message += "The ID is not valid!\n";
        }
        if(pluginName.getText() == null || pluginName.getText().length() == 0){
            message += "The name is not valid!\n";
        }

        if(message.length() == 0){
            return true;
        } else{
            AlertUtils.error("Please correct invalid field(s)", message);
            return false;
        }
    }

    private void loadPluginJson(){
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir") + "/export/plugin.json");
        try {
            PluginJson pluginJson = gson.fromJson(new BufferedReader(new FileReader(file)), PluginJson.class);
            PluginJsonModel pluginJsonModel = new PluginJsonModel();
            if(file != null){
                pluginId.setText(pluginJson.getId());
                pluginMin.setText(String.valueOf(pluginJson.getMinversion()));
                pluginName.setText(pluginJson.getInfos().getName());
                pluginDesc.setText(pluginJson.getInfos().getDescription());
                pluginVersion.setText(pluginJson.getInfos().getVersion());
                pluginAuthor.setText(pluginJson.getInfos().getAuthor());
            }
        } catch (FileNotFoundException e) {
        }
    }
}
