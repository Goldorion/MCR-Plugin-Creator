package ca.goldorion.mcrpcreator.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void createFile(File file){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                AlertUtils.error("Can not create the file", e.getMessage());
            }
        }
    }

    public static void saveFile(File file, String text) {
        final FileWriter fw;

        try{
            if(!file.exists()) {
                createFile(file);
            }
            fw = new FileWriter(file);
            fw.write(text);
            fw.flush();
            fw.close();

        } catch(IOException e) {
            e.printStackTrace();
            AlertUtils.error("Could not save data", "Could not save data to file:\n" + file.getPath());

        }
    }

    public static String loadContent(File file){
        if(file.exists()){
            try{
                final BufferedReader reader = new BufferedReader(new FileReader(file));
                final StringBuilder text = new StringBuilder();

                String line;

                while((line = reader.readLine()) != null){

                    text.append(line + "\n");
                }
                reader.close();

                return text.toString();

            } catch(IOException e){
                e.printStackTrace();
                AlertUtils.error("Could not load data", "Could not load data from file:\\n" + file.getPath());
            }
        }

        return "";

    }

    public static List<String> loadContentList(File file){
        if(file.exists()){
            try{
                final BufferedReader reader = new BufferedReader(new FileReader(file));
                List<String> plugins = new ArrayList<>();

                String line;

                while((line = reader.readLine()) != null){

                    plugins.add(line);
                }
                reader.close();

                return plugins;

            } catch(IOException e){
                e.printStackTrace();
                AlertUtils.error("Could not load data", "Could not load data from file:\\n" + file.getPath());
            }
        }

        return null;

    }
}
