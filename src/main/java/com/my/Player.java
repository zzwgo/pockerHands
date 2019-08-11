package com.my;

import java.util.List;

public class Player {
    private List<Pocker> pockers;
    private PokerLevel pokerLevel;

    public Player(List<Pocker> pockers) {
        this.pockers = pockers;
        this.pokerLevel=LevelCal.caculateLevel(pockers);
    }

    public List<Pocker> getPockers() {
        return pockers;
    }

    public int getPokerLevel() {
        return pokerLevel.getLevel();
    }
}
