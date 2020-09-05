package ca.goldorion.mcrpcreator.io.export;

import ca.goldorion.mcrpcreator.io.jsons.Infos;
import ca.goldorion.mcrpcreator.io.jsons.PluginJson;
import ca.goldorion.mcrpcreator.models.PluginJsonModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class PluginJsonExport {

    public static void pluginJson(PluginJsonModel model){
        File folder = new File(System.getProperty("user.dir") + "/export/");
        if(!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(System.getProperty("user.dir") + "/export/plugin.json");
        Infos infos = new Infos(
                model.getName(),
                model.getDescription(),
                model.getVersion(),
                model.getAuthor()
        );
        PluginJson pluginJson = new PluginJson(
                model.getId(),
                model.getMinversion(),
                infos
                );

        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String json = gson.toJson(pluginJson);
        FileUtils.saveFile(file, json);
        System.out.println(json);
    }
}
