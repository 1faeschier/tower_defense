package sample;


public class Tower extends Entities {

    private Position position;


    public Boolean isonTower(Position pos){
        boolean res = false;
        if (position.distance(pos) < 30){
            res = true;
        }
        return res;
    }

}
