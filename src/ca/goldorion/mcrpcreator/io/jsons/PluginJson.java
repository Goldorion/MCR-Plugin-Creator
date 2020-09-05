package ca.goldorion.mcrpcreator.io.jsons;

public class PluginJson {

    private String id;
    private long minversion;
    private Infos infos;

    public PluginJson(String id, long minversion, Infos infos) {
        this.id = id;
        this.minversion = minversion;
        this.infos = infos;
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

    public Infos getInfos() {
        return infos;
    }

    public void setInfos(Infos infos) {
        this.infos = infos;
    }
}
