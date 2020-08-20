package ca.goldorion.mcrpcreator.ui.blocks.arguments;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.models.InputValueModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputValueArgumentEditController {
    private Stage argumentStage;
    private BlockOutputModel blockOutputModel;
    private InputValueModel inputValueModel;
    private MainApp mainApp;

    @FXML
    private TextField nameField;
    @FXML
    ChoiceBox<String> checkChoiceBox;
    ObservableList<String> availableTypes = FXCollections.observableArrayList("All", "Direction", "Logic", "MCItem", "MCItemBlock", "Number", "String");

    @FXML
    private void initialize(){
        checkChoiceBox.setItems(availableTypes);
        checkChoiceBox.getSelectionModel().selectFirst();
    }

    public InputValueArgumentEditController(){
    }

    @FXML
    private void handleConfirm(){
        String selectedChoice = checkChoiceBox.getSelectionModel().getSelectedItem();
        inputValueModel.setArgName(nameField.getText());
        inputValueModel.setArgCheck(selectedChoice);
        blockOutputModel.getInputs().add(nameField.getText());
        blockOutputModel.getInputValueArgs().add(inputValueModel);
        argumentStage.close();
    }

    @FXML
    private void handleCancel(){
        argumentStage.close();
    }

    public void setArgumentStage(Stage argumentStage) {
        this.argumentStage = argumentStage;
    }

    public void setInputValueModel(InputValueModel inputValueModel) {
        this.inputValueModel = inputValueModel;
        nameField.setText(inputValueModel.getArgName());
        checkChoiceBox.getSelectionModel().select(inputValueModel.getArgCheck());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setBlockOutputModel(BlockOutputModel blockOutputModel) {
        this.blockOutputModel = blockOutputModel;
    }

    public MainApp getMainApp() {
        return mainApp;
    }
}
