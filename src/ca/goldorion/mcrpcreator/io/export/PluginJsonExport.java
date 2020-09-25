package ca.goldorion.mcrpcreator.io.export;

import ca.goldorion.mcrpcreator.io.jsons.Info;
import ca.goldorion.mcrpcreator.io.jsons.PluginJson;
import ca.goldorion.mcrpcreator.models.PluginJsonModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class PluginJsonExport {

    public static void pluginJson(PluginJsonModel model) {
        File folder = new File(System.getProperty("user.dir") + "/plugins/" + model.getId());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(System.getProperty("user.dir") + "/plugins/" + model.getId() + "/plugin.json");
        Info info = new Info(
                model.getName(),
                model.getDescription(),
                model.getVersion(),
                model.getAuthor(),
                model.getCredits(),
                model.getDependencies()
        );
        PluginJson pluginJson = new PluginJson(
                model.getId(),
                model.getMinversion(),
                info
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String json = gson.toJson(pluginJson);
        FileUtils.saveFile(file, json);
        System.out.println(json);
    }
}
