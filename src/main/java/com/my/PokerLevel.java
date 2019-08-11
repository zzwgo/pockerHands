package com.my;

public enum PokerLevel {
    HIGH_POINT(1), PAIR(2), THREE_OF_A_KIND(3), STRAIGHT(4),
    FLUSH(5), FULL_HOUSE(6), FOUR_OF_A_KIND(7), STRAIGHT_FLUSH(8);
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
