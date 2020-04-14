package sample;

import java.awt.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import java.util.ArrayList;



public class Tower implements Runnable {
    private Position position;
    private int attackRange = 200;
    private int attackDamage = 15;
    private int attackSpeed = 100;
    private Thread t;
    private int buildCost;
    private int buildTime;
    private int speedRotation;
    private int level;
    private int upgradeCost;
    private int upgradeTime;
    private int sellCost;
    public ArrayList<Ennemie> listenemie;


    public Tower(Position position){
        this.position = position;
        t = new Thread(this);
    }

    public Position getPosition(){ return position; }

    public String upgrade(int score){
        String res = "";
        if (upgradeCost <= score){
            score -= upgradeCost;
            upgradeCost += 20;
            attackDamage += 20;
            sellCost += 20;
            attackRange += 10;
            attackSpeed += 5;
            upgradeTime += 50;
            res = "amérlioratioin réalisé avec succès !";
        }
        else {
            res =  "Tu n'as pas les fonds nécessaires, retourne shooter des méchants";
        }
        return res;
    }

    public Rectangle getForme(){
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(50); rectangle.setWidth(50); rectangle.setFill(Color.WHITE); rectangle.setStroke(Color.BLACK);
        rectangle.setX(position.getX()); rectangle.setY(position.getY());
        return rectangle;
    }

    @Override
    public void run() {
        for (Ennemie ennemie : listenemie) {
            while (position.distance(ennemie.getPosition()) > attackRange){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (ennemie.getHealth() > 0 && position.distance(ennemie.getPosition()) < attackRange) {
                if (position.distance(ennemie.getPosition()) < attackRange) {
                    try {
                        ennemie.looseHealth(attackDamage);
                        System.out.println(ennemie.getHealth());
                        Thread.sleep(attackSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(attackSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void start(ArrayList<Ennemie> list) {
        listenemie = list;
        t.start();
    }
}
