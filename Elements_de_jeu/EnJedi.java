package Elements_de_jeu;
import Tours.Enemies;

public class EnJedi implements Enemies {
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int health; //vie
    private int speed;//vitesse du perso


    public EnSpeeder(int health, int speed, String description){
        this.power = 50;
        this.health = 60;
        this.speed = 30;
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public int getPower(){
        return power;
    }

    public String getDescription{
        return description;
    }

    public void looseHealth(int amount) {
        if (health > 0) {
            health -= amount;
        }
    }

        public void move(){...}
}
