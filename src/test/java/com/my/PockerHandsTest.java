package com.my;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class PockerHandsTest {

    private PockerHands pockerHands = new PockerHands();

    @Test
    public void should_return_2_when_call_excute_given_2H_and_3D() {
        Pocker pockerA = new Pocker("2H");
        Pocker pockerB = new Pocker("3D");

        int result = pockerHands.excute(singletonList(pockerA), singletonList(pockerB));

        assertEquals(2, result);
    }

    @Test
    public void should_return_3_when_call_excute_given_KH_and_KD() {
        Pocker pockerA = new Pocker("KH");
        Pocker pockerB = new Pocker("KD");

        int result = pockerHands.excute(singletonList(pockerA), singletonList(pockerB));

        assertEquals(3, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker() {

        List<Pocker> pockerListA = getPockerList(Arrays.asList("4H", "5C", "8C", "9C", "AD"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2H", "3D", "5S", "9C", "KD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_3_when_call_excute_given_each_player_five_poker_draw() {

        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "3D", "5S", "9C", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("4H", "5C", "8C", "9C", "AD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(3, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_PlayerB_has_pair() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "3D", "5S", "9C", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("4H", "5C", "8C", "10D", "10H"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_each_has_pair() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "3D", "5S", "9C", "9H"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("4H", "5C", "8C", "10D", "10H"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and_each_has_same_pair() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "5S", "9C", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "8C", "9C", "KD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_each_has_two_pair() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "5S", "5C", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "8C", "8H", "KD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and_each_has_two_same_pair() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "5H", "5D", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "5S", "5C", "KD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_3_when_call_excute_given_each_player_five_poker_and_each_has_two_same_pair_and_same_point() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "5H", "5D", "KC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "5S", "5C", "KD"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(3, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_playeB_has_three_of_A_kind() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "5H", "5D", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "6S", "6C", "6D"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_each_has_three_of_A_kind() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "2S", "5D", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "2C", "6S", "6C", "6D"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_playerB_has_straight() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "2D", "2S", "9C", "AC"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("4H", "5C", "6C", "7C", "8D"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_each_player_has_straight() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2H", "3D", "4D", "5D", "6H"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("4H", "5C", "6C", "7C", "8D"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_playerB_has_flush() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2D", "3D", "4D", "5D", "6S"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2H", "5H", "6H", "7H", "9H"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    @Test
    public void should_return_3_when_call_excute_given_each_player_five_poker_and_each_player_has_flush() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("2S", "3S", "7S", "9S", "10S"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2H", "5H", "6H", "7H", "9H"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(3, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and__playerB_has_fullHouse() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("7H", "7C", "7S", "8C", "8D"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2S", "3S", "6S", "9S", "10S"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and_each_player_has_fullHouse() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("7H", "7C", "7S", "8C", "8D"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2D", "2S", "2H", "5D", "5C"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and_playerB_has_four_of_a_kind() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("7H", "7C", "7S", "7D", "8D"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2D", "2S", "2H", "5D", "5C"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker_and_each_player_has_four_of_a_kind() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("7H", "7C", "7S", "7D", "8D"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2C", "2H", "2S", "2D", "5C"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(1, result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_playerB_has_straight_flush() {
        List<Pocker> pockerListA = getPockerList(Arrays.asList("8C", "8H", "8S", "8D", "5C"));
        List<Pocker> pockerListB = getPockerList(Arrays.asList("2D", "3D", "4D", "5D", "6D"));

        int result = pockerHands.excute(pockerListA, pockerListB);

        assertEquals(2, result);
    }

    private List<Pocker> getPockerList(List<String> values) {
        List<Pocker> pockerList = new ArrayList<Pocker>();
        for (String value : values) {
            pockerList.add(new Pocker(value));
        }
        return pockerList;
    }
}