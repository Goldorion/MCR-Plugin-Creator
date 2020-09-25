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
    @FXML
    private TextField pluginCredits;
    @FXML
    private TextField pluginDependencies;

    private static String plugin;

    private MainApp mainApp;


    public BlockOverviewController(){
    }

    @FXML
    private void initialize(){

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
            if(!pluginCredits.getText().isEmpty()){
                pluginJsonModel.setCredits(pluginCredits.getText());
            }
            if(!pluginDependencies.getText().isEmpty()){
                String str = pluginDependencies.getText();
                pluginJsonModel.setDependencies(str);
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

    public void loadPluginJson(){
        Gson gson = new Gson();
        File file = new File(System.getProperty("user.dir") + "/plugins/" + plugin + "/plugin.json");
        System.out.println(file.getPath());
        try {
            PluginJson pluginJson = gson.fromJson(new BufferedReader(new FileReader(file)), PluginJson.class);
            PluginJsonModel pluginJsonModel = new PluginJsonModel();
            pluginJsonModel.setId(pluginJson.getId());
            pluginId.setText(pluginJsonModel.getId());
            if (pluginJson.getMinversion() != 0) {
                pluginJsonModel.setMinversion(pluginJson.getMinversion());
            }
            pluginMin.setText(String.valueOf(pluginJsonModel.getMinversion()));
            if (pluginJson.getInfo().getName() != null) {
                pluginJsonModel.setName(pluginJson.getInfo().getName());
                pluginName.setText(pluginJsonModel.getName());
            }
            if (pluginJson.getInfo().getDescription() != null) {
                pluginJsonModel.setDescription(pluginJson.getInfo().getDescription());
                pluginDesc.setText(pluginJsonModel.getDescription());
            }
            if (pluginJson.getInfo().getVersion() != null) {
                pluginJsonModel.setVersion(pluginJson.getInfo().getVersion());
                pluginVersion.setText(pluginJsonModel.getVersion());
            }
            if (pluginJson.getInfo().getAuthor() != null) {
                pluginJsonModel.setAuthor(pluginJson.getInfo().getAuthor());
                pluginAuthor.setText(pluginJsonModel.getAuthor());
            }
            if(pluginJson.getInfo().getCredits() != null){
                pluginJsonModel.setCredits(pluginJson.getInfo().getCredits());
                pluginCredits.setText(pluginJson.getInfo().getCredits());
            }
            if(pluginJson.getInfo().getDependencies() != null){
                pluginJsonModel.setDependencies(String.valueOf(pluginJson.getInfo().getDependencies()));
                pluginDependencies.setText(String.valueOf(pluginJson.getInfo().getDependencies())
                        .replace("[","").replace("]", ""));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        BlockOverviewController.plugin = plugin;
    }

    public TableView<BlockModel> getBlockTable() {
        return blockTable;
    }

    public TableColumn<BlockModel, String> getFileNameColumn() {
        return fileNameColumn;
    }
}
