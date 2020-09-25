package ca.goldorion.mcrpcreator.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class PluginList {

    public StringProperty loaded;
    public List<StringProperty> plugins;

    public PluginList() {
        this.loaded = new SimpleStringProperty();
        this.plugins = new ArrayList<>();
    }

    public String getLoaded() {
        return loaded.get();
    }

    public StringProperty loadedProperty() {
        return loaded;
    }

    public void setLoaded(String loaded) {
        this.loaded.set(loaded);
    }

    public List<StringProperty> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<StringProperty> plugins) {
        this.plugins = plugins;
    }
}
