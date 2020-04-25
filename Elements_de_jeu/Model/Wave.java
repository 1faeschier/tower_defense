package Model;
import java.util.ArrayList;

public class Wave {
    private ArrayList<Ennemie> wave = new ArrayList<>();
    Position positioninit = new Position(1000,105);
    private int niveau;


    public ArrayList<Ennemie> getWave(){return wave;}


    public ArrayList start(int niveau){
        this.niveau = niveau;
        for (int i = 1; i <= niveau; i++) {
            wave.add(new E_Jedi(positioninit.changeposx(positioninit.getX()+i*((int)(Math.random()*50+40)))));
        }
        if (niveau > 1) {
            for (int i = 1; i <= niveau; i += 2) {
                wave.add(new E_Machines(positioninit.changeposx(positioninit.getX() + i * ((int) (Math.random() * 50)))));
            }
        }
        return wave;
    }
}
