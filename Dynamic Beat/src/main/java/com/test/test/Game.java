package com.test.test;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread{
    private Image gameInfoImage=new ImageIcon(Main.class.getResource("/images/gameInfo.png")).getImage();
    private Image judgementLineImage=new ImageIcon(Main.class.getResource("/images/judgementline.png")).getImage();
    private Image noteRouteImage=new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteBasicImage=new ImageIcon(Main.class.getResource("/images/noteBasic.png")).getImage();
    private Image noteRouteLineImage=new ImageIcon(Main.class.getResource("/images/noteRouteLine.png")).getImage();

    public void scrrenDraw(Graphics2D g){
        g.drawImage(noteRouteImage, 228, 30, null);
        g.drawImage(noteRouteImage, 332, 30, null);
        g.drawImage(noteRouteImage, 436, 30, null);
        g.drawImage(noteRouteImage, 540, 30, null);
        g.drawImage(noteRouteImage, 640, 30, null);
        g.drawImage(noteRouteImage, 744, 30, null);
        g.drawImage(noteRouteImage, 848, 30, null);
        g.drawImage(noteRouteImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        g.drawImage(noteRouteBasicImage, 228, 120, null);
        g.drawImage(noteRouteBasicImage, 332, 580, null);
        g.drawImage(noteRouteBasicImage, 436, 500, null);
        g.drawImage(noteRouteBasicImage, 540, 340, null);
        g.drawImage(noteRouteBasicImage, 640, 340, null);
        g.drawImage(noteRouteBasicImage, 744, 325, null);
        g.drawImage(noteRouteBasicImage, 848, 305, null);
        g.drawImage(noteRouteBasicImage, 952, 305, null);
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Music 1", 20, 702);
        g.drawString("Easy", 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space Bar", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);
    }

    @Override
    public void run(){

    }
}
