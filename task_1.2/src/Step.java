import java.awt.*;

public class Step {

    private int x, y, l;
    private Color color;

    public void draw(Graphics2D g){
        DrawUtils.drawStep(g, x, y, l, color);
    }

    public Step(int x, int y, int l, Color color) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
