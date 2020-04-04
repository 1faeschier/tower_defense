import Tours.Enemies;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
package Elements_de_jeu;

public class EnSpeeder implements Enemies {
    private int id; //=matricule
    private int power; //résistance aux tirs
    private String description; //pour le différencier à l'écran
    private int health; //vie de départ
    private int speed;//vitesse du perso
    private Image image;
    private ImageView imageView;


    public EnSpeeder(int health, int speed, String description){
        this.power = 30;
        this.health = 30;
        this.speed = 60;
        this.description = description;
        Image image = new Image(description);
        ImageView imageView = new ImageView(image);
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

    public Image getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isDead() {
        return health == 0;
    } //retourne vrai si le speeder est mort, sinon retourne faux

    public void move(){...}
}
