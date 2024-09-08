package com.test.test;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {

    private Image introbackground;
    private Image screenImage;

    private Graphics screenGraphics;

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창 끄면 프로그램 종료
        setVisible(true);

        // 이미지 경로를 올바르게 로드
        introbackground = new ImageIcon(getClass().getClassLoader().getResource("images/intro2.jpg")).getImage();
    }

    @Override
    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introbackground, 0, 0, null);
        this.repaint();
    }
}
