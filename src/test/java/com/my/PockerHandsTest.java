package com.my;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

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
}