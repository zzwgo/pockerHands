package com.my;

import java.util.*;
import java.util.stream.Collectors;

public class LevelCal {

    public static PokerLevel caculateLevel(List<Pocker> pockers) {
        if (isStraightFlush(pockers)) {
            return PokerLevel.STRAIGHT_FLUSH;
        } else if (isFourOfKind(pockers)) {
            return PokerLevel.FOUR_OF_A_KIND;
        } else if (isFullHouse(pockers)) {
            return PokerLevel.FULL_HOUSE;
        } else if (isFlush(pockers)) {
            return PokerLevel.FLUSH;
        } else if (isStraight(pockers)) {
            return PokerLevel.STRAIGHT;
        } else if (hasThreeOfKind(pockers)) {
            return PokerLevel.THREE_OF_A_KIND;
        } else if (hasPair(pockers)) {
            return PokerLevel.PAIR;
        }
        return PokerLevel.HIGH_POINT;
    }

    private static boolean isStraightFlush(List<Pocker> pockers) {
        boolean isContinuous = judgeIsContinuous(pockers);
        Set<String> set = pockers.stream().map(Pocker::getPockerColor).collect(Collectors.toSet());
        return set.size() == 1 && isContinuous;
    }

    private static boolean isFourOfKind(List<Pocker> pockers) {
        Map<Integer, Integer> map = getCountTimesMap(pockers.stream().map(Pocker::getPoint).collect(Collectors.toList()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasThreeOfKind(List<Pocker> pockers) {
        Map<Integer, Integer> map = getCountTimesMap(pockers.stream().map(Pocker::getPoint).collect(Collectors.toList()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                return true;
            }
        }
        return false;
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
            case 3:
                return handleSameThreeOfKind(playerA.getPockers(), playerB.getPockers());
            case 4:
                return handleSameStraight(playerA.getPockers(), playerB.getPockers());
            case 5:
                return handleSameFlush();
            case 6:
                return handleSameFullHouse(playerA.getPockers(), playerB.getPockers());
            case 7:
                return handleSameFourOfKind(playerA.getPockers(), playerB.getPockers());
            case 8:
                return handleSameStraightFlush(playerA.getPockers(), playerB.getPockers());
        }
        return 0;
    }

    private static int handleSameStraightFlush(List<Pocker> pockerA, List<Pocker> pockerB) {
        return compareMaxPoint(pockerA, pockerB);
    }

    private static int handleSameFourOfKind(List<Pocker> pockerA, List<Pocker> pockerB) {
        return compareMaxPoint(pockerA, pockerB);
    }

    private static int handleSameFullHouse(List<Pocker> pockerA, List<Pocker> pockerB) {
        return compareMaxPoint(pockerA, pockerB);
    }

    private static int handleSameFlush() {
        return 3;
    }

    private static int handleSameStraight(List<Pocker> pockersA, List<Pocker> pockersB) {
        return compareMaxPoint(pockersA, pockersB);
    }

    private static int handleSameThreeOfKind(List<Pocker> pockersA, List<Pocker> pockersB) {
        return compareMaxPoint(pockersA, pockersB);
    }

    private static int compareMaxPoint(List<Pocker> pockersA, List<Pocker> pockersB) {
        List<Integer> countListA = pockersA.stream().map(Pocker::getPoint).collect(Collectors.toList());
        List<Integer> countListB = pockersB.stream().map(Pocker::getPoint).collect(Collectors.toList());
        int maxPointA = getMaxCount(countListA);
        int maxPointB = getMaxCount(countListB);
        return maxPointA > maxPointB ? 1 : 2;
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

    public static boolean isStraight(List<Pocker> pockers) {
        return judgeIsContinuous(pockers);
    }

    private static boolean judgeIsContinuous(List<Pocker> pockers) {
        if (pockers.size() != 5) {
            return false;
        }
        int min = pockers.stream().mapToInt(Pocker::getPoint).min().orElse(0);
        List<Integer> pointList = pockers.stream().map(Pocker::getPoint).collect(Collectors.toList());
        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.contains(min)) {
                min++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isFlush(List<Pocker> pockers) {
        List<String> colorList = pockers.stream().map(Pocker::getPockerColor).collect(Collectors.toList());
        Set<String> set = new HashSet<>(colorList);
        return set.size() == 1 && colorList.size() == 5;
    }

    public static boolean isFullHouse(List<Pocker> pockers) {
        List<Integer> colorList = pockers.stream().map(Pocker::getPoint).collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(colorList);
        return set.size() == 2 && colorList.size() == 5;
    }
}
