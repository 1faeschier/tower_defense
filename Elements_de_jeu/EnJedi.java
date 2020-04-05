package Elements_de_jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnJedi extends Ennemie implements Runnable {
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int health; //vie
    private int speed = 15;//vitesse du perso = temps en miliseconde entre deux déplacement de 1 unité
    private Thread t;


    public EnJedi(Position positioninit) {
        position = positioninit;
        t = new Thread(this);
        t.start();
    }
    public int getHealth() {
        return health;
    }
    public int getPower(){
        return power;
    }

    public String getDescription(){
        return description;
    }

    public Position getPosition() {
        return position;
    }

    public EnJedi createnew() {
        EnJedi b = new EnJedi(position);
        return b;
    }

    public Rectangle getforme() {
        r.setHeight(20);
        r.setWidth(20);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setStroke(Color.BLUE);
        return r;
    }

    public void move(double dx, double dy) {
        position.setX(position.getX() + dx);
        position.setY(position.getY() + dy);
    }

    public void update() {
        r.setX(position.getX());
        r.setY(position.getY());
    }

    @Override
    public void run() {
        while ((getPosition().getX()>100) && (getPosition().getY() == 100) && health > 0) {
            move(-1, 0);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (getPosition().getY()<550 && health > 0) {
            move(0, 1);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        while ((getPosition().getX()<1000) && (getPosition().getY() == 550 && health > 0)) {
            move(1, 0);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
