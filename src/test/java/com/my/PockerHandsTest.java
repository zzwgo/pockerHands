package com.my;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class PockerHandsTest {

    private PockerHands pockerHands=new PockerHands();

    @Test
    public void should_return_2_when_call_excute_given_2H_and_3D(){
        Pocker pockerA=new Pocker("2H");
        Pocker pockerB=new Pocker("3D");

        int result=pockerHands.excute(singletonList(pockerA),singletonList(pockerB));

        assertEquals(2,result);
    }

    @Test
    public void should_return_3_when_call_excute_given_KH_and_KD(){
        Pocker pockerA=new Pocker("KH");
        Pocker pockerB=new Pocker("KD");

        int result=pockerHands.excute(singletonList(pockerA),singletonList(pockerB));

        assertEquals(3,result);
    }

    @Test
    public void should_return_1_when_call_excute_given_each_player_five_poker(){

        List<Pocker> pockerListA= getPockerList(Arrays.asList("4H","5C","8C","9C","AD"));
        List<Pocker> pockerListB= getPockerList(Arrays.asList("2H","3D","5S","9C","KD"));

        int result=pockerHands.excute(pockerListA,pockerListB);

        assertEquals(1,result);
    }

    @Test
    public void should_return_3_when_call_excute_given_each_player_five_poker_draw(){

        List<Pocker> pockerListA= getPockerList(Arrays.asList("2H","3D","5S","9C","AC"));
        List<Pocker> pockerListB= getPockerList(Arrays.asList("4H","5C","8C","9C","AD"));

        int result=pockerHands.excute(pockerListA,pockerListB);

        assertEquals(3,result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_PlayerB_has_pair(){
        List<Pocker> pockerListA= getPockerList(Arrays.asList("2H","3D","5S","9C","AC"));
        List<Pocker> pockerListB= getPockerList(Arrays.asList("4H","5C","8C","10D","10H"));

        int result=pockerHands.excute(pockerListA,pockerListB);

        assertEquals(2,result);
    }

    @Test
    public void should_return_2_when_call_excute_given_each_player_five_poker_and_each_has_pair(){
        List<Pocker> pockerListA= getPockerList(Arrays.asList("2H","3D","5S","9C","9H"));
        List<Pocker> pockerListB= getPockerList(Arrays.asList("4H","5C","8C","10D","10H"));

        int result=pockerHands.excute(pockerListA,pockerListB);

        assertEquals(2,result);
    }


    private List<Pocker> getPockerList(List<String> values){
        List<Pocker> pockerList= new ArrayList<Pocker>();
        for(String value:values){
            pockerList.add(new Pocker(value));
        }
        return  pockerList;
    }
}