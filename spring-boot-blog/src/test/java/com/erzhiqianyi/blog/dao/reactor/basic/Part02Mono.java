package com.erzhiqianyi.blog.dao.reactor.basic;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

public class Part02Mono {
    //  Return an empty Mono
    Mono<String> emptyMono() {
        return Mono.empty();
    }


    //  Return a Mono that never emits any signal
    Mono<String> monoWithNoSignal() {
        return Mono.never();
    }


    //  Return a Mono that contains a "foo" value
    Mono<String> fooMono() {
        return Mono.just("foo");
    }


    //  Create a Mono that emits an IllegalStateException
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }

    //  Create a Mono from supplier
    Mono<String> monoFromSupplier(){
       return Mono.fromSupplier(() -> "foo") ;
    }

    //  Create a Mono delay
    Mono<Long> delayMono(){
       return Mono.delay(Duration.ofMillis(100)) ;
    }

    Mono<String> justOrEmptyMono(){
       return Mono.justOrEmpty(Optional.empty()) ;
    }

}
