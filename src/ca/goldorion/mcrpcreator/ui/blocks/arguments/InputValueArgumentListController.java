package ca.goldorion.mcrpcreator.ui.blocks.arguments;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.models.InputValueModel;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class InputValueArgumentListController {

    private MainApp mainApp;
    private Stage dialogStage;
    private BlockOutputModel blockOutputModel;

    @FXML
    private TableView<InputValueModel> argTable;
    @FXML
    private TableColumn<BlockOutputModel, String> argNameColumn;

    @FXML
    private void initialize() {
        argNameColumn.setCellValueFactory(cellData -> (ObservableValue) cellData.getValue().getInputs());

        argTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public InputValueArgumentListController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        List<? extends String> inputList = FXCollections.observableArrayList(blockOutputModel.getInputs());
        argTable.setItems((ObservableList) inputList);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setBlockOutputModel(BlockOutputModel blockOutputModel) {
        this.blockOutputModel = blockOutputModel;
    }

    @FXML
    private void handleNewButton(){
        InputValueModel inputValueModel = new InputValueModel(blockOutputModel);
        this.getArgTable().getItems().add(inputValueModel);
        mainApp.showInputValueArgumentEdit(blockOutputModel, inputValueModel);
    }

    @FXML
    private void handleEditButton(){
        InputValueModel selectedItem = argTable.getSelectionModel().getSelectedItem();
        mainApp.showInputValueArgumentEdit(blockOutputModel, selectedItem);
    }

    @FXML
    private void handleCancelButton(){
        dialogStage.close();
    }

    public TableView<InputValueModel> getArgTable() {
        return argTable;
    }
}
