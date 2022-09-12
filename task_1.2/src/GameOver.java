import java.awt.*;

public class GameOver {
    private String str;
    private Color backgroundColor, inscriptionColor;
    private int w,h, time;

    public GameOver(String str, Color backgroundColor, Color inscriptionColor, int w, int h, int time) {
        this.str = str;
        this.backgroundColor = backgroundColor;
        this.inscriptionColor = inscriptionColor;
        this.w = w;
        this.h = h;
        this.time = time;
    }

    public void draw(Graphics2D g){
        DrawUtils.drawGameOver(g, str, backgroundColor, inscriptionColor, h, w, time);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getInscriptionColor() {
        return inscriptionColor;
    }

    public void setInscriptionColor(Color inscriptionColor) {
        this.inscriptionColor = inscriptionColor;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
