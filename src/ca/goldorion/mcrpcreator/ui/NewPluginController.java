package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.export.PluginJsonExport;
import ca.goldorion.mcrpcreator.models.PluginJsonModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;

public class NewPluginController {

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

    private MainApp mainApp;
    private Stage stage;

    @FXML
    private void initialize(){

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleCancelButton(){
        mainApp.showSelectPlugins();
        stage.close();
    }

    @FXML
    private void handleCreateButton(){
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
            File file = new File(System.getProperty("user.dir") + "/plugins/plugins.txt");
            String plugins = FileUtils.loadContent(file);
            plugins = plugins + pluginId.getText();
            FileUtils.saveFile(file, plugins);

            mainApp.showBlockOverview(pluginJsonModel.getId());
            stage.close();
        }

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
}
