package ca.goldorion.mcrpcreator.ui.blocks;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.export.OutputBlock;
import ca.goldorion.mcrpcreator.io.export.ProceduralBlock;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.ui.BlockOverviewController;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private ChoiceBox<String> blockElementChoiceBox;
    private final ObservableList<String> availableBlockElements = FXCollections.observableArrayList(
            "aitasks", "procedures");

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

    //Dependencies
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

    //Code & Generators
    @FXML
    private TextField nameArgCode;
    @FXML
    private RadioButton inputRadioButton;
    @FXML
    private RadioButton fieldRadioButton;
    @FXML
    private TextArea codeArea;
    @FXML
    ChoiceBox<String> generatorsChoiceBox;
    ObservableList<String> availableGens = FXCollections.observableArrayList(
            "All", "forge-1.12.2", "forge-1.14.4", "forge-1.15.2", "fabric-1.16.3", "spigot-1.16.2");

    @FXML
    private void initialize(){
        typeChoiceBox.setItems(availableTypes);
        typeChoiceBox.getSelectionModel().selectFirst();

        blockElementChoiceBox.setItems(availableBlockElements);
        blockElementChoiceBox.getSelectionModel().select("procedures");
        blockTypeChoiceBox.setItems(availableBlockTypes);
        blockTypeChoiceBox.getSelectionModel().selectFirst();

        argTypeChoiceBox.setItems(availableArgTypes);
        argTypeChoiceBox.getSelectionModel().selectFirst();

        checkArgChoiceBox.setItems(availableArgChecks);
        checkArgChoiceBox.getSelectionModel().selectFirst();

        generatorsChoiceBox.setItems(availableGens);
        generatorsChoiceBox.getSelectionModel().select(3);
    }

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setBlockOutputModel(BlockModel blockModel){
        this.blockModel = blockModel;

        fileNameField.setText(blockModel.getFileName());
        blockElementChoiceBox.getSelectionModel().select(blockModel.getBlockElement());
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
                    blockModel.getArgsListCode().add("${input$" + argNameField + "}");
                    break;
                case "field_input":
                    blockModel.getArgSpecial().add(null);
                    blockModel.getFields().add(argNameField.getText());
                    blockModel.getArgsListCode().add("${field$" + argNameField + "}");
                    break;
                case "field_checkbox":
                    if (argChecked.isSelected()) {
                        blockModel.getArgSpecial().add("true");
                    } else {
                        blockModel.getArgSpecial().add("false");
                    }
                    blockModel.getFields().add(argNameField.getText());
                    blockModel.getArgsListCode().add("${field$" + argNameField + "}");
                    break;
            }

        } else {
            AlertUtils.error("Invalid Argument Name", "Please give a name to your argument.");
        }
    }

    @FXML
    private void handleDeleteArg(){
        blockModel.getArgName().remove(argList.getSelectionModel().getSelectedIndex());
        blockModel.getArgSpecial().remove(argList.getSelectionModel().getSelectedIndex());
        blockModel.getArgType().remove(argList.getSelectionModel().getSelectedIndex());
        blockModel.getArgsListCode().remove(argList.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void handleEditArg(){
        argNameField.setText(blockModel.getArgName().get(argList.getSelectionModel().getSelectedIndex()));
        argTypeChoiceBox.getSelectionModel().select(blockModel.getArgType().get(argList.getSelectionModel().getSelectedIndex()));
        if(blockModel.getArgSpecial().get(argList.getSelectionModel().getSelectedIndex()).equals("true")){
            argChecked.setSelected(true);
        }else if(blockModel.getArgSpecial().get(argList.getSelectionModel().getSelectedIndex()).equals("false")){
            argChecked.setSelected(false);
        } else if(!blockModel.getArgSpecial().get(argList.getSelectionModel().getSelectedIndex()).isEmpty()){
            checkArgChoiceBox.getSelectionModel().select(argList.getSelectionModel().getSelectedIndex());
        }

    }


    @FXML
    private void handleEditExtensions(){
        mainApp.showExtensionsBlockEdit(blockModel);
    }

    @FXML
    private void handleOk(){
        if(isInputValid()){
            blockModel.setFileName(fileNameField.getText());
            blockModel.setBlockElement(blockElementChoiceBox.getSelectionModel().getSelectedItem());

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

            String path;
            if(!blockElementChoiceBox.getSelectionModel().getSelectedItem().equals("")){
                path = System.getProperty("user.dir") + "/plugins/" +
                        BlockOverviewController.getPlugin() + "/" +
                        blockElementChoiceBox.getSelectionModel().getSelectedItem() + "/";
            } else{
                path = System.getProperty("user.dir") + "/plugins/" +
                        BlockOverviewController.getPlugin() + "/procedures/";
            }
            File folder = new File(path);
            if(!folder.exists()){
                folder.mkdirs();
            }

            System.out.println(blockElementChoiceBox.getSelectionModel().getSelectedItem());

            File file = new File(path + "/"+ blockModel.getFileName() + ".json");
            if (blockModel.getBlockType().equals("Output Block")) {
                OutputBlock.outputProcedureBlock(blockModel, file);
            } else if (blockModel.getBlockType().equals("Procedural Block")) {
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
    
    //Code
    @FXML
    private void handleInputRadio(){
        inputRadioButton.setSelected(true);
        fieldRadioButton.setSelected(false);
    }
    @FXML
    private void handleFieldRadio(){
        fieldRadioButton.setSelected(true);
        inputRadioButton.setSelected(false);
    }
    
    @FXML
    private void handleAddArgCode(){
        String arg = "";
        if(inputRadioButton.isSelected()){
            arg = "${input$" + nameArgCode.getText() + "}";
        } else if(fieldRadioButton.isSelected()){
            arg = "${field$" + nameArgCode.getText() + "}";
        }
        
        codeArea.appendText(arg);
    }

    @FXML
    private void handleSaveCode() {
        if (!fileNameField.getText().isEmpty()) {
            if (!codeArea.getParagraphs().toString().isEmpty()) {
                if (!generatorsChoiceBox.getSelectionModel().getSelectedItem().equals("All")) {
                    createCodeFile(generatorsChoiceBox.getSelectionModel().getSelectedItem());
                    AlertUtils.info("Info", "File created", fileNameField.getText()
                            + "code file has been successfully created for "
                            + generatorsChoiceBox.getSelectionModel().getSelectedItem() + ".");
                } else {
                    for (String generator : generatorsChoiceBox.getItems()) {
                        if (!generator.equals("All")) {
                            createCodeFile(generator);
                        }
                    }
                    AlertUtils.info("Info", "Files created", fileNameField.getText()
                            + "code files have been successfully created for "
                            + generatorsChoiceBox.getSelectionModel().getSelectedItem() + ".");
                }

            } else {
                AlertUtils.error("No code", "The code area is empty. " +
                        "Please add a code, before saving your file.");
            }
        } else {
            AlertUtils.error("No file name", "Your block does not have a file name." +
                    " Please add one before saving your block.");
        }
    }

    @FXML
    private void handleEditCode(){
        if(!fileNameField.getText().isEmpty()){
            File file = new File(System.getProperty("user.dir") +"/export/"
                    + generatorsChoiceBox.getSelectionModel().getSelectedItem()
                    + "/" + blockElementChoiceBox.getSelectionModel().getSelectedItem() + "/"
                    + fileNameField.getText() + ".java.ftl");
            if(file.exists()) {
                String code = FileUtils.loadContent(file);
                codeArea.setText("");
                codeArea.setText(code);
            } else{
                AlertUtils.error("No file found", fileNameField.getText() + ".java.ftl doesn't exist for "
                        + generatorsChoiceBox.getSelectionModel().getSelectedItem() + ".");
            }
        }
    }

    @FXML
    private void handleRemoveCode(){
        if(!fileNameField.getText().isEmpty()){
            File file = new File(System.getProperty("user.dir") +"/export/"
                    + generatorsChoiceBox.getSelectionModel().getSelectedItem()
                    + "/" + blockElementChoiceBox.getSelectionModel().getSelectedItem() + "/"
                    + fileNameField.getText() + ".java.ftl");
            if(file.exists()){
                file.delete();
                AlertUtils.info("Info", "File removed", fileNameField.getText() + " has ben successfully removed for "
                        + generatorsChoiceBox.getSelectionModel().getSelectedItem() + ".");
            } else{
                AlertUtils.error("No file found", fileNameField.getText() + ".java.ftl doesn't exist for "
                        + generatorsChoiceBox.getSelectionModel().getSelectedItem() + ".");
            }

        }
    }


    //Others
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

    private void createCodeFile(String generator) {
        String path = System.getProperty("user.dir") +"/export/" + generator + "/" +
                blockElementChoiceBox.getSelectionModel().getSelectedItem() + "/";
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(path + fileNameField.getText() + ".java.ftl");
        FileUtils.saveFile(file, codeArea.getText());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
