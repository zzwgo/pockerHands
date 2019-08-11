package com.my;

import java.util.*;
import java.util.stream.Collectors;

public class LevelCal {

    public static PokerLevel caculateLevel(List<Pocker> pockers) {
        if (hasPair(pockers)) {
            return PokerLevel.PAIR;
        }
        return PokerLevel.HIGH_POINT;
    }

    private static boolean hasPair(List<Pocker> pockers) {
        Set<Integer> hashSet = new HashSet<>();
        for (Pocker pocker : pockers) {
            hashSet.add(pocker.getPoint());
        }
        return hashSet.size() != pockers.size();
    }

    public static int handleSameLevel(Player playerA, Player playerB) {
        switch (playerA.getPokerLevel()) {
            case 1:
                return handleSameHighPoint(playerA.getPockers(), playerB.getPockers());
            case 2:
                return handleSamePair(playerA.getPockers(), playerB.getPockers());
        }
        return 0;
    }

    private static int handleSamePair(List<Pocker> pockersA, List<Pocker> pockersB) {
        List<Integer> countListA = pockersA.stream().map(Pocker::getPoint).collect(Collectors.toList());
        List<Integer> countListB = pockersB.stream().map(Pocker::getPoint).collect(Collectors.toList());
        int maxPointA = getMaxCount(countListA);
        int maxPointB = getMaxCount(countListB);
        if (maxPointA == maxPointB) {
            return handleSameHighPoint(pockersA, pockersB);
        }
        return maxPointA > maxPointB ? 1 : 2;
    }

    private static int getMaxCount(List<Integer> countList) {
        HashMap<Integer, Integer> map = getCountTimesMap(countList);
        Collection<Integer> count = map.values();
        int maxCount = Collections.max(count);
        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                maxNumber = entry.getKey() > maxNumber ? entry.getKey() : maxNumber;
            }
        }
        return maxNumber;
    }

    private static HashMap<Integer, Integer> getCountTimesMap(List<Integer> countList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < countList.size(); i++) {
            if (map.containsKey(countList.get(i))) {
                int temp = map.get(countList.get(i));
                map.put(countList.get(i), temp + 1);
            } else {
                map.put(countList.get(i), 1);
            }
        }
        return map;
    }

    private static int handleSameHighPoint(List<Pocker> pockersA, List<Pocker> pockersB) {
        pockersA = getNoRepeatedPockerList(pockersA);
        pockersB = getNoRepeatedPockerList(pockersB);

        int maxPointA = pockersA.stream().mapToInt(Pocker::getPoint).reduce(Integer::max).orElse(0);
        int maxPointB = pockersB.stream().mapToInt(Pocker::getPoint).reduce(Integer::max).orElse(0);

        if (maxPointA == maxPointB) {
            return 3;
        }
        return maxPointA > maxPointB ? 1 : 2;
    }

    private static List<Pocker> getNoRepeatedPockerList(List<Pocker> pockers) {
        HashMap<Integer, Integer> mapA = getCountTimesMap(pockers.stream().map(Pocker::getPoint).collect(Collectors.toList()));
        List<Integer> repeatPointsA = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            if (entry.getValue() > 1 && !repeatPointsA.contains(entry.getKey())) {
                repeatPointsA.add(entry.getKey());
            }
        }
        for (int point : repeatPointsA) {
            pockers = pockers.stream().filter(item -> item.getPoint() != point).collect(Collectors.toList());
        }
        return pockers;
    }
}
