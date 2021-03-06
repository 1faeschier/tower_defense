package Model;

import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class Defence extends Entities {
    private Position position;
    private int attackRange = 200;
    private int attackDamage = 24;
    private int attackSpeed = 400;
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


    public void setlist(ArrayList<Ennemie> list){
        listenemie = list;
    }
    
    public void update(ArrayList<Ennemie> list) {
    }

    public Boolean isonTower(Position pos){
        boolean res = false;
        if (position.distance(pos) < 30){
            res = true;
        }
        return res;
    }

    public int getprice() {
        return buildCost;
    }

    public void upgrade() {
    }

    public int getpriceupgrade() {
        return upgradeCost;
    }

    public void start(ArrayList<Ennemie> listenemie) {
    }

    public void pause() {
    }
}
