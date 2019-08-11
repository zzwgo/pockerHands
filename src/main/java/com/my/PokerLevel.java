package com.my;

public enum PokerLevel {
    HIGH_POINT(1), PAIR(2), TWO_PAIRS(3), THREE_OF_A_KIND(4), STRAIGHT(5),
    FLUSH(6), FULL_HOUSE(7), FOUR_OF_A_KIND(8), STRAIGHT_FLUSH(9);
    private int level;

    PokerLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
