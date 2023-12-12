package Cars;
import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;


public class Score {
    GLUT glut =  new GLUT();
    HighScore highScore = new HighScore();
    static int score = 0;

    public void drawScore(GL gl) {

        gl.glRasterPos2f(-0.95f, 0.85f);
        String scoreString = "Score: " + score;
        glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, scoreString);

    }

    public void drawendScore(GL gl, double x, double y) {

        gl.glRasterPos2f((float) x, (float) y);
        String scoreString = "Score: " + score;
        glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, scoreString);
        highScore.readeHighScore();
        if(highScore.high < score) {
            highScore.writeHighScore(score);
        }
    }

}
