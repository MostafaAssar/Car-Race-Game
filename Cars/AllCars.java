package Cars;

import javax.media.opengl.GL;
import java.util.Arrays;

public class AllCars implements Variables {
    static int NumberOfCarsRandom =0;

    int laneNumber;
    static int beforeLaneNumber;
    static double   yOfCarsRandom=100;
    GenertingCars [] cars = new GenertingCars[4];
    public void DrawMainCars(GL gl,double x, double y, int index,double scale){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, indexImg[index]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated( x/(maxWidth/2.0) - 0.9, y/(maxHeight/2.0) - 0.9, 0);
        gl.glScaled(0.2*scale, 0.2*scale, 1);
        //System.out.println(x +" " + y);
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

    public void DrawCarsRandom(GL gl, Score score,boolean easy){
        if(NumberOfCarsRandom<3){            //The start of the first four cars
            for(int i=0;i<cars.length;i++){
                beforeLaneNumber = laneNumber;
                laneNumber =(int) (Math.random()*4); // select number between 0,3
                if(laneNumber== beforeLaneNumber){
                    cars[i]= new GenertingCars(Lane(laneNumber+1),yOfCarsRandom);}
                else {
                    cars[i]= new GenertingCars(Lane(laneNumber),yOfCarsRandom);}
                NumberOfCarsRandom++;
                yOfCarsRandom+=30;
            }}
        yOfCarsRandom=100; // initial y  again of Cars random
        for(int i=0;i<cars.length;i++){
            if(cars[i].checkY()){      //When any car disappears, replace it
                beforeLaneNumber= laneNumber;
                laneNumber =(int) (Math.random()*4);
                if(laneNumber== beforeLaneNumber){
                    cars[i]= new GenertingCars(Lane(laneNumber+1),yOfCarsRandom);}
                else {
                    cars[i]= new GenertingCars(Lane(laneNumber),yOfCarsRandom);}
                score.score++;
                yOfCarsRandom+=30;
            }
        }
        for(int i=0;i<cars.length;i++){
            DrawMainCars(gl,cars[i].x,cars[i].y,i+6,1); //Draw Cars Random;
            cars[i].decY();
        }
    }

    public double Lane( int laneNumber){
        double x=0;
        if(laneNumber==0||laneNumber==4){
            x=21;
        } if(laneNumber==1){
            x=38;
        } if(laneNumber==2){
            x=53;
        } if(laneNumber==3){
            x=70;
        }
        return x;
    }

    static public void reset(){
        NumberOfCarsRandom = 0;
        yOfCarsRandom = 100;
        beforeLaneNumber = 0;

    }

}


