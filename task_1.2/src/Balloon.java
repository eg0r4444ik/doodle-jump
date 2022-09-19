import java.awt.*;

public class Balloon {
    private int x,y,size;
    private Color ballColor, boxColor, circuitColor;

    public void draw(Graphics2D g){
        DrawUtils.drawBalloon(g, x, y, size, ballColor, boxColor, circuitColor);
    }

    public Balloon(int x, int y, int size, Color ballColor, Color boxColor, Color circuitColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.ballColor = ballColor;
        this.boxColor = boxColor;
        this.circuitColor = circuitColor;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public Color getBoxColor() {
        return boxColor;
    }

    public void setBoxColor(Color boxColor) {
        this.boxColor = boxColor;
    }

    public Color getCircuitColor() {
        return circuitColor;
    }

    public void setCircuitColor(Color circuitColor) {
        this.circuitColor = circuitColor;
    }
}
