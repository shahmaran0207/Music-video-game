package com.test.test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Track {
    private String titleImage;  //제목 이미지
    private String startimage; //게임 선택창 이미지
    private String gameImage;   //해당 곡 실행 시 표지 이미지
    private String startMusic;  //게임 선택 창 음악
    private String gameMusic;   //해당 곡 실행했을 때 음악
    private String titleName;   //곡 제목

    public Track(String titleImage, String startimage, String gameImage, String startMusic, String gameMusic, String titleName){
        super();
        this.titleImage=titleImage;
        this.startimage=startimage;
        this.gameImage=gameImage;
        this.startMusic=startMusic;
        this.gameMusic=gameMusic;
        this.titleName=titleName;
    }
}
