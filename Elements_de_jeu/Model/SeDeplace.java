package Model;

public interface SeDeplace {
    Position getPosition();
    void move(double dx, double dy);
    void update();
    void rotate(int i);
}