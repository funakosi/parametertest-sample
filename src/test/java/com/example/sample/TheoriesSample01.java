package com.example.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesSample01 {

    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(3, 4, 7),
        new Fixture(0, 5, 5),
        new Fixture(-3, 1, -2), };

    @Theory
    public void add(Fixture p) throws Exception {
        assertThat(p.x + p.y, is(p.expected));
    }

    static class Fixture {
        int x;
        int y;
        int expected;

        Fixture(int x, int y, int expected) {
            this.x = x;
            this.y = y;
            this.expected = expected;
        }
    }
}
