package ca.goldorion.mcrpcreator.io.jsons;

public class PluginJson {

    private String id;
    private long minversion;
    private Info info;

    public PluginJson(String id, long minversion, Info info) {
        this.id = id;
        this.minversion = minversion;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMinversion() {
        return minversion;
    }

    public void setMinversion(int minversion) {
        this.minversion = minversion;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
