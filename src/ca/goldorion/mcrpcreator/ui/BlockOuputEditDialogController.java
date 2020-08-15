package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.models.BlockModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BlockOuputEditDialogController {
    @FXML
    private TextField fileNameField;
    @FXML
    private TextField textField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField colourField;
    @FXML
    private TextField toolboxField;
    @FXML
    private TextField dependenciesField;

    private Stage dialogStage;
    private BlockModel blockModel;
    private boolean okClicked = false;

    @FXML
    private void initialize(){
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setBlockModel(BlockModel blockModel){
        this.blockModel = blockModel;

        fileNameField.setText((blockModel.getFileName()));
        textField.setText((blockModel.getText()));
        typeField.setText(blockModel.getType());
        colourField.setText(Integer.toString(blockModel.getColour()));
        toolboxField.setText(blockModel.getToolbox());
        dependenciesField.setText(blockModel.getDependencies());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            blockModel.setFileName(fileNameField.getText());
            blockModel.setText(textField.getText());
            blockModel.setType(typeField.getText());
            blockModel.setColour(Integer.parseInt(colourField.getText()));
            blockModel.setToolbox(toolboxField.getText());
            if(dependenciesField.getText() == null || dependenciesField.getText().length() == 0) {
                blockModel.setDependencies(dependenciesField.getText());
            }

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(){
        dialogStage.close();
    }

    private boolean isInputValid() {
        String message = "";
        if(fileNameField.getText() == null || fileNameField.getText().length() == 0){
            message += "File name is not valid!\n";
        }
        if(textField.getText() == null || textField.getText().length() == 0){
            message += "Text is not valid!\n";
        }
        if(typeField.getText() == null || typeField.getText().length() == 0){
            message += "Type is not valid!\n";
        }
        if(colourField.getText() == null || colourField.getText().length() == 0){
            message += "Colour is not valid!\n";
        } else{
            try{
                Integer.parseInt(colourField.getText());
            } catch(NumberFormatException e){
                message += "Colour number is not valid (must be an integer)!\n";
            }
        }
        if(toolboxField.getText() == null || toolboxField.getText().length() == 0){
            message += "Toolbox is not valid!\n";
        }

        if(message.length() == 0){
            return true;
        } else{
            AlertWindows.error(dialogStage, "Invalid Field(s)", "Please correct invalid field(s)", message);
            return false;
        }
    }

}
