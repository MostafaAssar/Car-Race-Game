package Cars;

import javax.media.opengl.GL;
import javax.swing.*;

public class Lives implements Variables {
    int index = 0;
    int live = 3;
    boolean pause = true;

    public void lives(GL gl, Accident accident, AllCars DrawRandomCars){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[livePic[index]]);	// Turn Blending On

        if(accident.isAccident){
            System.out.println(live);
            live--;
            accident.isAccident = false;
            System.out.println("hi");
            DrawRandomCars.reset();
            index++;
        }
        if(live == 0){
            pause = false;
            index = 0;
            Time.endTime = Time.scoreString;
        }

        gl.glPushMatrix();
        gl.glTranslated(-0.85f,  0.78f,0);
        gl.glScaled(0.042,0.042,1);
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
}
