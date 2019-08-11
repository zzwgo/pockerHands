package com.my;

import java.util.List;

public class PockerHands {
    public int excute(List<Pocker> player1,List<Pocker> player2){
        return player1.get(0).getPoint()>player2.get(0).getPoint()?1:2;
    }
}
