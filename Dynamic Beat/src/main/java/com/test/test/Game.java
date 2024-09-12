package com.test.test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("/images/gameInfo.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("/images/judgementline.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRoutePressedImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("/images/noteRouteLine.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();

    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
        gameMusic.start();
    }

    public void scrrenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
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
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            note.screenDraw(g);
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);
    }

    public void pressS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano01.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    public void pressSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoutePressed.png")).getImage();
        new Music("/music/FX_piano02.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("/images/noteRoute.png")).getImage();
    }

    @Override
    public void run() {
        dropNote();
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNote() {
        if (difficulty.equals("easy")) {
            // 비트 배열 정의 (노트와 그 타이밍)
            Beat[] beats = {
                    new Beat(1000, "S"),
                    new Beat(2000, "D"),
                    new Beat(3000, "F"),
                    new Beat(4000, "Space"),
                    new Beat(7000, "J"),
                    new Beat(8000, "K"),
                    new Beat(9000, "L"),
            };

            int beatDuration = 9000; // 하나의 비트 패턴의 총 길이 (첫 배열의 마지막 비트 시간)
            int i = 0; // 현재 비트 인덱스
            int repeatCount = 0; // 몇 번째 반복인지 계산

            while (!Thread.currentThread().isInterrupted()) {
                // 반복이 될 때마다 비트들의 시작 시간을 조정해줌
                int adjustedTime = beats[i].getTime() + (repeatCount * beatDuration);

                // 현재 노래의 진행 시간이 조정된 비트 시간에 도달했는지 확인
                if (adjustedTime <= gameMusic.getTime()) {
                    // 새로운 노트를 생성하고 추가
                    Note note = new Note(beats[i].getNoteName());
                    note.start();
                    noteList.add(note);
                    i++; // 다음 비트로 이동

                    // 비트 배열의 끝에 도달하면 다시 처음으로 돌아가서 반복 (반복 횟수 증가)
                    if (i >= beats.length) {
                        i = 0; // 배열이 끝나면 인덱스를 0으로 리셋
                        repeatCount++; // 반복 횟수를 증가시켜 시간 조정
                    }
                }

                // CPU 사용량을 줄이기 위해 짧은 시간 동안 대기
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 인터럽트 처리
                }
            }
        } else if (difficulty.equals("hard")) {
            // 비트 배열 정의 (노트와 그 타이밍)
            Beat[] beats = {
                    new Beat(1000, "S"),
                    new Beat(2000, "D"),
                    new Beat(3000, "F"),
                    new Beat(4000, "Space"),
                    new Beat(7000, "J"),
                    new Beat(8000, "K"),
                    new Beat(9000, "L"),
            };

            int beatDuration = 9000; // 하나의 비트 패턴의 총 길이 (첫 배열의 마지막 비트 시간)
            int i = 0; // 현재 비트 인덱스
            int repeatCount = 0; // 몇 번째 반복인지 계산

            while (!Thread.currentThread().isInterrupted()) {
                // 반복이 될 때마다 비트들의 시작 시간을 조정해줌
                int adjustedTime = beats[i].getTime() + (repeatCount * beatDuration);

                // 현재 노래의 진행 시간이 조정된 비트 시간에 도달했는지 확인
                if (adjustedTime <= gameMusic.getTime()) {
                    // 새로운 노트를 생성하고 추가
                    Note note = new Note(beats[i].getNoteName());
                    note.start();
                    noteList.add(note);
                    i++; // 다음 비트로 이동

                    // 비트 배열의 끝에 도달하면 다시 처음으로 돌아가서 반복 (반복 횟수 증가)
                    if (i >= beats.length) {
                        i = 0; // 배열이 끝나면 인덱스를 0으로 리셋
                        repeatCount++; // 반복 횟수를 증가시켜 시간 조정
                    }
                }

                // CPU 사용량을 줄이기 위해 짧은 시간 동안 대기
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 인터럽트 처리
                }
            }
        }

    }
}
