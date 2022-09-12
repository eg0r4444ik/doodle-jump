import java.awt.*;

public class DrawUtils {
    public static void drawCloud(Graphics2D g, int x, int y, int size, Color color){
        g.setColor(color);
        g.fillRect(x,y,3*size/2,size/2);
        g.fillOval(x-size/4, y, size/2, size/2);
        g.fillOval(x+5*size/4, y, size/2, size/2);
        g.fillOval(x+size/4, y-size/2, size, size);
    }

    public static void drawStep(Graphics2D g, int x, int y, int l, Color color){
        g.setColor(color);
        g.fillRect(x, y, l, 20);
    }

    public static void drawDoodle(Graphics2D g, int x, int y, int h, int l, Color doodleColor, Color wearColor){
        g.setColor(doodleColor);
        g.fillOval(x - h/3, y, h*2/3, h*2/3);
        g.fillOval(x+ h*2/3 - h/18, y+h/3, h/9, h/9);
        g.setColor(Color.BLACK);
        g.drawOval(x - h/3, y, h*2/3, h*2/3);
        g.drawOval(x+ h*2/3 - h/18, y+h/3, h/9, h/9);
        g.fillOval(x+h/9, y+h*2/9, h/12,h/12);
        g.fillOval(x+h*2/9, y+h*2/9, h/12,h/12);
        g.setColor(doodleColor);
        g.fillRect(x - h/3, y+h/3, h*2/3, h/3);
        g.fillRect(x, y+h/3, h*2/3,h/9);
        g.setColor(wearColor);
        g.fillRect(x - h/3, y+ h*2/3-1, h*2/3, h/3);
        g.setColor(Color.BLACK);
        g.drawLine(x-h/3, y+h/3, x-h/3, y+h*2/3);
        g.drawLine(x+h/3, y + h/3 + h/9, x+h/3, y+h*2/3);
        g.drawLine(x-h/3, y+h*2/3+h/9, x+h/3,y+h*2/3+h/9);
        g.drawLine(x-h/3, y+h*2/3+h*2/9, x+h/3,y+h*2/3+h*2/9);
        g.drawLine(x+h/3, y+h/3, x+ h*2/3, y+h/3);
        g.drawLine(x+h/3, y+h/3+h/9, x+ h*2/3, y+h/3+h/9);
        g.drawRect(x - h/3, y+ h*2/3-1, h*2/3, h/3);
        g.setStroke(new BasicStroke(1));
        g.drawLine(x-h*2/9, y+h-1, x-h*2/9, y+h+l);
        g.drawLine(x-h/9, y+h-1, x-h/9, y+h+l);
        g.drawLine(x+h*2/9, y+h-1, x+h*2/9, y+h+l);
        g.drawLine(x+h/9, y+h-1, x+h/9, y+h+l);
        g.fillOval(x-h*2/9, y+h+l-l/2, l/2, l/2);
        g.fillOval(x-h/9, y+h+l-l/2, l/2, l/2);
        g.fillOval(x+h*2/9, y+h+l-l/2, l/2, l/2);
        g.fillOval(x+h/9, y+h+l-l/2, l/2, l/2);
        g.setColor(Color.BLACK);
        g.drawOval(x+ h*2/3 - h/18, y+h/3, h/9, h/9);
    }

    public static void drawGameOver(Graphics2D g, String str, Color backgroundColor, Color
            inscriptionColor, int h, int w, int time){
        g.setColor(backgroundColor);
        g.fillRect(0, 0, w, h);
        g.setFont(new Font("TimesRoman", Font.BOLD, 22));
        g.setColor(inscriptionColor);
        g.drawString(str  + time, w/3, h/2);
    }
}
