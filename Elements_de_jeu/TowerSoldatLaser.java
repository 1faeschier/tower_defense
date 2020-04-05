package Elements_de_jeu;
public class TowerSoldatLaser extends Towers {

    public TowerSoldatLaser(int x, int y, int buildCost, int buildTime, int attackRange, int speedRotation, int attackSpeed,
                            int attackDamage, int level, int upgradeCost, int upgradeTime, int sellCost) {
        super(int x, int y, int buildCost, int buildTime, int attackRange, int speedRotation, int attackSpeed,
        int attackDamage, int level, int upgradeCost, int upgradeTime, int sellCost);
    }

    public void initTurret() {
        loadImage("src/turr.png");
        getImageDimensions();
    }
}
