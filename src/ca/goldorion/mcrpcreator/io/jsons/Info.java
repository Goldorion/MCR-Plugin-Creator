package ca.goldorion.mcrpcreator.io.jsons;

import java.util.List;

public class Info {
    private String name;
    private String description;
    private String version;
    private String author;
    private String credits;
    private List<String> dependencies;

    public Info(String name, String description, String version, String author, String credits, List<String> dependencies) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.author = author;
        this.credits = credits;
        this.dependencies = dependencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
}
