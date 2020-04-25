package View;

import Model.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Map extends Application implements Iterable<Ennemie> {
    public static int conteur = 0;
    static ArrayList<Ennemie>listenemie = new ArrayList<>();
    static ArrayList<Defence>listdefence = new ArrayList<>();
    Wave wave1 = new Wave();
    public static int gold = 30;
    static int speed = 5;
    static boolean gameOver = false;
    static int height = 34;
    static int width = 50;
    static int cornersize = 20;
    private Timeline timer;
    private int map = 1;
    private Way way;
    public static BorderPane root;
    public boolean posetoursimple = false;
    boolean posetourgele = false;
    boolean upgradetour = false;
    private Defence tower;
    private static int difficulte;
    public static int PV = 10;
    public static int wavelevel = 1;
    public static boolean waveIsFinished = false;
    public static int play = 0;

    public Map(){
        super();
        timer = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(Ennemie b: listenemie){
                    b.update();
                }
                for(Defence t : listdefence){
                    t.update(listenemie);
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

    }

    public static void waveIsFinished() {
        Wave wave = new Wave();
        wavelevel++;
        listenemie = wave.start(difficulte*wavelevel);
        System.out.println(listenemie.size());
    }

    @Override
    public void start(Stage stage) {
        try {
            Canvas c = makeCanvas();
            GraphicsContext gc = c.getGraphicsContext2D();
            StackPane canvasHolder = new StackPane(c);
            root = new BorderPane(canvasHolder);


            new AnimationTimer() {
                long lastTick = 0;

                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }
                    if (now - lastTick > 1000000000 / speed) {
                        lastTick = now;
                        tick(gc);
                    }
                }
            }.start();

            menuStart();
            way = new Way();
            for (Line line : way.getWay(map)){
                root.getChildren().add(line);
            }
            listenemie = wave1.start(1);
            for (Ennemie e : listenemie){
                root.getChildren().add(e.getForme());
            }
            Tower tower = new Tower(new Position(500, 150), listenemie);
            listdefence.add(tower);
            root.getChildren().add(tower.getForme());
            Scene scene = new Scene(root, width * cornersize, height * cornersize);
            stage.setScene(scene);
            stage.setTitle("Tower Defence Game");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Canvas makeCanvas(){
        Canvas c = new Canvas(width * cornersize, height * cornersize);
        c.setOnMousePressed( this::mouseClicked );
        c.setOnMouseDragged(this::mouseClicked);
        //  c.setOnMouseReleased(this::mouseClicked);
        return c;
    }

    private void mouseClicked(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        if (x < 510 && x > 420 && y < 40) {
            start();
        }

        else if (x < 740 && x > 670 && y < 40) {
            pause();
        }

        else if(x < 970 && x > 790 && y < 460 && y > 400) {
            if (waveIsFinished){
                for (Ennemie e : listenemie) {
                    root.getChildren().add(e.getForme());
                    e.start(listenemie, way, map);
                }
                conteur = 0;
                waveIsFinished = false;
                for (Defence t : listdefence){
                    t.setlist(listenemie);
                }
            }
            else {System.out.println("vague pas encore terminée");}
        }


        else if (x < 420 && x > 310 && y > 570) {
            posetoursimple = true;
        }

        else if (x < 720 && x > 610 && y > 570) {
            posetourgele = true;
        }

        else if (x < 130 && x > 10 && upgradetour) {
            System.out.println("yes");
            if (gold > tower.getpriceupgrade()){
                tower.upgrade();
                gold -= tower.getpriceupgrade();
            }
            else{
                System.out.println("pas assez d'argent");
            }
            upgradetour = false;

        }
        else {
            if (posetoursimple) {
                if (gold >= 10) {
                    Tower u = new Tower(mouseClickedtower(mouseEvent), listenemie);
                    u.start(listenemie);
                    listdefence.add(u);
                    root.getChildren().add(u.getForme());
                    gold -= 10;
                }
                else{System.out.println("pas assez d'argent poto :( ");}
                posetoursimple = false;
            }
            else if (posetourgele) {
                if (gold >= 15) {
                    TowerGele u = new TowerGele(mouseClickedtower(mouseEvent));
                    listdefence.add(u);
                    root.getChildren().add(u.getForme());
                    gold -= 15;
                }
                else{System.out.println("pas assez d'argent poto :( ");}
                posetourgele = false;
            }
            for (Defence t : listdefence) {
                if (t.isonTower(new Position(x, y))) {
                    upgradetour = true;
                    System.out.println("ok");
                    tower = t;
                }
            }
        }

    }

    private Position mouseClickedtower(MouseEvent mouseEvent){
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();
        return new Position(x,y);
    }


    public static void tick(GraphicsContext gc){
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("",50));
            gc.fillText("GAME OVER", 100,250);
        }

        gc.setFill(Color.GREEN);
        gc.fillRect(0,0,2000, 2000);

        gc.setFill(Color.WHITE);
        gc.setFont(new Font("",30));
        gc.fillText("gold:" + gold,10,40);

        gc.setFill(Color.WHITE);
        gc.fillText("start", 430, 40);

        gc.setFill(Color.WHITE);
        gc.fillText("Tour Simple", 310, 620 );

        gc.setFill(Color.WHITE);
        gc.fillText("Tour Gele", 610, 620 );

        gc.setFill(Color.WHITE);
        gc.fillText("Wave: " + wavelevel, 790, 500);

        if (play == 0) {
            gc.setFill(Color.WHITE);
            gc.fillText("Pause", 670, 40);
        }
        else{
            gc.setFill(Color.WHITE);
            gc.fillText("Play", 670, 40);
        }

        gc.setFill(Color.WHITE);
        gc.fillText("Next Wave", 790, 450);

        gc.setFill(Color.WHITE);
        gc.fillText("Upgrade", 10, 620);

        gc.setFill(Color.WHITE);
        gc.fillText("PV : " + PV, 310, 40);

    }

    public static void create(){
        launch();
    }

    public void start(){
        for (Defence t : listdefence) {
            t.start(listenemie);
        }
        for (Ennemie e : listenemie){
            e.start(listenemie, way, map);
        }
    }

    @Override
    public Iterator<Ennemie> iterator() {
        return listenemie.iterator();
    }

    private void pause(){
        for (Ennemie e : listenemie){
            e.pause();
        }
        for (Defence t : listdefence){
            t.pause();
        }
        if(play == 1){play = 0;}
        else {play = 1;}
    }

    public void menuStart() {
        System.out.println("Bonjour, l'équipe AN vous souhaite une excellent partie ");
        Scanner in1 = new Scanner(System.in);
        System.out.print("Choisir une carte (1 ou 2) ");
        //String mapstring = in1.nextLine(); map = Integer.parseInt(mapstring);
        map = 1;
        Scanner in2 = new Scanner(System.in);
        System.out.print("choisir une difficulté (1-10) ");
        //String difficulteStr = in2.nextLine(); difficulte = Integer.parseInt(difficulteStr);
        difficulte = 2;
        PV = 10;
        way = new Way();
    }
}
