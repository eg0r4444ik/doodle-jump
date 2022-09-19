import java.awt.*;

public class Rocket {

    private int x, y, size;
    private Color frameColor, wingsColor, circuitColor;

    public Rocket(int x, int y, int size, Color frameColor, Color wingsColor, Color
            circuitColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.frameColor = frameColor;
        this.wingsColor = wingsColor;
        this.circuitColor = circuitColor;
    }

    public void draw(Graphics2D g){
        DrawUtils.drawRocket(g, x, y, size, frameColor, wingsColor, circuitColor);
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

    public Color getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(Color frameColor) {
        this.frameColor = frameColor;
    }

    public Color getWingsColor() {
        return wingsColor;
    }

    public void setWingsColor(Color wingsColor) {
        this.wingsColor = wingsColor;
    }
}
