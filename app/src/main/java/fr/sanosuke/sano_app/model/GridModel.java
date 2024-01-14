package fr.sanosuke.sano_app.model;

public class GridModel {

    String text;
    int image;

    public GridModel(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }

}
