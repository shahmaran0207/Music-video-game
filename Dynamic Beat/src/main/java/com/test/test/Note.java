package com.test.test;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread{

    private Image noteBasicImage=new ImageIcon(Main.class.getResource("/images/noteBasic.png")).getImage();

    private int x, y=580-1000/Main.SLEEP_TIME*Main.NOTE_SPEED;

    private String noteType;

    private boolean proceed=true;

    public boolean isProceed(){
        return proceed;
    }

    public String getNoteType(){
        return noteType;
    }

    public void close(){
        proceed=false;
    }


    public Note(String noteType){
        if(noteType.equals("S")) x=228;
        else if(noteType.equals("D")) x=332;
        else if(noteType.equals("F")) x=436;
        else if(noteType.equals("Space")) x=540;
        else if(noteType.equals("J")) x=744;
        else if(noteType.equals("K")) x=848;
        else if(noteType.equals("L")) x=952;

        this.noteType=noteType;
    }

    public void screenDraw(Graphics2D g){
        if(!noteType.equals("Space")) g.drawImage(noteBasicImage ,x ,y, null);

        else {
            g.drawImage(noteBasicImage ,x, y, null);
            g.drawImage(noteBasicImage ,x+100, y, null);
        }
    }

    public void drop(){
        y+=Main.NOTE_SPEED;
        if(y>620){
            System.out.println("Miss");
            close();
        }
    }

    @Override
    public void run(){
        try{
            while (true){
                drop();
                if(proceed) Thread.sleep(Main.SLEEP_TIME);
                else {
                    interrupt();
                    break;
                }
            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public String judge(){
        if(y>=600) {
            System.out.println("Great");
            close();
            return "Great";
        }
        else if(y>=587) {
            System.out.println("Perfect");
            close();
            return "Perfect";
        }
        else if(y>=573) {
            System.out.println("Great");
            close();
            return "Great";
        }
        else if(y>=535) {
            System.out.println("Early");
            close();
            return "Early";
        }
        return "None";
    }

    public int getY(){
        return y;
    }
}
