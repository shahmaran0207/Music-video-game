package dynamic_beat_1;

import javax.swing.*;

public class DynamicBeat extends JFrame {

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 끄면 프로그램 꺼지게 하는 것
        setVisible(true);
    }
}
