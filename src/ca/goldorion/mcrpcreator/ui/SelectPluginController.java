package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.input.Import;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectPluginController {
    @FXML
    private ChoiceBox<String> pluginsChoiceBox;
    private ObservableList pluginList;

    private MainApp mainApp;
    private Stage stage;

    @FXML
    private void initialize(){
        File file = new File(System.getProperty("user.dir") + "/plugins/plugins.txt");
        if(file.exists()) {
            pluginList = FXCollections.observableArrayList(FileUtils.loadContentList(file));
            pluginsChoiceBox.setItems(pluginList);
            pluginsChoiceBox.getSelectionModel().selectFirst();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleOpenPlugin(){
        String id = pluginsChoiceBox.getSelectionModel().getSelectedItem();
        File procedures = new File(System.getProperty("user.dir") + "/plugins/" +
                id + "/procedures/");
        mainApp.getBlockData().addAll(listBlocksFromFolder(procedures));
        File aitasks = new File(System.getProperty("user.dir") + "/plugins/" +
                id + "/aitasks/");
        mainApp.getBlockData().addAll(listBlocksFromFolder(aitasks));
        mainApp.showBlockOverview(id);
        stage.close();
    }

    @FXML
    private void handleNewPlugin(){
        showNewPlugin();
        stage.close();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void showNewPlugin() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/NewPlugin.fxml"));
            AnchorPane page = loader.load();

            //Create the Dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create a new plugin");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainApp.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            NewPluginController controller = loader.getController();
            controller.setMainApp(mainApp);
            controller.setStage(dialogStage);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<BlockModel> listBlocksFromFolder(File folder) {
        List<BlockModel> loadList = new ArrayList<>();

        File[] blockFiles = folder.listFiles();
        for (File blockFile : blockFiles != null ? blockFiles : new File[0]) {
            BlockModel block = Import.importFileReturn(mainApp, blockFile);
            if (block != null) {
                loadList.add(block);
            }
        }

        return loadList;
    }
}