package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import static ca.goldorion.mcrpcreator.MainApp.*;
import ca.goldorion.mcrpcreator.io.jsons.Import;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.preferences.Preferences;
import ca.goldorion.mcrpcreator.utils.AlertUtils;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import java.io.File;

public class RootLayoutController {

    @FXML
    private TableView<BlockOutputModel> blockTable;
    @FXML
    private TableColumn<BlockOutputModel, String> fileNameColumn;

    private MainApp mainApp;
    private Preferences preferences;

    @FXML
    private void handleOpen(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON Files (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if(file != null) {
            Import.importFile(mainApp, file);
        }
    }

    @FXML
    private void handleAbout(){
        AlertUtils.info("About", "About", "MCR Plugin Creator is an unofficial software to help users to create their own plugins.\n\n" +
                "The current version of the software is: " + version);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
