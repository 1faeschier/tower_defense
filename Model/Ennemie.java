package Model;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Ennemie extends Entities{
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int speed = 10;//vitesse du perso
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
    }

    public Rectangle getForme() {
        return r;
    }

    public void start(ArrayList<Ennemie> listenemie, Way way, int map) {
    }
    public void pause() {
    }

    public void gel() {
    }

    public void degel() {
    }
}
