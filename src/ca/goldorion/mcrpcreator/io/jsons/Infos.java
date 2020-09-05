package ca.goldorion.mcrpcreator.io.jsons;

public class Infos {
    private String name;
    private String description;
    private String version;
    private String author;

    public Infos(String name, String description, String version, String author) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.author = author;
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
}
