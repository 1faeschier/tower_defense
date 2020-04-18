package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Line;


public class EnSpeeder extends Ennemie implements Runnable {
    private int health = 100; //vie
    private int speed = 8;//vitesse du perso = temps en miliseconde entre deux déplacement de 1 unité
    private Thread t;
    private ArrayList<Ennemie> listenemie;
    private Way way;
    private int map;
    private Random random = new Random();
    int play = 0;  //0 = mode play et 1 == pause


    public Rectangle getForme() {
        r.setHeight(10);
        r.setWidth(40);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.RED);
        r.setStroke(Color.BLACK);
        return r;
    }

    public void looseHealth(int amount) {
        health -= amount;
        if (health <= 0){
            r.setWidth(0);
            r.setHeight(0);
            r.setStroke(Color.BROWN);
            Map.score += 10;
        }
    }


    public EnSpeeder(Position positioninit) {
        super();
        position = positioninit;
        t = new Thread(this);
    }
    public int getHealth() {
        return health;
    }

    public Position getPosition() {
        return position;
    }

    public EnJedi createnew() {
        EnJedi b = new EnJedi(position);
        return b;
    }

    public Rectangle getforme() {
        r.setHeight(20);
        r.setWidth(20);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
        return r;
    }

    public void move(double dx, double dy) {
        position.setX(position.getX(), position.getX() + dx);
        position.setY(position.getY() + dy);
    }

    public void update() {
        r.setX(position.getX());
        r.setY(position.getY());
    }


    @Override
    public void run() {
        ArrayList<Line> waylist = way.getWay(map);
        while (true) {
            if (play == 0) {
                if (map == 1) {
                    while (position.isonWay(way, map) && position.getX() > waylist.get(0).getEndX() - 10 && play == 0) {
                        move(-1, 0);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while (position.isonWay(way, map) && position.getY() < waylist.get(1).getEndY() - 10 && play == 0) {
                        move(0, 1);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    while ((position.isonWay(way, map) && position.getX() < waylist.get(2).getEndX()) && play == 0) {
                        move(1, 0);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (Way.atTheEnd2(position)){
                        r.setWidth(0);
                        r.setHeight(0);
                        r.setStroke(Color.BROWN);
                        Map.HP -= 1;
                    }
                }

                if (map == 2) {
                    if (random.nextBoolean()) {
                        while (position.isonWay(way, map) && position.getX() > 690 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        while (position.isonWay(way, map) && position.getY() < 300 && play == 0) {
                            move(0, 1);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        while (position.isonWay(way, map) && position.getX() > 290 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        while (position.isonWay(way, map) && position.getY() > 100 && play == 0) {
                            move(0, -1);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        while (position.isonWay(way, map) && position.getX() > 0 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (Way.atTheEnd2(position)){
                            r.setWidth(0);
                            r.setHeight(0);
                            r.setStroke(Color.BROWN);
                            Map.HP -= 1;
                        }
                    } else {
                        while (position.isonWay(way, map) && position.getX() > 0 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (health != 0) {
                            if (position.isonWay(way, map) && position.getX() >= 950 && position.getY() == 0 &&
                                    play == 0) {
                                r.setWidth(0);
                                r.setHeight(0);
                                r.setStroke(Color.BROWN);
                                Map.HP -= 1;
                            }
                        } else {
                            if (position.isonWay(way, map) && position.getX() < 20 && play == 0) {
                                Map.score += 0;
                            }
                        }
                    }
                }
            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start(ArrayList<Ennemie> list, Way way, int map) {
        listenemie = list;
        this.way = way;
        t.start();
        this.map = map;
    }

    public void pause(){
        if(play == 1){play = 0;}
        else {play = 1;}
    }
}
