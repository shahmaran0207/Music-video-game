package com.test.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DynamicBeat extends JFrame {

    private Image titleImage = new ImageIcon(Main.class.getResource("/images/title1.png")).getImage();
    private Image background = new ImageIcon(Main.class.getResource("/images/intro2.jpg")).getImage();
    private Image selectedImage = new ImageIcon(Main.class.getResource("/images/image.png")).getImage();
    private JLabel menubar=new JLabel(new ImageIcon(Main.class.getResource("/images/menubar.png")));

    private ImageIcon exitButtonBasicImage=new ImageIcon(Main.class.getResource("/images/exitButtonBasic.png"));
    private ImageIcon exitButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/exitButtonEntered.png"));
    private ImageIcon startButtonBasicImage=new ImageIcon(Main.class.getResource("/images/startButtonBasic.png"));
    private ImageIcon startButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/startButtonEntered.png"));
    private ImageIcon quitButtonBasicImage=new ImageIcon(Main.class.getResource("/images/quitButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/quitButtonEntered.png"));
    private ImageIcon rightButtonBasicImage=new ImageIcon(Main.class.getResource("/images/rightButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/rightButtonEntered.png"));
    private ImageIcon leftButtonBasicImage=new ImageIcon(Main.class.getResource("/images/leftButtonBasic.png"));
    private ImageIcon leftButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/lefttButtonEntered.png"));

    private JButton exitButton=new JButton(exitButtonBasicImage);
    private JButton startButton=new JButton(startButtonBasicImage);
    private JButton quitButton=new JButton(quitButtonBasicImage);
    private JButton rightButton=new JButton(rightButtonBasicImage);
    private JButton leftButton=new JButton(leftButtonBasicImage);

    private int mouseX, mouseY;

    private Image screenImage;

    private Graphics screenGraphics;
    
    private boolean isMainScreen=false;

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

        startButton.setBounds(40,450,400,128);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();

                startButton.setVisible(false);
                quitButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                background=new ImageIcon(Main.class.getResource("/images/mainBackground.jpg")).getImage();
                isMainScreen=true;
            }
        });
        add(startButton);

        quitButton.setBounds(40,530,400,128);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

        add(quitButton);

        leftButton.setVisible(false);
        leftButton.setBounds(140,310,64,64);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //왼쪽 버튼 이벤트
            }
        });

        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080,310,64,64);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //오른쪽 버튼 이벤트
            }
        });

        add(rightButton);



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
        g.drawImage(background, 0, 0, null);
        if(isMainScreen){
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 340, 70, null);
        }
        paintComponents(g);
        this.repaint();
    }
}