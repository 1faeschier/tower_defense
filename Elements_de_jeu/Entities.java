package Elements_de_jeu;

import javafx.scene.image.Image;

import javax.swing.*;

public class Entities {
    private int x;
    private int y;
    private int id;
    private String description;
    private int height;
    private int width;
    private Image image;

    public void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



}

