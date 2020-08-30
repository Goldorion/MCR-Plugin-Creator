package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.models.ProceduralBlockModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class BlockTypeSelectorController {

    @FXML
    ChoiceBox<String> choiceBox;

    ObservableList<String> availableChoices = FXCollections.observableArrayList("Output Block");

    private MainApp mainApp;

    private Stage dialogStage;

    public BlockTypeSelectorController() {
    }

    @FXML
    private void initialize(){
        choiceBox.setItems(availableChoices);
        choiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleConfirmButton(){
        String selectedChoice = choiceBox.getSelectionModel().getSelectedItem();


        switch (selectedChoice) {
            case "Output Block": {
                BlockOutputModel tempBlock = new BlockOutputModel("");
                boolean okClicked = mainApp.showBlockOutputEditDialog(tempBlock);
                if (okClicked) {
                    mainApp.getBlockData().add(tempBlock);
                }

                dialogStage.close();
                break;
            }
            case "Procedural Block": {
                ProceduralBlockModel tempBlock = new ProceduralBlockModel("");
                boolean okClicked = mainApp.showProceduralBlockEditDialog(tempBlock);
                if (okClicked) {
                    mainApp.getBlockData().add(tempBlock);
                }
                dialogStage.close();
                break;
            }
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
