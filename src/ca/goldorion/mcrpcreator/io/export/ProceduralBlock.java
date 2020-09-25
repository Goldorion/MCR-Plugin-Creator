package ca.goldorion.mcrpcreator.io.export;

import ca.goldorion.mcrpcreator.io.jsons.*;
import ca.goldorion.mcrpcreator.models.BlockModel;
import ca.goldorion.mcrpcreator.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;

public class ProceduralBlock {
    public static void proceduralProcedureBlock(BlockModel selectedBlock, File file) {
        if(file != null) {
            if(!file.getPath().endsWith(".json")) {
                file = new File(file.getPath() + ".json");
            }

            //Dependencies object

            //ArrayList to store all dependencies used in the JSON
            ArrayList<Dependencies> dependencies = new ArrayList<>();
            if(selectedBlock.isBool()){
                Dependencies depenBool = new Dependencies("boolean", "boolean");
                dependencies.add(depenBool);
            }
            if(selectedBlock.isDirection()){
                Dependencies depenDirec = new Dependencies("direction", "direction");
                dependencies.add(depenDirec);
            }
            if(selectedBlock.isEntity()){
                Dependencies depenEntity = new Dependencies("entity", "entity");
                dependencies.add(depenEntity);
            }
            if(selectedBlock.isInteger()){
                Dependencies depenX = new Dependencies("int", "x");
                dependencies.add(depenX);
                Dependencies depenY = new Dependencies("int", "y");
                dependencies.add(depenY);
                Dependencies depenZ = new Dependencies("int", "z");
                dependencies.add(depenZ);
            }
            if(selectedBlock.isItemstack()){
                Dependencies depenItemstack = new Dependencies("itemstack", "itemstack");
                dependencies.add(depenItemstack);
            }
            if(selectedBlock.isMap()){
                Dependencies depenMap = new Dependencies("map", "cmdparams");
                dependencies.add(depenMap);
            }
            if(selectedBlock.isString()){
                Dependencies depenString = new Dependencies("string", "string");
                dependencies.add(depenString);
            }
            if(selectedBlock.isWorld()){
                Dependencies depenWorld = new Dependencies("world", "world");
                dependencies.add(depenWorld);
            }

            //MCreator object with the dependencies object
            ArrayList fields = selectedBlock.getFields() != null ? selectedBlock.getFields() : new ArrayList();
            ArrayList inputs = selectedBlock.getInputs() != null ? selectedBlock.getInputs() : new ArrayList();
            ArrayList dependenciesFinal = dependencies  != null ? dependencies : new ArrayList();
            MCreator mcreator = new MCreator(
                    selectedBlock.getToolbox(),
                    fields,
                    inputs,
                    dependenciesFinal);

            //BlockOutputImport object with the mcreator object
            //Arguments
            ArrayList<Object> args = new ArrayList<>();
            int i = 0;
            while (selectedBlock.getArgName().size() > i ) {
                switch (selectedBlock.getArgType().get(i)) {
                    case "input_value":
                        String check = null;
                        if(!selectedBlock.getArgSpecial().get(i).equals("All")){
                            check = selectedBlock.getArgSpecial().get(i);
                        }
                        InputValue inputValue = new InputValue(
                                selectedBlock.getArgType().get(i),
                                selectedBlock.getArgName().get(i),
                                check
                        );
                        args.add(inputValue);
                        break;
                    case "field_input":
                        FieldInput fieldInput = new FieldInput(
                                selectedBlock.getArgType().get(i),
                                selectedBlock.getArgName().get(i)
                        );
                        args.add(fieldInput);
                        break;
                    case "field_checkbox":
                        boolean checked = selectedBlock.getArgSpecial().get(i).equals("true");
                        FieldCheckbox fieldCheckbox = new FieldCheckbox(
                                selectedBlock.getArgType().get(i),
                                selectedBlock.getArgName().get(i),
                                checked
                        );
                        args.add(fieldCheckbox);
                        break;
                }
                i++;
            }
            if(args.isEmpty()){
                args = null;
            }
            //Extensions
            ArrayList extensions;
            if(!(selectedBlock.getExtensions() == null)){
                extensions = selectedBlock.getExtensions();
            } else {
                extensions = new ArrayList();
            }
            ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock proceduralBlock = new ca.goldorion.mcrpcreator.io.jsons.ProceduralBlock(
                    selectedBlock.getText(),
                    args,
                    selectedBlock.isInputsInline(),
                    selectedBlock.isNextStatement(),
                    true,
                    selectedBlock.getColour(),
                    extensions,
                    mcreator);
            //Create a Gson Builder and add the JSON in a String to create a file with the String
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            String json = gson.toJson(proceduralBlock);
            FileUtils.saveFile(file, json);
            System.out.println(json);

        }
    }

}
