
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color SKY_COLOR = new Color(7, 238, 217);
    private static final Color STEP_COLOR = new Color(73, 49, 4);
    private static final Random rnd = new Random();

    private Cloud cloud;
    private Doodle doodle;
    private ArrayList<Step> steps;
    private GameOver go;

    private int index;
    private int time = 0;

    private Timer t, doodleTimer, fallTimer;


    public boolean isInStep(){
        for (Step s : steps) {
            if((doodle.getX() - doodle.getHeight()/3 > s.getX() && doodle.getX() - doodle.getHeight()/3 < s.getX()+s.getL()) || (doodle.getX() + doodle.getHeight()/3 > s.getX() && doodle.getX() + doodle.getHeight()/3 < s.getX()+s.getL()) || doodle.getY() < s.getY()-doodle.getHeight()- doodle.getLegSize()){
                return true;
            }
        }
        return false;
    }

    public DrawPanel() {
        int j = 50;
        index = 0;
        go = new GameOver("You lose", new Color(10,10,10, 100), new Color(10,10,10, 100), getWidth(), getHeight(), time);
        doodle = new Doodle(80, 440, 50,10, Color.YELLOW, Color.GREEN);
        steps = new ArrayList<>();
        while(j < 1000){
            steps.add(new Step(j, 500, 100, STEP_COLOR));
            j+=160;
        }
        t = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Step s : steps){
                    s.setX(s.getX()-16);
                    if(s.getX() <= -s.getL()){
                        s.setX(s.getX()+160*6);
                    }
                }
                if(!isInStep()){
                    fallTimer.start();
                    doodleTimer.stop();
                    t.stop();
                }
                time++;
                repaint();
            }
        });
        doodleTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(doodle.getY() > 400 && index == 0) {
                    doodle.setY(doodle.getY() - 10);
                } else if(doodle.getY() < 440){
                    index = 1;
                    doodle.setY(doodle.getY() + 10);
                }
                if(doodle.getY() == 440){
                    index = 0;
                    doodleTimer.stop();
                }
                repaint();
            }
        });

        fallTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(doodle.getY() < getHeight()){
                    doodle.setY(doodle.getY()+20);
                } else{
                    go = new GameOver("Ваш результат : ", Color.RED, Color.BLACK, getWidth(), getHeight(), time);
                    fallTimer.stop();
                }
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                doodleTimer.start();
                t.start();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(SKY_COLOR);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        cloud = new Cloud(50, 60, 110, Color.WHITE);
        cloud.draw(g2d);
        cloud = new Cloud(550, 140, 110, Color.WHITE);
        cloud.draw(g2d);
        cloud = new Cloud(400, 40, 60, Color.WHITE);
        cloud.draw(g2d);
        cloud = new Cloud(250, 200, 80, Color.WHITE);
        cloud.draw(g2d);

        for (Step step : steps) {
            step.draw(g2d);
        }

        doodle.draw(g2d);

        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 22));
        g2d.drawString("Ваше время: " + time, getWidth()/3, getHeight()/2);

        go.draw(g2d);
    }
}
