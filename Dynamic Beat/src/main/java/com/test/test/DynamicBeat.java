package com.test.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    private Image selectedImage;
    private Image screenImage;
    private Image titleImage;

    private Image background = new ImageIcon(Main.class.getResource("/images/intro2.jpg")).getImage();

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
    private ImageIcon easyButtonBasicImage=new ImageIcon(Main.class.getResource("/images/easyButtonBasic.png"));
    private ImageIcon easyButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/easyButtonEntered.png"));
    private ImageIcon hardButtonBasicImage=new ImageIcon(Main.class.getResource("/images/hardButtonBasic.png"));
    private ImageIcon hardButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/hardButtonEntered.png"));
    private ImageIcon backButtonBasicImage=new ImageIcon(Main.class.getResource("/images/backButtonBasic.png"));
    private ImageIcon backButtonEnteredImage=new ImageIcon(Main.class.getResource("/images/backButtonEntered.png"));

    private JButton exitButton=new JButton(exitButtonBasicImage);
    private JButton startButton=new JButton(startButtonBasicImage);
    private JButton quitButton=new JButton(quitButtonBasicImage);
    private JButton rightButton=new JButton(rightButtonBasicImage);
    private JButton leftButton=new JButton(leftButtonBasicImage);
    private JButton easyButton=new JButton(easyButtonBasicImage);
    private JButton hardButton=new JButton(hardButtonBasicImage);
    private JButton backButton=new JButton(backButtonBasicImage);

    private int mouseX, mouseY;
    private int nowSelected=0;

    private Graphics screenGraphics;
    
    private boolean isMainScreen=false;
    private boolean isgameScreen=false;

    ArrayList<Track> trackArrayList=new ArrayList<Track>();

    private Music selectedMusic;
    private Music introMusic=new Music("/music/in.mp3", true);

    public static Game game=new Game();

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

        addKeyListener(new KeyListner());

        introMusic.start();

        trackArrayList.add(new Track("title1.png", "sdfsdf.png", "music_is_getting_louder-wallpaper-1280x720.png",
                "/music/flowingair.mp3", "/music/flowingair.mp3"));
        trackArrayList.add(new Track("title2.png", "asd.png", "guitar.jpg",
                "/music/Days-of-joy-843433.mp3", "/music/Days-of-joy-843433.mp3"));

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
                introMusic.close();
                enterMain();
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
                selectLeft();
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
                selectRight();
            }
        });

        add(rightButton);

        easyButton.setVisible(false);
        easyButton.setBounds(375,520,256,256);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "easy");
            }
        });

        add(easyButton);

        hardButton.setVisible(false);
        hardButton.setBounds(655,520,256,256);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "hard");
            }
        });

        add(hardButton);

        backButton.setVisible(false);
        backButton.setBounds(20,50,64,64);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic =new Music("/music/buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e){
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic =new Music("/music/buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                backMain();
            }
        });

        add(backButton);



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
    }

    @Override
    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphics);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(background, 0, 0, null);
        if(isMainScreen){
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 340, 70, null);
        }

        if(isgameScreen) game.scrrenDraw(g);
        paintComponents(g);
        this.repaint();
    }

    public void selectedTrack(int nowSelected){
        if(selectedMusic!=null) selectedMusic.close();
        titleImage = new ImageIcon(Main.class.getResource("/images/"+trackArrayList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("/images/"+trackArrayList.get(nowSelected).getStartimage())).getImage();
        selectedMusic=new Music(trackArrayList.get(nowSelected).getStartMusic(),true);
        selectedMusic.start();
    }

    public void selectLeft(){
        if(nowSelected==0) nowSelected=trackArrayList.size()-1;
        else nowSelected--;
        selectedTrack(nowSelected);
    }

    public void selectRight(){
        if(nowSelected==trackArrayList.size()-1) nowSelected=0;
        else nowSelected++;
        selectedTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty){
        if(selectedMusic != null) selectedMusic.close();
        isMainScreen=false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background=new ImageIcon(Main.class.getResource("/images/"+trackArrayList.get(nowSelected).getGameImage())).getImage();
        backButton.setVisible(true);
        isgameScreen=true;
        setFocusable(true);
    }

    public void backMain(){
        isMainScreen=true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background=new ImageIcon(Main.class.getResource("/images/mainBackground.jpg")).getImage();
        backButton.setVisible(false);
        selectedTrack(nowSelected);
    }

    public void enterMain(){
        startButton.setVisible(false);
        quitButton.setVisible(false);
        background=new ImageIcon(Main.class.getResource("/images/mainBackground.jpg")).getImage();
        isMainScreen=true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectedTrack(0);
    }
}