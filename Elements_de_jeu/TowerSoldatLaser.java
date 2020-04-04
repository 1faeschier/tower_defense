package Elements_de_jeu;
public class TowerSoldatLaser extends Towers {

    public TowerSoldatLaser(double x, double y) {
        int id = 1;
        damage = 30;
        cost = 20;
        upgradeCost = 10;
        level = 0;
        rotationSpeed = 10;
    }




    public void upgrade(int score) {
        if (upgradeCost <= score) {
            score -= upgradeCost;
            upgradeCost += 20;
            damage += 20;
            sellCost += 20;
            attackRange += 10;
            attackSpeed += 5;
            upgradeTime += 50;
        } else if {
            return ("Tu n'as pas les fonds nécessaires, retourne shooter des méchants")
        }
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getEnx() {
        return Enx;
    }

    public double getEny() {
        return Eny;
    }

    public void fire(float x, float y) {
        if (distance(x, y, getEnx(), getEny()) <= attackRange) {
            rotate( float x, float y, getEnx (), getEny(),int rotationSpeed)
            if (angle == 0) {
                //Tours.Projectile moving from turret towards enemy

            }
        }
    }

    public void distance(float x, float y, getEnx(),getEny())

    {
        return int sqrt ((x - getEnx()) * (x - getEnx()) + (y - getEny()) * (y - getEny()));
    }

}
