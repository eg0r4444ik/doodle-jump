
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color SKY_COLOR = new Color(7, 238, 217);
    private static Color NIGHT_SKY_COLOR = new Color(8, 4, 72, 0);
    private static final Color STEP_COLOR = new Color(73, 49, 4);
    private static int JUMP_STEP = 10;
    private static int JUMP_HEIGHT = 400;
    private static Color STR_COLOR = Color.BLUE;
    private static final Random rnd = new Random();

    private Cloud cloud;
    private UFO ufo;
    private Balloon balloon;
    private Rocket rocket;
    private Doodle doodle;
    private ArrayList<Step> steps;
    private ArrayList<Cloud> clouds;
    private Star star;
    private ArrayList<Star> stars;
    private GameOver go;

    private int index;
    private int thirdLevelIndex = 0;
    private int time = 0;
    private Color[] cloudColors;

    private Timer t, doodleTimer, fallTimer, cloudTimer, nightTimer, starsTimer, thirdRoundTimer, stepsTimer;


    public boolean isInStep() {
        for (Step s : steps) {
            if ((doodle.getX() - doodle.getHeight() / 3 > s.getX() && doodle.getX() - doodle.getHeight() / 3 < s.getX() + s.getL()) || (doodle.getX() + doodle.getHeight() / 3 > s.getX() && doodle.getX() + doodle.getHeight() / 3 < s.getX() + s.getL()) || doodle.getY() < s.getY() - doodle.getHeight() - doodle.getLegSize()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInObstacles() {
        if(doodle.getX()>=balloon.getX() && doodle.getX() <= balloon.getX() + balloon.getSize() && doodle.getY()+doodle.getHeight()+doodle.getLegSize() > balloon.getY()){
            return true;
        }
        if(doodle.getX()>=ufo.getX() && doodle.getX() <= ufo.getX() + ufo.getSize()*2 && doodle.getY()+doodle.getHeight()+doodle.getLegSize() > ufo.getY()){
            return true;
        }
        if(doodle.getX()>=rocket.getX() && doodle.getX() <= rocket.getX() + rocket.getSize()*2 && doodle.getY()+doodle.getHeight()+doodle.getLegSize() > rocket.getY()){
            return true;
        }
        return false;
    }

    public DrawPanel() {
        balloon = new Balloon(900, 430, 27, Color.RED, new Color(245, 108, 6, 240), Color.BLACK);
        ufo = new UFO(1300, 450, 30, new Color(224, 214, 52, 240), Color.GREEN, new Color(104, 93, 225), Color.BLACK);
        rocket = new Rocket(1700, 450, 30, Color.GREEN, Color.RED, Color.BLACK);

        stars = new ArrayList<>();
        int starsCount = 40 + rnd.nextInt(50);
        for(int i = 0; i < starsCount; i++){
            star = new Star(rnd.nextInt(1000), rnd.nextInt(400), rnd.nextInt(12), new Color(255, 255, 255, 0));
            stars.add(star);
        }

        cloudColors = new Color[10];
        cloudColors[0] = new Color(245, 245, 245, 255);
        cloudColors[1] = new Color(255, 255, 255, 255);
        cloudColors[2] = new Color(150, 150, 150, 255);
        cloudColors[3] = new Color(175, 175, 175, 255);
        cloudColors[4] = new Color(205, 205, 205, 255);
        cloudColors[5] = new Color(235, 235, 235, 255);
        cloudColors[6] = new Color(115, 115, 115, 255);
        cloudColors[7] = new Color(145, 145, 145, 255);
        cloudColors[8] = new Color(125, 125, 125, 255);
        cloudColors[9] = new Color(215, 215, 215, 255);

        int j = 50;
        index = 0;
        go = new GameOver("You lose", new Color(10,10,10, 100), new Color(10,10,10, 100), getWidth(), getHeight(), time);
        doodle = new Doodle(80, 440, 50,10, Color.YELLOW, Color.GREEN);
        steps = new ArrayList<>();
        clouds = new ArrayList<>();
        while(j < 1000){
            steps.add(new Step(j, 500, 100, STEP_COLOR));
            j+=160;
        }
        cloud = new Cloud(50, 60, 110, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(550, 140, 110, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(400, 40, 60, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(250, 200, 80, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(700, 100, 60, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(850, 150, 100, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);
        cloud = new Cloud(950, 40, 85, cloudColors[rnd.nextInt(10)]);
        clouds.add(cloud);

        stepsTimer = new Timer(100, new AbstractAction() {
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
            }
        });

        thirdRoundTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stepsTimer.stop();
                STR_COLOR = Color.BLUE;
                JUMP_HEIGHT = 300;
                JUMP_STEP = 15;
                if(thirdLevelIndex == 0) {
                    int l = steps.size();
                    for (int i = 0; i < l; i++) {
                        steps.add(new Step(steps.get(i).getX() + 100, 500, 60, STEP_COLOR));
                    }
                    thirdLevelIndex = 1;
                }
                balloon.setX(balloon.getX()-16);
                if(balloon.getX() <= -balloon.getSize()){
                    balloon.setX(balloon.getX() + 1200);
                }
                ufo.setX(ufo.getX()-16);
                if(ufo.getX() <= -ufo.getSize()){
                    ufo.setX(ufo.getX() + 1200);
                }
                rocket.setX(rocket.getX()-16);
                if(rocket.getX() <= -rocket.getSize()){
                    rocket.setX(rocket.getX() + 1200);
                }
                if(isInObstacles()){
                    fallTimer.start();
                    doodleTimer.stop();
                    t.stop();
                }
            }
        });

        cloudTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Cloud c : clouds){
                    c.setX(c.getX()-16);
                    if(c.getX() <= -c.getSize()*2){
                        c.setX(c.getX()+160*6);
                        c.setY(rnd.nextInt(getHeight()/2) + 50);
                        c.setSize(rnd.nextInt(80) + 50);
                        c.setColor(cloudColors[rnd.nextInt(10)]);
                    }
                }
            }
        });

        starsTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Star s : stars){
                    s.setX(s.getX()-16);
                    if(s.getX() <= -s.getR()*2){
                        s.setX(s.getX()+160*6);
                        s.setY(rnd.nextInt(getHeight()/2) + 50);
                        s.setR(rnd.nextInt(12) + 1);
                        s.setColor(cloudColors[rnd.nextInt(10)]);
                    }
                }
            }
        });

        nightTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NIGHT_SKY_COLOR = new Color(8, 4, 72, 255);
                STR_COLOR = Color.WHITE;
                starsTimer.start();
                for(Star s : stars){
                    s.setColor(Color.WHITE);
                }
            }
        });

        t = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                if(time == 150){
                    nightTimer.start();
                    for(Step s : steps){
                        s.setColor(new Color(246, 239, 141, 240));
                    }
                }
                if(time == 300){
                    nightTimer.stop();
                    starsTimer.stop();
                    for(Step s : steps){
                        s.setColor(STEP_COLOR);
                    }
                    NIGHT_SKY_COLOR = new Color(8, 4, 72, 0);
                    for(Star s : stars){
                        s.setColor(new Color(255, 255, 255, 0));
                    }
                    thirdRoundTimer.start();
                }
                repaint();
            }
        });

        doodleTimer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(doodle.getY() > JUMP_HEIGHT && index == 0) {
                    doodle.setY(doodle.getY() - JUMP_STEP);
                } else if(doodle.getY() < 440){
                    index = 1;
                    doodle.setY(doodle.getY() + JUMP_STEP);
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
                cloudTimer.start();
                stepsTimer.start();
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

        for(Cloud c : clouds){
            c.draw(g2d);
        }

        g2d.setColor(NIGHT_SKY_COLOR);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for(Star s : stars){
            s.draw(g2d);
        }

        for (Step step : steps) {
            step.draw(g2d);
        }

        doodle.draw(g2d);

        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(STR_COLOR);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 22));
        g2d.drawString("Ваше время: " + time, 20, 30);

        balloon.draw(g2d);
        ufo.draw(g2d);
        rocket.draw(g2d);

        go.draw(g2d);

    }
}
