package com.test.test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListner extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_S)
        else if(e.getKeyCode()==KeyEvent.VK_D)
        else if(e.getKeyCode()==KeyEvent.VK_F)
        else if(e.getKeyCode()==KeyEvent.VK_SPACE)
        else  if(e.getKeyCode()==KeyEvent.VK_J)
        else   if(e.getKeyCode()==KeyEvent.VK_K)
        else  if(e.getKeyCode()==KeyEvent.VK_L)
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_S)
        else if(e.getKeyCode()==KeyEvent.VK_D)
        else if(e.getKeyCode()==KeyEvent.VK_F)
        else if(e.getKeyCode()==KeyEvent.VK_SPACE)
        else  if(e.getKeyCode()==KeyEvent.VK_J)
        else   if(e.getKeyCode()==KeyEvent.VK_K)
        else  if(e.getKeyCode()==KeyEvent.VK_L)
    }
}
