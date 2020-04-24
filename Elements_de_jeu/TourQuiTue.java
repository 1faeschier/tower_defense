package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class TourQuiTue extends Tower implements AUneFormeT {

    private Position position;
    public Polygon triangle = new Polygon();
    private double angle;




    @Override
    public Polygon getForme(){
        double val = Math.sqrt(3)/6;
        triangle.getPoints().setAll(
                position.getX(), position.getY(),
                position.getX()-50*Math.sin(((30+angle)/180)*Math.PI), position.getY()+50*Math.cos(((30+angle)/180)*Math.PI),
                position.getX()+50*Math.sin(((30-angle)/180)*Math.PI), position.getY()+50*Math.cos(((30-angle)/180)*Math.PI)
        );
        triangle.setFill(Color.WHITE); triangle.setStroke(Color.BLACK);
        return triangle;
    }

}
