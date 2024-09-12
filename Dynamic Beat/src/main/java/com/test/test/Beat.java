package com.test.test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Beat {

    private int time;

    private String noteName;

    public Beat(int time, String noteName){
        super();
        this.time=time;
        this.noteName=noteName;
    }
}
