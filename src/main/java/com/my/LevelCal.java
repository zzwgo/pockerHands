package com.my;

import java.util.List;

public class LevelCal {

    public static PokerLevel caculateLevel(List<Pocker> pockers) {
        if (hasPair(pockers)) {
            return PokerLevel.PAIR;
        }
        return PokerLevel.HIGH_POINT;
    }
    private static boolean hasPair(List<Pocker> pockers) {
        return false;
    }
    public static int handleSameLevel(Player playerA, Player playerB) {
        switch (playerA.getPokerLevel()) {
            case 1:
                return handleSameHighPoint(playerA.getPockers(), playerB.getPockers());
        }
        return 0;
    }
    private static int handleSameHighPoint(List<Pocker> pockersA, List<Pocker> pockers1B) {
        int maxPointA = pockersA.stream().mapToInt(Pocker::getPoint).reduce(Integer::max).orElse(0);
        int maxPointB = pockers1B.stream().mapToInt(Pocker::getPoint).reduce(Integer::max).orElse(0);
        if (maxPointA == maxPointB) {
            return 3;
        }
        return maxPointA > maxPointB ? 1 : 2;
    }


}
