package ca.goldorion.mcrpcreator;

import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.ui.BlockOverviewController;
import ca.goldorion.mcrpcreator.ui.RootLayoutController;
import ca.goldorion.mcrpcreator.ui.SelectPluginController;
import ca.goldorion.mcrpcreator.ui.blocks.BlockEditDialogController;
import ca.goldorion.mcrpcreator.ui.blocks.others.ExtensionsEditController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    public static final String appName = "MCR Plugin Creator";
    public static final String version = "0.5.1";

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList blockData = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    public MainApp(){
        /*
          To add new templates, write them here
         */
    }

    public ObservableList getBlockData(){
        return blockData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(appName + " " + version);

        initRootLayout();
        showSelectPlugins();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/RootLayout.fxml"));
            this.rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the block overview inside the root layout.
     */
    public void showBlockOverview(String plugin) {
        try {
            // Load block overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/BlockOverview.fxml"));
            AnchorPane blockOverview = loader.load();

            // Set block overview into the center of root layout.
            rootLayout.setCenter(blockOverview);

            // Give the controller access to the main app.
            BlockOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlugin(plugin);
            controller.loadPluginJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showSelectPlugins() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/SelectPluginController.fxml"));
            AnchorPane page = loader.load();

            //Create the Dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Plugin selector");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            SelectPluginController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(dialogStage);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showBlockEditDialog(BlockModel blockModel){
        try{
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/BlockEditDialog.fxml"));
            AnchorPane page = loader.load();

            //Create the Dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Procedure Block");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //Set the block into the controller
            BlockEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBlockOutputModel(blockModel);
            controller.setMainApp(this);

            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showExtensionsBlockEdit(BlockModel outputBlockModel){
        try {
            // Load the extension edit window
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/ExtensionsOutputEdit.fxml"));
            AnchorPane page = loader.load();

            //Create the Dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Extensions");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ExtensionsEditController controller = loader.getController();
            controller.setExtensionStage(dialogStage);
            controller.setBlockOutputModel(outputBlockModel);
            controller.setMainApp(this);

            dialogStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
