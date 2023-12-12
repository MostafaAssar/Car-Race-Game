package Cars;

import Texture.TextureReader;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.BitSet;
import com.sun.opengl.util.GLUT;
import javax.swing.JOptionPane;


public class CarsGLEventListener  extends  CarsListener implements Variables, MouseListener {
    GLUT glut = new GLUT();
    int y = 100;

    static boolean ChangeLane=false;
    static boolean ChangeLane1=false;
    static int CL=0;
    static int CL1=0;
    MainMenu menus = new MainMenu();
    Easy easy = new Easy();
    Hard hard = new Hard();
    Multi multi = new Multi();
    Pause pause=new Pause();
    static boolean flagPause = false;
    static SoundPlayer GameSound = new SoundPlayer();
    static SoundPlayer AccidentSound  = new SoundPlayer();
    AI ai = new AI();


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(imgs.length, indexImg, 0);
        GameSound.loadSound("alex-productions-get-going.wav");
        GameSound.MainMusic();
        for(int i = 0; i < imgs.length; i++){
            try {
                gameTexture[i] = TextureReader.readTexture(assetsFolderName + "//" + imgs[i] , true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[i]);
//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        gameTexture[i].getWidth(), gameTexture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        gameTexture[i].getPixels() // Imagedata
                );
            } catch( IOException e ) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        if(!menus.play&&!flagPause) {
            menus.DrawMainMenu(gl);
        }
        else if(!flagPause && MainMenu.gameMode == 1) {
            DrawBackground(gl,y-100);
            DrawBackground(gl,y);
            DrawBackground(gl,y+100);
            pause.DrawPauseMenu(gl,86,90);
            DrawBoard(gl);
            easy.start(gl);
            easy.handleKeyPress();
            if(y>0){
                y-=2;
            }else {
                y=100;
                y-=2;
            }
        }else if(!flagPause && MainMenu.gameMode == 2){
            DrawBackground(gl,y-100);
            DrawBackground(gl,y);
            DrawBackground(gl,y+100);
            pause.DrawPauseMenu(gl,86,90);
            DrawBoard(gl);
            hard.start(gl);
            hard.handleKeyPress();
            if(y>0){
                y-=2;
            }else {
                y=100;
                y-=2;
            }
        } else if (!flagPause && MainMenu.gameMode == 3) {
            DrawBackground(gl,y-100);
            DrawBackground(gl,y);
            DrawBackground(gl,y+100);
            pause.DrawPauseMenu(gl,86,90);
            DrawBoard(gl);
            multi.start(gl);
            multi.handleKeyPress();
            if(y>0){
                y-=2;
            }else {
                y=100;
                y-=2;
            }
            }else if(!flagPause && MainMenu.gameMode == 4) {
            DrawBackground(gl, y - 100);
            DrawBackground(gl, y);
            DrawBackground(gl, y + 100);
            pause.DrawPauseMenu(gl, 86, 90);
            DrawBoard(gl);
            ai.start(gl);
            ai.handleKeyPress();
            if (y > 0) {
                y -= 2;
            } else {
                y = 100;
                y -= 2;
            }
        }
        if(flagPause){
            DrawBackground(gl,y-100);
            DrawBackground(gl,y);
            DrawBackground(gl,y+100);
            pause.DrawPause(gl,45,45);
        }
    }

    public void DrawBackground(GL gl,int y ){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[imgs.length-1]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated( 0, y/(100/2.0) - 0.9, 0);

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

    public void DrawBoard(GL gl){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[imgs.length-2]);    // Turn Blending On

        gl.glPushMatrix();

        // Front Face
        gl.glTranslated( -0.85f, 0.85, 0);
        gl.glScaled(0.15, 0.25, 1);
        gl.glBegin(GL.GL_QUADS);
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



    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x+" "+y);
        menus.positions(x, y);
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }
}
