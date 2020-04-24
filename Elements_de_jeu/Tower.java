package sample;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Tower extends Defence implements Runnable {
    private Position position;
    private int attackRange = 200;
    private int attackDamage = 3;
    private int attackSpeed = 50;
    private Thread t;
    private int buildCost = 10;
    private int buildTime;
    private int speedRotation;
    private int level = 0;
    private int upgradeCost = 10;
    private int upgradeTime;
    private int sellCost;
    public ArrayList<Ennemie> listenemie;
    public Polygon triangle = new Polygon();
    private double angle;
    private Ennemie e = null;
    private int play = 0;  //0 = mode play et 1 == pause
    private boolean bool = true;


    public Tower(Position position, ArrayList<Ennemie> list){
        this.position = position;
        listenemie = list;
        t = new Thread(this);
        angle = 0;
    }

    public Position getPosition(){ return position; }

    public void upgrade(){
        level++;
        upgradeCost += 5;
        attackDamage += 200;
        sellCost += 20;
        attackRange += 10;
        attackSpeed += 5;
        System.out.println("amélioration réalisée avec succès");
        if (level == 1) {
            triangle.setFill(Color.RED);
        }
        else if (level == 2){
            triangle.setFill(Color.BLUE);
        }
        else if (level == 3){
            triangle.setFill(Color.YELLOW);
        }
    }

    public Polygon getForme(){
        double val = Math.sqrt(3)/6;
        triangle.getPoints().setAll(
                position.getX(), position.getY(),
                position.getX()-50*Math.sin(((30+angle)/180)*Math.PI), position.getY()+50*Math.cos(((30+angle)/180)*Math.PI),
                position.getX()+50*Math.sin(((30-angle)/180)*Math.PI), position.getY()+50*Math.cos(((30-angle)/180)*Math.PI)
        );
        triangle.setFill(Color.WHITE); triangle.setStroke(Color.BLACK);
        return triangle;
    }

    public Boolean isonTower(Position pos){
        boolean res = false;
        if (position.distance(pos) < 30){
            res = true;
        }
        return res;
    }

    public void shoot(float x, float y){
    }

    @Override
    public void run() {
        while(true) {
            while (bool) {
                System.out.println("okok");
                for (Ennemie ennemie : listenemie) {
                    if (play == 0) {
                        while (ennemie.getHealth() > 0 && position.distance(ennemie.getPosition()) > attackRange) {
                            try {
                                Thread.sleep(2);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        while (ennemie.getHealth() > 0 && position.distance(ennemie.getPosition()) < attackRange) {
                            e = ennemie;
                            if (position.distance(ennemie.getPosition()) < attackRange) {
                                if (play == 1) {
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    try {
                                        ennemie.looseHealth(attackDamage);
                                        System.out.println(ennemie.getHealth());
                                        Thread.sleep(attackSpeed);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                try {
                                    Thread.sleep(attackSpeed);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                bool = false;
            }
            try {
                Thread.sleep(100);
                System.out.println("a");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start(ArrayList<Ennemie> list) {
        listenemie = list;
        t.start();
    }


    public void update(ArrayList<Ennemie> list) {
        listenemie = list;
        if (e != null) {
            angle = position.getAngle(e.getPosition());

            if (position.distance(e.getPosition()) < attackRange) {
                triangle.getPoints().setAll(
                        position.getX(), position.getY(),
                        position.getX() - 50 * Math.sin(((30 + angle) / 180) * Math.PI), position.getY() + 50 * Math.cos(((30 + angle) / 180) * Math.PI),
                        position.getX() + 50 * Math.sin(((30 - angle) / 180) * Math.PI), position.getY() + 50 * Math.cos(((30 - angle) / 180) * Math.PI)
                );
            }
        }
    }


    public void pause(){
        if(play == 1){play = 0;}
        else {play = 1;}
    }

    public int getpriceupgrade() {
        return upgradeCost;
    }

    public int getprice(){return buildCost;}

    public void setlist(ArrayList<Ennemie> list){
        listenemie = list;
        bool = true;
    }
}
