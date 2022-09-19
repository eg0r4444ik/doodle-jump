import java.awt.*;

public class DrawUtils {

    public static void drawUFO(Graphics2D g, int x, int y, int size, Color lightColor, Color frameColor, Color glassColor, Color
            circuitColor){
        g.setColor(lightColor);
        g.fillOval(x - size/2, y+size, size*2, size/2);
        g.setColor(frameColor);
        g.fillOval(x-size/2, y+size/5, size*2, size);
        g.setColor(circuitColor);
        g.setStroke(new BasicStroke(2));
        g.drawOval(x-size/2, y+size/5, size*2, size);
        g.setColor(glassColor);
        g.fillOval(x, y, size, size);
        g.setColor(frameColor);
        g.fillRect(x, y+size*2/3, size, size/2-3);
        g.setColor(glassColor);
        g.fillOval(x, y+size/2, size, size/3);
    }

    public static void drawRocket(Graphics2D g, int x, int y, int size, Color frameColor, Color wingsColor, Color
            circuitColor){
        g.setColor(frameColor);
        g.fillOval(x-size/2, y, size, size/2);
        g.setColor(circuitColor);
        g.drawOval(x-size/2, y, size, size/2);
        g.setColor(frameColor);
        g.fillRect(x, y, size*3/2, size/2);
        g.setColor(circuitColor);
        g.drawRect(x, y, size*3/2, size/2);
        g.setColor(wingsColor);
        g.fillOval(x+size, y+size/4-size/12, size/2,size/6);
        g.fillPolygon(new int[]{x+size, x+size*3/2, x + size*3/2},new int[]{y, y-size/2, y},3);
        g.fillPolygon(new int[]{x+size, x+size*3/2, x + size*3/2},new int[]{y+size/2, y+size, y+size/2},3);
        g.setColor(circuitColor);
        g.drawPolygon(new int[]{x+size, x+size*3/2, x + size*3/2},new int[]{y, y-size/2, y},3);
        g.drawPolygon(new int[]{x+size, x+size*3/2, x + size*3/2},new int[]{y+size/2, y+size, y+size/2},3);
    }

    public static void drawBalloon(Graphics2D g, int x, int y, int size, Color ballColor, Color boxColor, Color circuitColor){
        g.setColor(ballColor);
        g.fillOval(x-size, y-size, 2*size, 2*size);
        g.setColor(boxColor);
        g.fillRect(x-size/2, y+3*size/2, size, size);
        g.setColor(circuitColor);
        g.setStroke(new BasicStroke(2));
        g.drawLine(x - size, y, x - size/2, y + 3*size/2);
        g.drawLine(x + size, y, x + size/2, y + 3*size/2);
        g.drawOval(x-size, y-size, 2*size, 2*size);
        g.drawRect(x-size/2, y+3*size/2, size, size);
    }

    public static void drawStar(Graphics2D g, int x, int y, int r, Color color){
        g.setColor(color);
        int width = 1;
        for(int i = r; i > 0; i--){
            if(i%6 == 0){
                width++;
            }
            g.setStroke(new BasicStroke(width));
            g.drawLine(x+i, y, x+i-1, y);
            g.drawLine(x-i, y, x-i+1, y);
            g.drawLine(x, y+i, x, y+i-1);
            g.drawLine(x, y-i, x, y-i+1);
        }
    }

    public static void drawCloud(Graphics2D g, int x, int y, int size, Color color){
        g.setColor(color);
        g.fillRect(x,y,3*size/2,size/2+1);
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
