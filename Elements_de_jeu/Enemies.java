package Elements_de_jeu;


public class Enemies implements ShootingObserver{

    private int speed;
    private int attackResistance; //résistance aux tirs
    private int health; //vie
    private int scoreValue;
    private boolean dead;


    public void looseHealth(int amount) {
        if (health > 0) {
            health -= amount;
        }
    }
}
