package ca.goldorion.mcrpcreator.preferences;

import ca.goldorion.mcrpcreator.MainApp;

import java.io.File;

import static ca.goldorion.mcrpcreator.MainApp.appName;

public class Preferences {

    private MainApp mainApp;

    public static File getBlockFilePath(){
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if(filePath != null){
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setBlockFilePath(File file){
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(MainApp.class);
        if(file != null){
            prefs.put("filePath", file.getPath());
            mainApp.getPrimaryStage().setTitle(appName + file.getName());
        } else {
            prefs.remove("filePath");

            mainApp.getPrimaryStage().setTitle(appName);
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
