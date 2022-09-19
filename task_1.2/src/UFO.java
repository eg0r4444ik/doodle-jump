import java.awt.*;

public class UFO {

    private int x, y, size;
    private Color lightColor, frameColor, glassColor,
            circuitColor;

    public UFO(int x, int y, int size, Color lightColor, Color frameColor, Color glassColor, Color circuitColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.lightColor = lightColor;
        this.frameColor = frameColor;
        this.glassColor = glassColor;
        this.circuitColor = circuitColor;
    }

    public void draw(Graphics2D g){
        DrawUtils.drawUFO(g, x, y, size, lightColor, frameColor, glassColor, circuitColor);
    }

    public Color getGlassColor() {
        return glassColor;
    }

    public void setGlassColor(Color glassColor) {
        this.glassColor = glassColor;
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

    public Color getLightColor() {
        return lightColor;
    }

    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }

    public Color getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(Color frameColor) {
        this.frameColor = frameColor;
    }
}
