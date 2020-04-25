package Model;

import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Position {
    private double x;
    private double y;
    private double radius;
    private double angle;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
        //this.angle = angle;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Position changeposx(double x){
        this.x = x;
        Position p = new Position(x, y);
        return p;
    }
    public Position changeposy(double y){
        this.y = y;
        Position p = new Position(x, y);
        return p;
    }

    public double distance(Position P2){
        double P1X = x; double P2X = P2.getX(); double P1Y = y; double P2Y = P2.getY();
        return Math.sqrt(Math.pow(P1X-P2X, 2.0)+Math.pow(P1Y-P2Y, 2.0));
    }

    public boolean isonWay(Way way, int map){
        Boolean res = false;
        ArrayList<Line> waylist = way.getWay(map);
        for( Line l : waylist){
            if(l.getStartX()==l.getEndX()){
                if(x+10 == l.getEndX()){
                    res = true;
                }
            }
            else {
                double m = (l.getStartY()-l.getEndY())/(l.getStartX()-l.getEndX());
                double p = l.getStartY()-m*l.getStartX();
                if(y+10 == m*(x) + p){
                    res = true;
                }
            }
        }
        return res;
    }

    public double getAngle(Position position) {
        //prend comme argument la position d'un ennemie et renvois l'angle entre la droite le reliant à l'ennemie et la verticale en argument en degré
        double res;
        if (y > position.getY()){
            double deltax = (x-position.getX()); double deltay = (y-position.getY());
            res = (Math.atan(deltax/deltay)/Math.PI) * 180;
        }
        else {
            double deltax = (x-position.getX()); double deltay = (y-position.getY());
            res = (Math.atan(deltax/deltay)/Math.PI) * 180 - 180;
        }
        return -res;
    }
}

//    public void getBounds(){
//        return new Circle(x, y, double radius);
//    }
    //public Rotate rotate(double angle){
    //    rotate().setAngle(double angle);
    //    rotate().setPivotX(double x);
    //    rotate().setPivotY(double y);
    //}

