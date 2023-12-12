package Cars;

import Cars.*;
import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import javax.media.opengl.GLEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;


public class Hard implements KeyListener, Variables {
    GLUT glut = new GLUT();
    int random = (int) (Math.random()*10);
    AllCars allCars = new AllCars();
    Accident accident = new Accident();
    Lives lives = new Lives();
    Score score = new Score();
    Time time = new Time();
    Lost lost = new Lost();
    Won won=new Won();
    HighScore highScore = new HighScore();

    public void start(GL gl){
        if (lives.pause) {
            accident.accident(allCars);
            DangerousCar(allCars);
            lives.lives(gl, accident, allCars);
            if (!CarsGLEventListener.ChangeLane) {
                allCars.DrawMainCars(gl, Accident.xCarMain, Accident.yCarMain, 0, 1);
            }
            if (CarsGLEventListener.ChangeLane)
            {   allCars.DrawMainCars(gl, Accident.xCarMain, Accident.yCarMain, CarsGLEventListener.CL, 1);
                CarsGLEventListener.CL=0;
            }
            allCars.DrawCarsRandom(gl, score,false);
            time.drawTime(gl, -0.98f, 0.90f);
            score.drawScore(gl);
        }else if((!(win.equals(Time.scoreString)))){
            MainMenu.Page=20;
            lost.DrawLost(gl);
            time.drawendTime(gl, -0.1f, 0.18f, Time.endTime);
            score.drawendScore(gl,-0.2f, -0.01f);
            highScore.drawHighScore(gl, -0.00f, -0.01f);
            drawusername(gl);
        }
        if(win.equals(Time.scoreString) ) {
            MainMenu.Page=23;
            lives.pause = false;
            won.DrawWin(gl);
            score.drawendScore(gl,-0.15f, -0.01f);
            highScore.drawHighScore(gl,-0.1f, 0.18f);
            drawusername(gl);
        }
    }
    public void handleKeyPress() {
        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            CarsGLEventListener.ChangeLane=true;
            if (accident.xCarMain > 17) {
                CarsGLEventListener.CL=2;
                accident.xCarMain--;
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            CarsGLEventListener.ChangeLane=true;
            if (accident.xCarMain < 75) {CarsGLEventListener.CL=1;

                accident.xCarMain++;
            }
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (accident.yCarMain > 3) {
                accident.yCarMain--;
            }
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            if (accident.yCarMain < (100-13)) {
                accident.yCarMain++;
            }
        }
    }

    public BitSet keyBits = new BitSet(256);

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    private void drawusername(GL gl) {

        gl.glRasterPos2f(-0.1f, -0.19f);


        String scoreString = "user : " + MainMenu.username;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.clear(keyCode);
    }

    public void DangerousCar(AllCars allCars) {
        if (allCars.NumberOfCarsRandom > 0) {
            if (allCars.cars[2].isturn && allCars.cars[2].y <= accident.yCarMain + 40&&allCars.cars[2].increase<15) {
                if(random%2==0) {
                    allCars.cars[2].x++;
                    allCars.cars[2].increase++;
                }else {
                    allCars.cars[2].x--;
                    allCars.cars[2].increase++;
                }
                if (allCars.cars[2].x >= 70) {
                    allCars.cars[2].isturn = false;
                    random= (int) (Math.random()*10);
                }if (allCars.cars[2].x <= 18) {
                    allCars.cars[2].isturn = false;
                    random=(int) (Math.random()*10);
                }
            }
        }
    }

}