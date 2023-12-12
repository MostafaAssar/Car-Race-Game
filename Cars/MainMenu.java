package Cars;

import javax.media.opengl.GL;
import javax.swing.*;

import static Cars.Variables.indexImg;

public class MainMenu implements Variables {
   static int Page = 13;
    boolean play = false;
    static boolean isEasy;
    static boolean isMulti;
    static String username;
    static String username1;
    static String username2;
    AllCars allCars=new AllCars();
    static int gameMode = 0; //1 for easy, 2 for hard, 3 for multi

    public void DrawMainMenu(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[Page]);    // Turn Blending On

        gl.glPushMatrix();
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

    public void positions(int X, int Y) {
        if ((X >= 25 && X <= 318) && (Y >= 410 && Y <= 517) && Page == 13)//play button
        {
            Page = 15;
            username= JOptionPane.showInputDialog("Enter user name");
        } else if ((X >= 298 && X <= 685) && (Y >= 310 && Y <= 419) && Page == 15)//easy button
        {
            play = true;
            isEasy = true;
            gameMode = 1;
        } else if ((X >= 0 && X <= 107) && (Y >= 0 && Y <= 105) && Page == 16) {
            Page = 13;
        }//back multiplayer
        else if ((X >= 0 && X <= 107) && (Y >= 0 && Y <= 105) && Page == 15) {
            Page = 13;
        }//back play
        else if ((X >= 75 && X <= 370) && (Y >= 540 && Y <= 645) && Page == 13)//Multiplayer button
        {
            Page = 16;//
        } else if ((X >= 0 && X <= 107) && (Y >= 0 && Y <= 105) && Page == 14)//back button
        {
            Page = 13;
        } else if ((X >= 122 && X <= 411) && (Y >= 665 && Y <= 771)&&Page==13) {
            Page = 14;
        }//how to play

        else if ((X >= 171 && X <= 465) && (Y >= 790 && Y <= 898) && Page == 13)//exit button
        {
            System.exit(0);
        }else if ((X >= 298 && X <= 685) && (Y >= 497 && Y <= 610) && Page == 15)//hard button
        {
            isEasy = false;
            play = true;
            gameMode = 2;
        }else if ((X >= 297 && X <= 682) && (Y >= 498 && Y <= 607)&& Page==16) {
            username1= JOptionPane.showInputDialog("Enter user 1 name ");
            username2= JOptionPane.showInputDialog("Enter user 2 name ");
            isMulti = true;
            play = true;
            gameMode = 3;
            Page=22;
        }//vs player2
        if (X>=386&&X<=595&&Y>=341&&Y<=422&&Page==17){
            //resume
            CarsGLEventListener.flagPause = false;
            Page=15;
        }
        if (X>=859&&X<=930&&Y>=13&&Y<=81&&(Page==15||Page==16)){
            //icon
            CarsGLEventListener.flagPause=true;
            Page=17;
        }
        if (X>=388&&X<=598&&Y>=513&&Y<=601&&Page==17){
            //pause menu back to menu
            play=false;
            CarsGLEventListener.flagPause = false;
            gameMode = 0;
            Accident.xCarMain = 54;
            Accident.yCarMain = 5;
            AllCars.reset();
            Time.time = 0;
            Score.score = 0;
            Page=13;
        }
        if (X>=368&&X<=602&&Y>=653&&Y<=736&&Page==20){
            //main menu button when you lose
            play=false;
            gameMode = 0;
            Accident.xCarMain = 54;
            Accident.yCarMain = 5;
            AllCars.reset();
            Time.time = 0;
            Score.score = 0;
            Time.scoreString="";
            Page=13;

        }
        if (X>=368&&X<=602&&Y>=653&&Y<=736&&Page==23){
            //main menu button when you win
            play=false;
            gameMode = 0;
            Accident.xCarMain = 54;
            Accident.yCarMain = 5;
            AllCars.reset();
            Time.time = 0;
            Score.score = 0;
            Time.scoreString="";
            Page=13;

        }else if ((X >= 298 && X <= 685) && (Y >= 311 && Y <= 420)&& Page==16) {
            play=true;
              gameMode=4;
        }//vs ai
    }
}
