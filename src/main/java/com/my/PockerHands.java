package com.my;

import java.util.List;
import java.util.stream.Collectors;

public class PockerHands {
    public int excute(List<Pocker> pockersA, List<Pocker> pockersB) {
        Player playerA=new Player(pockersA);
        Player playerB=new Player(pockersB);
        if(playerA.getPokerLevel()== playerB.getPokerLevel()){
            return LevelCal.handleSameLevel(playerA,playerB);
        }
        return playerA.getPokerLevel()>playerB.getPokerLevel()?1:2;
    }
}
