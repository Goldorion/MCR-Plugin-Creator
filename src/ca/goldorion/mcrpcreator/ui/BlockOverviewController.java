package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.io.Export;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.utils.AlertUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BlockOverviewController {

    @FXML
    private TableView<BlockModel> blockTable;
    @FXML
    private TableColumn<BlockModel, String> fileNameColumn;

    private MainApp mainApp;

    public BlockOverviewController(){
    }

    @FXML
    private void initialize(){
        // Initialize the block table with the two columns.
        fileNameColumn.setCellValueFactory(cellData -> cellData.getValue().fileNameProperty());
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        blockTable.setItems(mainApp.getBlockData());
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
        BlockModel blockModel = new BlockModel("");
        mainApp.getBlockData().add(blockModel);
        mainApp.showBlockEditDialog(blockModel);
    }

    @FXML
    private void handleEditBlock(){
        BlockModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
        if(selectedBlock != null){
            mainApp.showBlockEditDialog(selectedBlock);

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
        BlockModel selectedBlock = blockTable.getSelectionModel().getSelectedItem();
            Export.export(mainApp, selectedBlock);
    }
}
