import java.awt.*;

public class Doodle {
    private int x, y, height, legSize;
    private Color doodleColor, wearColor;

    public Doodle(int x, int y, int height, int legSize, Color doodleColor, Color wearColor) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.legSize = legSize;
        this.doodleColor = doodleColor;
        this.wearColor = wearColor;
    }

    public void draw(Graphics2D g){
        DrawUtils.drawDoodle(g, x, y, height, legSize, doodleColor, wearColor);
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getDoodleColor() {
        return doodleColor;
    }

    public void setDoodleColor(Color doodleColor) {
        this.doodleColor = doodleColor;
    }

    public Color getWearColor() {
        return wearColor;
    }

    public void setWearColor(Color wearColor) {
        this.wearColor = wearColor;
    }

    public int getLegSize() {
        return legSize;
    }

    public void setLegSize(int legSize) {
        this.legSize = legSize;
    }
}
