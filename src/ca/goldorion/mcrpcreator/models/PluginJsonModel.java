package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.*;

public class PluginJsonModel {
    private StringProperty id;
    private LongProperty minversion;
    private StringProperty name;
    private StringProperty description;
    private StringProperty version;
    private StringProperty author;

    public PluginJsonModel() {
        this.id = new SimpleStringProperty();
        this.minversion = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.version = new SimpleStringProperty();
        this.author = new SimpleStringProperty();
    }

    public String getId() {
        return id.get();
    }


    public void setId(String id) {
        this.id.set(id);
    }

    public long getMinversion() {
        return minversion.get();
    }

    public void setMinversion(long minversion) {
        this.minversion.set(minversion);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }


    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getVersion() {
        return version.get();
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public String getAuthor() {
        return author.get();
    }


    public void setAuthor(String author) {
        this.author.set(author);
    }
}
