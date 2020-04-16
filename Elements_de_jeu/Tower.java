package sample;

import java.awt.*;
import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


public class Tower extends Entities implements Runnable {
    private Position position;
    private int attackRange = 200;
    private int attackDamage = 24;
    private int attackSpeed = 400;
    private Thread t;
    private int buildCost;
    private int buildTime;
    private int speedRotation;
    private int level;
    private int upgradeCost;
    private int upgradeTime;
    private int sellCost;
    public ArrayList<Ennemie> listenemie;
    public Polygon triangle = new Polygon();
    private double angle;
    private Ennemie e = null;


    public Tower(Position position){
        this.position = position;
        t = new Thread(this);
        angle = 0;
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
            res = "amérlioration réalisée avec succès !";
        }
        else {
            res =  "Tu n'as pas les fonds nécessaires, retourne shooter des méchants";
        }
        return res;
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


    public void shoot(float x, float y){
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
                e = ennemie;
                if (position.distance(ennemie.getPosition()) < attackRange) {
                    try {
                        ennemie.looseHealth(attackDamage);
                        //System.out.println(ennemie.getHealth());
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


    public void update() {
        if (e != null){
        angle = position.getAngle(e.getPosition());}

        triangle.getPoints().setAll(
                position.getX(), position.getY(),
                position.getX()-50*Math.sin(((30+angle)/180)*Math.PI), position.getY()+50*Math.cos(((30+angle)/180)*Math.PI),
                position.getX()+50*Math.sin(((30-angle)/180)*Math.PI), position.getY()+50*Math.cos(((30-angle)/180)*Math.PI)
        );
    }
}
