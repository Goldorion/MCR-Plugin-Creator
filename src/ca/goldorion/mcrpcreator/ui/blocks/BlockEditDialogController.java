package ca.goldorion.mcrpcreator.ui.blocks;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.export.OutputBlock;
import ca.goldorion.mcrpcreator.io.export.ProceduralBlock;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class BlockEditDialogController {

    private MainApp mainApp;
    private Stage dialogStage;
    private BlockModel blockModel;
    private boolean okClicked = false;

    @FXML
    private TextField fileNameField;

    @FXML
    private ChoiceBox<String> blockTypeChoiceBox;
    private final ObservableList<String> availableBlockTypes = FXCollections.observableArrayList(
            "Procedural Block", "Output Block");

    @FXML
    private TextField textField;

    //Arguments
    @FXML
    ListView argList;
    @FXML
    private ChoiceBox<String> argTypeChoiceBox;
    private final ObservableList<String> availableArgTypes = FXCollections.observableArrayList(
            "input_value", "field_input", "field_checkbox");
    @FXML
    private TextField argNameField;
    @FXML
    private ChoiceBox<String> checkArgChoiceBox;
    private final ObservableList<String> availableArgChecks = FXCollections.observableArrayList(
            "All", "Boolean", "Direction", "MCItem", "MCItemBlock", "Number", "String");
    @FXML
    private CheckBox argChecked;

    @FXML
    private CheckBox inputsInlineCheckBox;
    @FXML
    private CheckBox nextStatementCheckBox;

    @FXML
    ChoiceBox<String> typeChoiceBox;
    ObservableList<String> availableTypes = FXCollections.observableArrayList(
            "Boolean", "Direction", "MCItem", "MCItemBlock", "Number", "String");

    @FXML
    private TextField colourField;
    @FXML
    private TextField toolboxField;
    @FXML
    private CheckBox boolBox;
    @FXML
    private CheckBox directionBox;
    @FXML
    private CheckBox entityBox;
    @FXML
    private CheckBox integerBox;
    @FXML
    private CheckBox itemstackBox;
    @FXML
    private CheckBox mapBox;
    @FXML
    private CheckBox stringBox;
    @FXML
    private CheckBox worldBox;

    @FXML
    private void initialize(){
        typeChoiceBox.setItems(availableTypes);
        typeChoiceBox.getSelectionModel().selectFirst();

        blockTypeChoiceBox.setItems(availableBlockTypes);
        blockTypeChoiceBox.getSelectionModel().selectFirst();

        argTypeChoiceBox.setItems(availableArgTypes);
        argTypeChoiceBox.getSelectionModel().selectFirst();

        checkArgChoiceBox.setItems(availableArgChecks);
        checkArgChoiceBox.getSelectionModel().selectFirst();

    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setBlockOutputModel(BlockModel blockModel){
        this.blockModel = blockModel;

        fileNameField.setText(blockModel.getFileName());
        blockTypeChoiceBox.getSelectionModel().select(blockModel.getBlockType());

        textField.setText(blockModel.getText());
        List list = FXCollections.observableList(blockModel.getArgName());
        argList.setItems((ObservableList) list);
        inputsInlineCheckBox.setSelected(blockModel.isInputsInline());
        nextStatementCheckBox.setSelected(blockModel.isNextStatement());
        typeChoiceBox.getSelectionModel().select(blockModel.getType());
        colourField.setText(Integer.toString(blockModel.getColour()));
        toolboxField.setText(blockModel.getToolbox());
        boolBox.setSelected(blockModel.isBool());
        directionBox.setSelected(blockModel.isDirection());
        entityBox.setSelected(blockModel.isEntity());
        integerBox.setSelected(blockModel.isInteger());
        itemstackBox.setSelected(blockModel.isItemstack());
        mapBox.setSelected(blockModel.isMap());
        stringBox.setSelected(blockModel.isString());
        worldBox.setSelected(blockModel.isWorld());
    }

    public boolean isOkClicked() {
        return okClicked;
    }


    @FXML
    private void handleNewArg(){
        if(!argNameField.getText().isEmpty()) {
            blockModel.getArgType().add(argTypeChoiceBox.getValue());
            blockModel.getArgName().add(argNameField.getText());
            switch (argTypeChoiceBox.getValue()) {
                case "input_value":
                    blockModel.getArgSpecial().add(checkArgChoiceBox.getValue());
                    blockModel.getInputs().add(argNameField.getText());
                    break;
                case "field_input":
                    blockModel.getArgSpecial().add(null);
                    blockModel.getFields().add(argNameField.getText());
                    break;
                case "field_checkbox":
                    if (argChecked.isSelected()) {
                        blockModel.getArgSpecial().add("true");
                    } else {
                        blockModel.getArgSpecial().add("false");
                    }
                    blockModel.getFields().add(argNameField.getText());
                    break;
            }
           // argList.getItems().add(argNameField.getText());

        } else {
            AlertUtils.error("Invalid Argument Name", "Please give a name to your argument.");
        }
    }

    @FXML
    private void handleEditArg(){

    }


    @FXML
    private void handleEditExtensions(){
        mainApp.showExtensionsBlockEdit(blockModel);
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            blockModel.setFileName(fileNameField.getText());
            blockModel.setBlockType(blockTypeChoiceBox.getSelectionModel().getSelectedItem());
            if(blockModel.getBlockType().isEmpty()){
                blockModel.setBlockType("Procedural Block");
            }
            blockModel.setText(textField.getText());
            blockModel.setInputsInline(inputsInlineCheckBox.isSelected());
            blockModel.setNextStatement(nextStatementCheckBox.isSelected());
            blockModel.setType(typeChoiceBox.getSelectionModel().getSelectedItem());
            if(blockModel.getType().equals("")){
                blockModel.setType("Boolean");
            }
            blockModel.setColour(Integer.parseInt(colourField.getText()));
            blockModel.setToolbox(toolboxField.getText());
            blockModel.setBool(boolBox.isSelected());
            blockModel.setDirection(directionBox.isSelected());
            blockModel.setEntity(entityBox.isSelected());
            blockModel.setInteger(integerBox.isSelected());
            blockModel.setItemstack(itemstackBox.isSelected());
            blockModel.setMap(mapBox.isSelected());
            blockModel.setString(stringBox.isSelected());
            blockModel.setWorld(worldBox.isSelected());


            File folder = new File(System.getProperty("user.dir") + "/export/procedures/");
            if(!folder.exists()){
                folder.mkdirs();
            }
            File file = new File(System.getProperty("user.dir") + "/export/procedures/" +
                    blockModel.getFileName() + ".json");
            if(blockModel.getBlockType().equals("Output Block")){
                OutputBlock.outputProcedureBlock(blockModel, file);
            } else if(blockModel.getBlockType().equals("Procedural Block")){
                ProceduralBlock.proceduralProcedureBlock(blockModel, file);
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
            AlertUtils.error(dialogStage, "Invalid Field(s)", "Please correct invalid field(s)", message);
            return false;
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
