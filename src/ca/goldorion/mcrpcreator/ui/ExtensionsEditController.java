package ca.goldorion.mcrpcreator.ui;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.BlockOutputModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExtensionsEditController {
    @FXML
    private CheckBox achievementBox;
    @FXML
    private CheckBox biomeBox;
    @FXML
    private CheckBox biomeDicBox;
    @FXML
    private CheckBox damageBox;
    @FXML
    private CheckBox dimensionsBox;
    @FXML
    private CheckBox enchantBox;
    @FXML
    private CheckBox entityBox;
    @FXML
    private CheckBox gamemodeBox;
    @FXML
    private CheckBox guiBox;
    @FXML
    private CheckBox particleBox;
    @FXML
    private CheckBox potionBox;
    @FXML
    private CheckBox rangedItemBox;
    @FXML
    private CheckBox soundBox;

    ArrayList extensions;

    private Stage extensionStage;
    private BlockOutputModel blockOutputModel;
    private boolean okClicked = false;
    private MainApp mainApp;

    @FXML
    private void initialize(){
    }

    public void setExtensionStage(Stage extensionStage) {
        this.extensionStage = extensionStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public ExtensionsEditController(BlockOutputModel blockOutputModel) {
        this.blockOutputModel = blockOutputModel;

        if(achievementBox.isSelected()){
            extensions.add("achievement_list_provider");
        }
        if(biomeBox.isSelected()){
            extensions.add("biome_list_provider");
        }
        if(biomeDicBox.isSelected()){
            extensions.add("biome_dictionary_list_provider");
        }
        if(damageBox.isSelected()){
            extensions.add("damagesource_list_provider");
        }
        if(dimensionsBox.isSelected()){
            extensions.add("dimension_list_provider");
        }
        if(enchantBox.isSelected()){
            extensions.add("enhancement_list_provider");
        }
        if(entityBox.isSelected()){
            extensions.add("entity_list_provider");
        }
        if(gamemodeBox.isSelected()){
            extensions.add("gamemode_list_provider");
        }
        if(guiBox.isSelected()){
            extensions.add("gui_list_provider");
        }
        if(particleBox.isSelected()){
            extensions.add("particle_list_provider");
        }
        if(potionBox.isSelected()){
            extensions.add("potion_list_provider");
        }
        if(rangedItemBox.isSelected()){
            extensions.add("rangeditem_list_provider");
        }
        if(soundBox.isSelected()){
            extensions.add("sound_list_provider");
        }
    }

    @FXML
    private void handleConfirm(){
        blockOutputModel.setExtensions(blockOutputModel.setExtensions(extensions));
        extensionStage.close();
    }

    @FXML
    private void handleCancel(){
        extensionStage.close();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
