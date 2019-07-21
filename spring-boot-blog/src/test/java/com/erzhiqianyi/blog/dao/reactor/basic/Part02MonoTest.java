package com.erzhiqianyi.blog.dao.reactor.basic;

import org.junit.Before;
import org.junit.Test;
import reactor.test.StepVerifier;

public class Part02MonoTest {

    private Part02Mono part02Mono;

    @Before
    public void init() {
        part02Mono = new Part02Mono();
    }

    @Test
    public void emptyMono() {
        StepVerifier.create(part02Mono.emptyMono())
                .expectComplete()
                .verify();

    }

    @Test
    public void monoWithNoSignal() {
        StepVerifier.create(part02Mono.monoWithNoSignal())
                .expectComplete()
                .verify();
    }

    @Test
    public void fooMono() {
        StepVerifier.create(part02Mono.fooMono())
                .expectNext("foo")
                .expectComplete()
                .verify();

    }

    @Test
    public void errorMono() {
        StepVerifier.create(part02Mono.errorMono())
                .expectError(IllegalStateException.class)
                .verify();

    }

    @Test
    public void monoFromSupplier() {
        StepVerifier.create(part02Mono.monoFromSupplier())
                .expectNext("foo")
                .expectComplete()
                .verify();

    }

    @Test
    public void delayMono() {
        StepVerifier.create(part02Mono.delayMono())
                .expectNext(0l)
                .expectComplete()
                .verify();

    }

    @Test
    public void justOrEmptyMono() {
        StepVerifier.create(part02Mono.justOrEmptyMono())
                .expectComplete()
                .verify();

    }
}