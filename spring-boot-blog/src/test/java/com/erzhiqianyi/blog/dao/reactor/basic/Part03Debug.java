package com.erzhiqianyi.blog.dao.reactor.basic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part03Debug {

    public Mono<Integer> getMonoWithException() {
        return Flux.<Integer>range(1, 5)
                .map(i -> i * i)
                .filter(i -> (i % 2) == 0)
                .single();
    }

    public List<String> getStreamWithException(){
        return Stream.of("one","two","on")
                .map(item -> item.substring(0,3))
                .collect(Collectors.toList());
    }

    public void error(){
        int i = 1/0 ;
    }
}
