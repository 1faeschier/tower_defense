package Model;

import View.Map;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Way extends Map {
    private ArrayList<Line> way1 = addway1();
    private ArrayList<Line> way2 = addway2();

    public ArrayList<Line> getWay(int map) {
        if (map == 1) {
            return way1;
        } else {
            return way2;
        }
    }


    private ArrayList<Line> addway1() {
        ArrayList<Line> way = new ArrayList<>();
        Line l1 = new Line(1500, 110, 110, 110);
        l1.setStroke(Color.BROWN);
        l1.setStrokeWidth(20);
        Line l2 = new Line(110, 110, 110, 560);
        l2.setStroke(Color.BROWN);
        l2.setStrokeWidth(20);
        Line l3 = new Line(110, 560, 1000, 560);
        l3.setStroke(Color.BROWN);
        l3.setStrokeWidth(20);
        way.add(l1); way.add(l2); way.add(l3);
    return way;
    }

    private ArrayList<Line> addway2(){
        ArrayList<Line> way = new ArrayList<>();
        Line l1 = new Line(1000, 110, 0, 110); l1.setStroke(Color.BROWN); l1.setStrokeWidth(20);
        Line l2 = new Line(700, 110, 700, 310); l2.setStroke(Color.BROWN); l2.setStrokeWidth(20);
        Line l3 = new Line(700, 310, 300, 310); l3.setStroke(Color.BROWN); l3.setStrokeWidth(20);
        Line l4 = new Line(300, 310, 300, 110); l4.setStroke(Color.BROWN); l4.setStrokeWidth(20);
        way.add(l1); way.add(l2); way.add(l3); way.add(l4);
        return way;
    }

    public static boolean atTheEnd1(Position position){
        Boolean res = false;
        if(position.getX() >= 950 && position.getY() == 560){
            res = true;
        }
        return res;
    }
    public static boolean atTheEnd2(Position position){
        Boolean res = false;
        if(position.getX() >= 950 && position.getY() == 0){
            res = true;
        }
        return res;
    }



    public boolean isEinde(Position position){
        Boolean res = false;
        if (way1.get(way1.size() - 1).getEndX() == position.getX() && way1.get(way1.size() - 1).getEndY() == position.getY()){
            res = true;
        }
        return res;
    }
}
