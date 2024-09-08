package com.test.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DynamicBeat extends JFrame {

    private Image introbackground = new ImageIcon(Main.class.getResource("/images/intro2.jpg")).getImage();
    private JLabel menubar=new JLabel(new ImageIcon(Main.class.getResource("/images/menubar.png")));

    private ImageIcon exitButtonBasicImage=new ImageIcon(Main.class.getResource("/images/exitButtonBasic.png"));
    private ImageIcon exitButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/exitButtonEntered.png"));

    private JButton exitButton=new JButton(exitButtonBasicImage);

    private int mouseX, mouseY;

    private Image screenImage;

    private Graphics screenGraphics;

    public DynamicBeat(){
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창 끄면 프로그램 종료
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        exitButton.setBounds(1245,0,30,30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try{
                    Thread.sleep(1000);
                } catch (Exception err){
                    System.out.println(err.getMessage());
                }
                System.exit(0);
            }
        });

        add(exitButton);

        menubar.setBounds(0,0,1280,30);
        menubar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                mouseX=e.getX();
                mouseY=e.getY();
            }
        });
        menubar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                int x=e.getXOnScreen();
                int y=e.getYOnScreen();
                setLocation(x-mouseX, y-mouseY);
            }
        });
        add(menubar);



        Music introMusic=new Music("/music/in.mp3", true);
        introMusic.start();
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
        paintComponents(g);
        this.repaint();
    }
}