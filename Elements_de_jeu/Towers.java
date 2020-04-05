package Elements_de_jeu;
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
    private ArrayList<Projectile> projectiles;

    public Towers(int x, int y, int buildCost, int buildTime, int attackRange, int speedRotation, int attackSpeed,
                  int attackDamage, int level, int upgradeCost, int upgradeTime, int sellCost){
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
        projectiles = new ArrayList<Projectile>();
        initTurret();
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
}
