package Cars;

import javax.media.opengl.GL;
import javax.media.opengl.GLEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

public class AI implements KeyListener, Variables {

    AllCars allCars = new AllCars();
    Accident accident = new Accident();
    Lives lives = new Lives();
    Score score = new Score();
    Time time = new Time();
    Lost lost = new Lost();
    int random = (int) (Math.random()*10);


    public void start(GL gl){
        if (lives.pause) {
            accident.accident(allCars);
            DangerousCar(allCars);
            lives.lives(gl, accident, allCars);
            allCars.DrawMainCars(gl, accident.xCarMain, accident.yCarMain, 0, 1);
            allCars.DrawCarsRandom(gl, score,true);
            time.drawTime(gl, -0.98f, 0.90f);


            score.drawScore(gl);
        }else{
            MainMenu.Page=20;
            lost.DrawLost(gl);
            time.drawendTime(gl, -0.1f, 0.18f, Time.endTime);
            score.drawendScore(gl,-0.2f, -0.01f);
        }
    }
    public void handleKeyPress() {
        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (accident.xCarMain > 17) {
                accident.xCarMain--;
            }
        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (accident.xCarMain < 75) {
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
            System.out.println(allCars.cars[2].isturn);
            if(allCars.cars[0].isturn && allCars.cars[0].y <= accident.yCarMain + 40&&allCars.cars[0].increase<10){
                if(accident.xCarMain>allCars.cars[0].x){
                    allCars.cars[0].x++;
                    allCars.cars[0].increase++;
                    System.out.println(allCars.cars[0].increase);
                }else if(accident.xCarMain<allCars.cars[0].x){
                    allCars.cars[0].x--;
                    allCars.cars[0].increase++;
                }
                if (allCars.cars[0].x >= 70) {
                    allCars.cars[0].isturn= false;
                }if (allCars.cars[0].x <= 18) {
                    allCars.cars[0].isturn = false;
                }
            }

        }
    }


}


