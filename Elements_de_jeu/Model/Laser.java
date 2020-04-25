package Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Laser {

    private Line laser;


    public Line dessineToi(double x, double y, double xx, double yy) {

        laser.setStroke(Color.RED);
        laser.setStartX(x);
        laser.setStartY(y);
        laser.setEndX(xx);
        laser.setEndY(yy);
        return laser;
    }

    public Line getLaser() {
        return laser;
    }
}

