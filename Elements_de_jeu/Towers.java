package Elements_de_jeu;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Towers extends Entities implements Runnable, Shooting {
    private Position position = new Position(500, 130);
    private int attackRange = 100;
    private int attackDamage = 5;
    private int attackSpeed = 100;
    private Thread t;
    private int buildCost;
    private int buildTime;
    private int speedRotation;
    private int level;
    private int upgradeCost;
    private int upgradeTime;
    private int sellCost;
    private Ennemie ennemie;

    public void Towers(int buildCost, int buildTime, int attackRange, int speedRotation, int attackSpeed, int attackDamage, int level, int upgradeCost, int upgradeTime, int sellCost){
        this.buildCost = buildCost;
        this.buildTime = buildTime;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.speedRotation = speedRotation;
        this.attackDamage = attackDamage;
        this.level = level;
        this.upgradeCost = upgradeCost;
        this.upgradeTime = upgradeTime;
        this.sellCost = sellCost;
        t = new Thread(this);
        t.start();
    }


    public void shoot(float x, float y){
    }
}

    public int getattackDamage() {
        return attackDamage;
    }

    public int getBuildCost() {
        return buildCost;
    }

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

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
package Elements_de_jeu;
import javafx.scene.image.Image;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Towers extends Entities implements Shooting {
    private int buildCost;
    private int buildTime;
    private int attackRange;
    private int speedRotation;
    private int attackSpeed;
    private int attackDamage;
    private int level;
    private int upgradeCost;
    private int upgradeTime;
    private int sellCost;


    public Towers(int buildCost, int buildTime, int attackRange, int speedRotation, int attackSpeed,
                  int attackDamage, int level, int upgradeCost, int upgradeTime, int sellCost, int id,
                  String description, int height, int width, Image image){
        super(id, description, image, height, width);
        this.buildCost = buildCost;
        this.buildTime = buildTime;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.speedRotation = speedRotation;
        this.attackSpeed = attackSpeed;
        this.attackDamage = attackDamage;
        this.level = level;
        this.upgradeCost = upgradeCost;
        this.upgradeTime = upgradeTime;
        this.sellCost = sellCost;
        initTurret();
    }

    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<Position> positions = new ArrayList<Position>();

    public void shoot(float x, float y){
    }
}

    public int getattackDamage() {
        return attackDamage;
    }

    public int getBuildCost() {
        return buildCost;
    }

    public void upgrade(int score) {
        if (upgradeCost <= score) {
            if (MouseEvent ==) {
                score -= upgradeCost;
                upgradeCost += 20;
                attackDamage += 20;
                sellCost += 20;
                attackRange += 10;
                attackSpeed += 5;
                upgradeTime += 50;
                sellCost += 20;
                level = level + 1;
            } else if {
                return ("Tu n'as pas les fonds nécessaires, retourne shooter des méchants")
            }
        }
    }
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void initTurret() {
        loadImage("src/turr.png");
        getImageDimensions();
    }


    public void addPosition(Position p){
        positions.add(p);
    }

    public ArrayList<Position> getPositionsList(){
        return positions;
    }
}

    public void initTurret() {
        loadImage("src/turr.png");
        getImageDimensions();
    }
        @Override
    public void run() {
            while (position.distance(position, ennemie.getPosition()) < attackRange){
                ennemie.looseHealth(attackDamage);
                try {
                    Thread.sleep(attackSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
