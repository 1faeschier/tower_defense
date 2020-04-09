package Elements_de_jeu;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import javafx.scene.shape.Line;


public class EnJedi extends Ennemie implements Runnable {
    private int health = 10; //vie
    private int speed = 15;//vitesse du perso = temps en miliseconde entre deux déplacement de 1 unité
    private Thread t;
    private ArrayList<Ennemie> listenemie;
    private Way way;


    public EnJedi(Position positioninit) {
        super();
        position = positioninit;
        t = new Thread(this);
    }
    public int getHealth() {
        return health;
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
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
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
        ArrayList<Line> waylist = way.getWay();
        while (position.isonWay(way) && position.getX()>waylist.get(0).getEndX()-10) {
            move(-1, 0);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (position.isonWay(way) && position.getY()<waylist.get(1).getEndY()-10) {
            move(0, 1);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        while ((position.isonWay(way) && position.getX()<waylist.get(2).getEndX())) {
            move(1, 0);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void start(ArrayList<Ennemie> list, Way way) {
        listenemie = list;
        this.way = way;
        t.start();
    }
}
