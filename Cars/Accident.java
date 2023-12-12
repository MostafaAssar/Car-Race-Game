package Cars;

import javax.swing.*;

public class Accident implements Variables {

    static int xCarMain = 54, yCarMain = 5;
    boolean isAccident = false;

    public void accident(AllCars allCars) {
        if (allCars.NumberOfCarsRandom > 0) {
            for (int i = 0; i < allCars.cars.length; i++) {
                collision(allCars.cars[i].x, allCars.cars[i].y);

            }
        }
    }

        public void collision ( double xCar, double yCar){
            CarsGLEventListener.AccidentSound.loadSound("Bomb.wav");
            if (((yCar == yCarMain + 17) || (yCar == yCarMain + 16)) && ((xCarMain + 7 >= xCar)) && (xCarMain - 8 <= xCar)) {
                //JOptionPane.showConfirmDialog(null, "HAHAHA YOU LOST\n" + "Start new game?", "Congrats!", JOptionPane.CLOSED_OPTION);
                System.out.println("done!");
                isAccident = true;
                CarsGLEventListener.AccidentSound.playSound();
            } else if ((xCar == xCarMain + 6) && ((yCarMain - 15 <= yCar)) && (yCarMain + 16 >= yCar)) {

                //JOptionPane.showConfirmDialog(null, "HAHAHA YOU LOST\n" + "Start new game?", "Congrats!", JOptionPane.CLOSED_OPTION);
                System.out.println("done2");
                isAccident = true;
                CarsGLEventListener.AccidentSound.playSound();
            } else if ((xCar == xCarMain - 7) && ((yCarMain - 15 <= yCar)) && (yCarMain + 16 >= yCar)) {
                //JOptionPane.showConfirmDialog(null, "HAHAHA YOU LOST\n" + "Start new game?", "Congrats!", JOptionPane.CLOSED_OPTION);

                System.out.println("done3");
                isAccident = true;
                CarsGLEventListener.AccidentSound.playSound();
            } else if ((yCar == yCarMain - 16) && ((xCarMain + 7 >= xCar)) && (xCarMain - 8 <= xCar)) {
                //JOptionPane.showConfirmDialog(null, "HAHAHA YOU LOST\n" + "Start new game?", "Congrats!", JOptionPane.CLOSED_OPTION);

                System.out.println("done4");
                isAccident = true;
                CarsGLEventListener.AccidentSound.playSound();
            }
        }
    }
