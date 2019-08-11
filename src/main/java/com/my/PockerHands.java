package com.my;

import java.util.List;
import java.util.stream.Collectors;

public class PockerHands {
    public int excute(List<Pocker> player1, List<Pocker> player2) {
        int maxPointA = normalHighestPoints(player1);
        int maxPointB = normalHighestPoints(player2);
        if(maxPointA==maxPointB){
            return 3;
        }
        return maxPointA>maxPointB?1:2;
    }

    public int normalHighestPoints(List<Pocker> player) {
        return player.stream()
                .mapToInt(Pocker::getPoint)
                .reduce(Integer::max)
                .orElse(0);
    }
}
