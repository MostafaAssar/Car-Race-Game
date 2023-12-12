package Cars;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.BitSet;

public class Multi implements Variables, KeyListener {
    GLUT glut = new GLUT();

    boolean flaglost = false;

    int xCarMain = 54;
    int yCarMain = 5;
    int xSecondCar = 30;
    int ySecondCar = 5;

    AllCars allCars = new AllCars();
    Score score = new Score();
    Time time = new Time();
    Lost lost = new Lost();

    public void start(GL gl){
            if (!flaglost) {
                if (allCars.NumberOfCarsRandom > 0) {
                    for (int i = 0; i < cars.length; i++) accident((int) allCars.cars[i].x, (int) allCars.cars[i].y);
                }
                if(!CarsGLEventListener.ChangeLane){
                    System.out.println("photo1");
                    DrawMainCars(gl, xCarMain, yCarMain, 0);
                }
                if(CarsGLEventListener.ChangeLane)
                {
                    System.out.println("photo2");
                    DrawMainCars(gl, xCarMain, yCarMain, CarsGLEventListener.CL);
                    CarsGLEventListener.CL=0;                }
                if (!CarsGLEventListener.ChangeLane1)
                {
                    DrawSecondCars(gl, xSecondCar, ySecondCar, 19);
                }
                if(CarsGLEventListener.ChangeLane1)
                {
                    DrawSecondCars(gl, xSecondCar, ySecondCar,CarsGLEventListener.CL1);
                    CarsGLEventListener.CL1=19;
                }
                allCars.DrawCarsRandom(gl, score, true);
                time.drawTime(gl,-0.7f,0.9f);

            }
            if (flaglost) {
                MainMenu.Page=20;
                lost.DrawLost(gl);
                time.drawendTime(gl,-0.1f,0.19f,Time.endTime);
                drawusername1(gl);
                drawusername2(gl);
            }

    }

    private void drawusername1(GL gl) {
        gl.glRasterPos2f(-0.1f, 0f);
        String scoreString = "user 1 : " + MainMenu.username1;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }
    private void drawusername2(GL gl) {
        gl.glRasterPos2f(-0.1f, -0.19f);
        String scoreString = "user 2 : " + MainMenu.username2;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }
    public void DrawMainCars(GL gl, double x, double y, int index){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[index]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated( x/(100/2.0) - 0.9, y/(100/2.0) - 0.9, 0);
        gl.glScaled(0.2, 0.2, 1);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);

    }
    public void DrawSecondCars(GL gl,double x, double y, int index){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[index]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated( x/(100/2.0) - 0.9, y/(100/2.0) - 0.9, 0);
        gl.glScaled(0.2, 0.2, 1);

        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);

    }

    public void accident(int xCar, int yCar){
        accident2(xCar,yCar);
        if(((yCar == yCarMain + 17)||(yCar == yCarMain + 16)) && ((xCarMain + 7 >= xCar)) && (xCarMain - 8 <= xCar)){
            flaglost = true;
            System.out.println("done!");
        } else if ((xCar == xCarMain + 6) && ((yCarMain - 15 <= yCar)) && (yCarMain + 16 >= yCar)) {

            flaglost = true;
            System.out.println("done2");
        } else if((xCar == xCarMain - 7) && ((yCarMain - 15 <= yCar)) && (yCarMain + 16 >= yCar)){
            flaglost = true;
            System.out.println("done3");
        } else if ((yCar == yCarMain - 16) && ((xCarMain + 7 >= xCar)) && (xCarMain - 8 <= xCar)) {
            flaglost = true;
            System.out.println("done4");
        }
    }
    public  void  accident2(int xCar,int yCar){
        if(((yCar == ySecondCar + 17)||(yCar == xSecondCar + 16)) && ((xSecondCar + 7 >= xCar)) && (xSecondCar - 8 <= xCar)){
            flaglost = true;
            System.out.println("done!");
        } else if ((xCar == xSecondCar + 6) && ((xSecondCar - 15 <= yCar)) && (ySecondCar + 16 >= yCar)) {

            flaglost = true;

            System.out.println("done2");
        } else if((xCar == xSecondCar - 7) && ((ySecondCar - 15 <= yCar)) && (ySecondCar + 16 >= yCar)){
            flaglost = true;
            System.out.println("done3");
        } else if ((yCar == ySecondCar - 16) && ((xSecondCar + 7 >= xCar)) && (xSecondCar - 8 <= xCar)) {
            flaglost = true;

            System.out.println("done4");
        }
    }

    public BitSet keyBits = new BitSet(256);
    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keyBits.clear(keyCode);
    }

    public void handleKeyPress() {
        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            CarsGLEventListener.ChangeLane=true;
            if (xCarMain > 17) {
                CarsGLEventListener.CL=2;
                xCarMain--;
                Time.endTime = time.scoreString;
                System.out.println(xCarMain);
            }
        }
         if (isKeyPressed(KeyEvent.VK_RIGHT)) {
             CarsGLEventListener.ChangeLane=true;
            if (xCarMain < 75) {
                CarsGLEventListener.CL=1;
                xCarMain++;
                Time.endTime = time.scoreString;
                System.out.printf("right");
            }
        }
         if (isKeyPressed(KeyEvent.VK_DOWN)) {
            if (yCarMain > 3) {
                yCarMain--;
                Time.endTime = time.scoreString;
                System.out.printf("down");
            }
        }
         if (isKeyPressed(KeyEvent.VK_UP)) {
            if (yCarMain < 87) {
                yCarMain++;
                Time.endTime = time.scoreString;
                System.out.printf("up");
            }
        }
        if (isKeyPressed(KeyEvent.VK_A)) {
            CarsGLEventListener.ChangeLane1=true;
            if (xSecondCar > 17) {
                CarsGLEventListener.CL1=22;
                xSecondCar--;
                Time.endTime = time.scoreString;
                System.out.printf("a");
            }
        }
        if (isKeyPressed(KeyEvent.VK_D)) {
            CarsGLEventListener.ChangeLane1=true;
            if (xSecondCar < 75) {
                CarsGLEventListener.CL1=21;
                xSecondCar++;
                Time.endTime = time.scoreString;
                System.out.printf("d");
            }
        }
        if (isKeyPressed(KeyEvent.VK_S)) {
            if (ySecondCar > 3) {
                ySecondCar--;
                Time.endTime = time.scoreString;
                System.out.printf("s");
            }
        }
        if (isKeyPressed(KeyEvent.VK_W)) {
            if (ySecondCar < maxHeight-13) {
                ySecondCar++;
                Time.endTime = time.scoreString;
                System.out.printf("w");
            }
        }

    }



}
