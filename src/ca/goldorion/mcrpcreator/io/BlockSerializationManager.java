package ca.goldorion.mcrpcreator.io;

import ca.goldorion.mcrpcreator.io.jsons.BlockOutput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BlockSerializationManager {

    private Gson gson;

    public BlockSerializationManager() {
        this.gson = createGsonInstance();
    }

    private Gson createGsonInstance(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public String serializeBlockOutput(BlockOutput block){
        return this.gson.toJson(block);

    }

    public BlockOutput deserializeBlockOutput(String json){
        return this.gson.fromJson(json, BlockOutput.class);
    }
}
