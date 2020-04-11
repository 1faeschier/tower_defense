package Elements_de_jeu;

import javafx.scene.image.Image;

import javax.swing.*;

public class Entities {
    private int id;
    private String description;
    private int height;
    private int width;
    private Image image;

    public Entities(int id, String description, int height, int width, Image image){
        this.id = id;
        this.description = description;
        this.height = height;
        this.width = width;
        this.image = image;
    }
    
    

}

