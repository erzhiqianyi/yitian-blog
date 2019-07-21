package com.erzhiqianyi.blog.dao.reactor.basic;

import org.junit.Before;
import org.junit.Test;

public class Part03DebugTest {

    private Part03Debug part03Debug;

    @Before
    public void init(){
        part03Debug = new Part03Debug();
    }
    @Test
    public void getMonoWithException() {
//        Hooks.onOperatorDebug();
        part03Debug.getMonoWithException()
                .subscribe();
    }

    @Test
    public void getStreamWithException() {
        part03Debug.getStreamWithException();
    }

    @Test
    public void error() {
        part03Debug.error();
    }
}