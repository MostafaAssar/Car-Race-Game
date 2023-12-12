package Cars;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import java.util.Timer;
import java.util.TimerTask;


public class Time{


    static String scoreString ="";
    static String endTime = "";
    static int time=0;
    static GLUT glut = new GLUT();
    static public void drawTime(GL gl,float xTime, float yTime) {

        gl.glRasterPos2f(xTime, yTime);


         scoreString = "Time: " + getTime(time/10);
        time++;
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18,scoreString);


    }
    public void drawendTime(GL gl,float xTime, float yTime,String x) {

        gl.glRasterPos2f(xTime, yTime);


        scoreString = "Time: " + getTime(time/10);
        time++;
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18,x);


    }

    Timer timer=new Timer();

    TimerTask task=new TimerTask() {
        @Override
        public void run() {
        }

    };
    public void runTime (){
        timer.schedule(task,0,1000);
    }
    public static String getTime(int sec){
        int mintes=0;
        int seconds=0;
        if (sec>=60){
            mintes=sec/60;
            seconds=sec%60;
        }
        else if (sec<60){
            seconds=sec;
        }
        String stMins;
        String stSecs;
        if (seconds<10) stSecs="0"+Integer.toString(seconds);
        else  stSecs=Integer.toString(seconds);
        if (mintes<10)
            stMins="0"+Integer.toString(mintes);
        else stMins=Integer.toString(mintes);
        String time=stMins+":"+stSecs;
        return time;
    }
}
