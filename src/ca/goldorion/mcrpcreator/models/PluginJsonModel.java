package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PluginJsonModel {
    private StringProperty id;
    private LongProperty minversion;
    private StringProperty name;
    private StringProperty description;
    private StringProperty version;
    private StringProperty author;
    private StringProperty credits;
    private List<String> dependencies;

    public PluginJsonModel() {
        this.id = new SimpleStringProperty();
        this.minversion = new SimpleLongProperty();
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.version = new SimpleStringProperty();
        this.author = new SimpleStringProperty();
        this.credits = new SimpleStringProperty();
        this.dependencies = new ArrayList();
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

    public String getCredits() {
        return credits.get();
    }

    public StringProperty creditsProperty() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits.set(credits);
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        String[] str = dependencies.split(", ");
        List<String> al = new ArrayList<String>();
        al = Arrays.asList(str);
        this.dependencies = al;
    }
}
