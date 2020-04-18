package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Ennemie extends Entities{
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int speed;//vitesse du perso
    public Position position;
    public int health;
    public Rectangle r = new Rectangle();

    public Ennemie() {
        super();
    }

    public int getHealth(){return health;};

    public void update(){}

    Position getPosition(){
        return position;
    }

    public void looseHealth(int amount) {
        health -= amount;
        if (health <= 0){
            r.setWidth(0);
            r.setHeight(0);
            r.setStroke(Color.BROWN);
            Map.score += 10;
        }
    }

    public Rectangle getForme() {
        r.setHeight(10);
        r.setWidth(40);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.RED);
        r.setStroke(Color.BLACK);
        return r;
    }

    public void start(ArrayList<Ennemie> listenemie, Way way, int map) {
    }
    public void pause() {}
}
