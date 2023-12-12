package Cars;

import Texture.TextureReader;

public interface Variables {
    int maxWidth = 100;
    int maxHeight = 100;
    int scaleOfStreet =1;
    int[] mainCar = {0, 1, 2, 19};
    int[] cars = {7, 8, 9, 10};
    int[] livePic = {10, 11, 12};
    int[] menuPics = {13, 14, 15, 16,17,18};

    double x = 50, y = 50;

    String win = "Time: 00:40";


    String [] imgs ={"main(1).png","main2.png","main3.png","police(1).png","police(2).png","police(3).png","car(5).png"
            ,"car(1).png","car(2).png","car(3).png","live(1).png","live(2).png","live(3).png","Play(1).png","Play(3).png"
            ,"Play(9).png","Play(8).png","Resume.png","pausemenu.png","car(multi).png","lose.png","car(multi1).png","car(multi2).png","win.png","board.png","background.png"};
    TextureReader.Texture [] gameTexture = new TextureReader.Texture[imgs.length];
    int [] indexImg  =new int[imgs.length];
}
