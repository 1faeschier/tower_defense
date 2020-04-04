package Elements_de_jeu;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public class Position{
    private double x;
    private double y;
    private double radius;
    private double angle;

    public Position(double x, double y, double angle){
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public double getX(){
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
    public void move(double dx, double dy){
        setX(x+dx);
        setY(y+dy);
    }

    public void getBounds(){
        return new Circle(x, y, double radius);
    }

    public Rotate rotate(double angle){
        rotate().setAngle(double angle);
        rotate().setPivotX(double x);
        rotate().setPivotY(double y);
    }
}