package Elements_de_jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Ennemie {
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int speed;//vitesse du perso
    public Position position;
    public int health = 200;
    public Rectangle r = new Rectangle();

    public int getHealth(){return health;};
    
    public void update(){}
    
    public Rectangle getForme() {
        r.setHeight(20);
        r.setWidth(20);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
        return r;
    }    

    Position getPosition(){
        return position;
    }

    public void looseHealth(int amount) {
        health -= amount;
        if (health <= 0){
            r.setWidth(0);
            r.setHeight(0);
            r.setStroke(Color.BROWN);
        }
        System.out.println(health);
    }
    
    public void start(ArrayList<Ennemie> listenemie, Way way) {
    }    
    
}

