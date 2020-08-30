package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.Export;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BlockOverviewController {

    @FXML
    private TableView<BlockOutputModel> blockTable;
    @FXML
    private TableColumn<BlockOutputModel, String> fileNameColumn;
    @FXML
    private TableColumn<BlockOutputModel, String> typeColumn;

    @FXML
    private Label fileNameLabel;
    @FXML
    private Label textLabel;
    @FXML
    private Label inputsLabel;
    @FXML
    private Label fieldsLabel;
    @FXML
    private Label extensionsLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label colourLabel;
    @FXML
    private Label toolboxLabel;
    @FXML
    private Label dependenciesLabel;

    private MainApp mainApp;

    public BlockOverviewController(){
    }

    @FXML
    private void initialize(){
        // Initialize the block table with the two columns.
        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().fileNameProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        // Clear block details.
        showBlockDetails(null);

        // Listen for selection changes and show the block details when changed.
        blockTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBlockDetails(newValue));
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        blockTable.setItems(mainApp.getBlockData());
    }

    private void showBlockDetails(BlockOutputModel block) {
        if(block != null){
            fileNameLabel.setText(block.getFileName());
            textLabel.setText(block.getText());
            inputsLabel.setText(block.getInputs().toString());
            fieldsLabel.setText(block.getFields().toString());
            extensionsLabel.setText(block.getExtensions().toString());
            typeLabel.setText(block.getBlockType() + " - "+ block.getType());
            colourLabel.setText(Integer.toString(block.getColour()));
            toolboxLabel.setText(block.getToolbox());

            //ArrayList to store all dependencies used in the JSON
            String dependencies = "";
            if(block.isBool()){
                dependencies = "Boolean - ";
            }
            if(block.isDirection()){
                dependencies = dependencies + "Direction - ";
            }
            if(block.isEntity()){
                dependencies = dependencies + "Entity -\n";
            }
            if(block.isInteger()){
                dependencies = dependencies + "Int - ";
            }
            if(block.isItemstack()){
                dependencies = dependencies + "Itemstack - ";
            }
            if(block.isMap()){
                dependencies = dependencies + "Map - \n";
            }
            if(block.isString()){
                dependencies = dependencies + "String - ";
            }
            if(block.isWorld()){
                dependencies = dependencies + "World";
            }
            if(dependencies.equals("")){
                dependencies = "None";
            }

            dependenciesLabel.setText(dependencies);
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
        mainApp.showBlockTypeSelector();
    }

    @FXML
    private void handleEditBlock(){
        BlockOutputModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
        if(selectedBlock != null){
            boolean okClicked = mainApp.showBlockOutputEditDialog(selectedBlock);
            if(okClicked){
                showBlockDetails(selectedBlock);
            }

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
        BlockOutputModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
        if(typeLabel.toString().contains("Output")){
            Export.OutputProcedureBlock(mainApp, selectedBlock);
        }
    }
}
