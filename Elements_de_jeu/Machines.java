package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.shape.Line;


public class Machines extends Ennemie implements Runnable, aUneForme, aUneVie, seDeplace {
    private int health = 100; //vie
    private int speed = 8;//vitesse du perso = temps en miliseconde entre deux déplacement de 1 unité
    private Thread t;
    private ArrayList<Ennemie> listenemie;
    private Way way;
    private int map;
    private Random random = new Random();
    int play = 0;  //0 = mode play et 1 == pause

    public Machines(Position positioninit) {
        super();
        position = positioninit;
        t = new Thread(this);
    }

    public E_Jedi createnew() {
        E_Jedi b = new E_Jedi(position);
        return b;
    }

    @Override
    public Rectangle getForme() {
        r.setHeight(10);
        r.setWidth(40);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
        return r;
    }

    @Override
    public void looseHealth(int amount) {
        health -= amount;
        if (health <= 0){
            r.setWidth(0);
            r.setHeight(0);
            r.setStroke(Color.BROWN);
            Map.gold += 10;
        }
    }
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Rectangle getforme() {
        r.setHeight(20);
        r.setWidth(20);
        r.setX(position.getX());
        r.setY(position.getY());
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
        return r;
    }

    @Override
    public void move(double dx, double dy) {
        position.setX(position.getX() + dx);
        position.setY(position.getY() + dy);
    }

    @Override
    public void update() {
        r.setX(position.getX());
        r.setY(position.getY());
    }


    @Override
    public void run() {
        ArrayList<Line> waylist = way.getWay(map);
        boolean cond = true;
        while (cond) {
            if (play == 0) {
                if (map == 1) {
                    while (position.getY() < 200 && position.getX() > waylist.get(0).getEndX() - 5 && play == 0) {
                        move(-1, 0);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    rotate(1);
                    while (position.getY() < waylist.get(1).getEndY() - 5 && play == 0) {
                        move(0, 1);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    rotate(2);
                    while ((position.getX() < waylist.get(2).getEndX() + 20) && play == 0) {
                        move(1, 0);
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(health > 0){Map.PV -= 1;}
                    cond = false;
                }

                if (map == 2) {
                    if (random.nextBoolean()) {
                        while (position.getX() > 695 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        rotate(1);
                        while (position.getY() < 305 && play == 0) {
                            move(0, 1);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        rotate(2);
                        while (position.getX() > 295 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        rotate(1);
                        while (position.getY() > 105 && play == 0) {
                            move(0, -1);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        rotate(2);
                        while (position.getX() > -40 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else {
                        while (position.getX() > -40 && play == 0) {
                            move(-1, 0);
                            try {
                                Thread.sleep(speed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if(health > 0){Map.PV -= 1;}
                    cond = false;
                }
            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Map.conteur++;
        if (Map.conteur == Map.wavelevel){Map.waveIsFinished = true; System.out.println("vague n° : " + Map.wavelevel + " terminer");}
    }

    private void rotate(int i) {
        if (i == 1) {
            r.setHeight(40);
            r.setWidth(10);
        }
        else{
            r.setHeight(10);
            r.setWidth(40);
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
