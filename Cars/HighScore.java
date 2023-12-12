package Cars;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import java.io.*;

public class HighScore implements Variables {
    BufferedWriter writer;
    BufferedReader reader;
    GLUT glut = new GLUT();
    int high;
    public void writeHighScore(int score) {

            try {
                writer = new BufferedWriter(new FileWriter("highscore.txt"));
                writer.write(score + "");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public void readeHighScore(){
        try {
            reader = new BufferedReader(new FileReader("highscore.txt"));
            high = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void drawHighScore(GL gl, double x, double y) {

        gl.glRasterPos2f((float) x, (float) y);
        readeHighScore();
        String highString = "highest : " + high;
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, highString);
    }

}
