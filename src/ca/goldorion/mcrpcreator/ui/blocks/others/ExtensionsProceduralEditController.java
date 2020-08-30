package ca.goldorion.mcrpcreator.ui.blocks.others;

import ca.goldorion.mcrpcreator.MainApp;
import ca.goldorion.mcrpcreator.models.ProceduralBlockModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExtensionsProceduralEditController {
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

    public ArrayList<String> extensions = new ArrayList<>();
    public ArrayList<String> fields = new ArrayList<>();

    private Stage extensionStage;
    private ProceduralBlockModel proceduralBlockModel;
    MainApp mainApp;

    @FXML
    private void initialize(){
    }

    public void setExtensionStage(Stage extensionStage) {
        this.extensionStage = extensionStage;
    }

    public ExtensionsProceduralEditController() {
    }

    @FXML
    private void handleConfirm(){
        setExtensionsArrayLists();
        proceduralBlockModel.setExtensions(extensions);
        proceduralBlockModel.setFields(fields);
        extensionStage.close();
    }

    @FXML
    private void handleCancel(){
        extensionStage.close();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setProceduralBlockModel(ProceduralBlockModel proceduralBlockModel) {
        this.proceduralBlockModel = proceduralBlockModel;
        achievementBox.setSelected(proceduralBlockModel.getExtensions().contains("achievement_list_provider"));
        biomeBox.setSelected(proceduralBlockModel.getExtensions().contains("biome_list_provider"));
        biomeDicBox.setSelected(proceduralBlockModel.getExtensions().contains("biome_dictionary_list_provider"));
        damageBox.setSelected(proceduralBlockModel.getExtensions().contains("damagesource_list_provider"));
        dimensionsBox.setSelected(proceduralBlockModel.getExtensions().contains("dimension_list_provider"));
        enchantBox.setSelected(proceduralBlockModel.getExtensions().contains("enhancement_list_provider"));
        entityBox.setSelected(proceduralBlockModel.getExtensions().contains("entity_list_provider"));
        gamemodeBox.setSelected(proceduralBlockModel.getExtensions().contains("gamemode_list_provider"));
        guiBox.setSelected(proceduralBlockModel.getExtensions().contains("gui_list_provider"));
        particleBox.setSelected(proceduralBlockModel.getExtensions().contains("particle_list_provider"));
        potionBox.setSelected(proceduralBlockModel.getExtensions().contains("potion_list_provider"));
        rangedItemBox.setSelected(proceduralBlockModel.getExtensions().contains("rangeditem_list_provider"));
        soundBox.setSelected(proceduralBlockModel.getExtensions().contains("sound_list_provider"));
    }

    private void setExtensionsArrayLists(){
        if(achievementBox.isSelected()){
            extensions.add("achievement_list_provider");
            fields.add("achivement_type");
        }
        if(biomeBox.isSelected()){
            extensions.add("biome_list_provider");
            fields.add("biome_type");
        }
        if(biomeDicBox.isSelected()){
            extensions.add("biome_dictionary_list_provider");
            fields.add("biome_dict_type");
        }
        if(damageBox.isSelected()){
            extensions.add("damagesource_list_provider");
            fields.add("damage_type");
        }
        if(dimensionsBox.isSelected()){
            extensions.add("dimension_list_provider");
            fields.add("dimension_type");
        }
        if(enchantBox.isSelected()){
            extensions.add("enhancement_list_provider");
            fields.add("enchancement_type");
        }
        if(entityBox.isSelected()){
            extensions.add("entity_list_provider");
            fields.add("entity_type");
        }
        if(gamemodeBox.isSelected()){
            extensions.add("gamemode_list_provider");
            fields.add("gamemode_type");
        }
        if(guiBox.isSelected()){
            extensions.add("gui_list_provider");
            fields.add("gui_type");
        }
        if(particleBox.isSelected()){
            extensions.add("particle_list_provider");
            fields.add("particle_type");
        }
        if(potionBox.isSelected()){
            extensions.add("potion_list_provider");
            fields.add("potion_type");
        }
        if(rangedItemBox.isSelected()){
            extensions.add("rangeditem_list_provider");
            fields.add("ranged_item_type");
        }
        if(soundBox.isSelected()){
            extensions.add("sound_list_provider");
            fields.add("sound_type");
        }
    }
}
