package com.erzhiqianyi.blog.dao.reactor.basic;

import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

public class Part01FluxTest {
    Part01Flux part01Flux;

    @Before
    public void init() {

        part01Flux = new Part01Flux();
    }

    @Test
    public void emptyFlux() {
        StepVerifier.create(part01Flux.emptyFlux())
                .expectComplete()
                .verify();
    }

    @Test
    public void fooBarFluxFromValues() {
        StepVerifier.create(part01Flux.fooBarFluxFromValues())
                .expectNext("foo", "bar")
                .expectComplete()
                .verify();
    }

    @Test
    public void fooBarFluxFromList() {
        StepVerifier.create(part01Flux.fooBarFluxFromList())
                .expectNext("foo", "bar")
                .expectComplete()
                .verify();
    }

    @Test
    public void errorFlux() {
        StepVerifier.create(part01Flux.errorFlux())
                .expectError(IllegalStateException.class)
                .verify();
    }

    @Test
    public void counter() {
        StepVerifier.create(part01Flux.counter())
                .expectNext(0l, 1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l)
                .expectComplete()
                .verify();
    }

    @Test
    public void range() {
        StepVerifier.create(part01Flux.range())
                .expectNext( 1, 2, 3, 4, 5)
                .expectComplete()
                .verify();

    }
}