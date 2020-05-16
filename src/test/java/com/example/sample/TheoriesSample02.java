package com.example.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesSample02 {

	@SuppressWarnings("unchecked")
    @DataPoints
    public static Fixture[] getParams() {
		List<Fixture> list = Arrays.asList(
			new Fixture(3, 4, 7),
	        new Fixture(0, 5, 5),
	        new Fixture(-3, 1, -2)
		);
		return list.toArray(new Fixture[list.size()]);
	}

    @Theory
    public void add(Fixture p) throws Exception {
        assertThat(p.getX() + p.getY(), is(p.getExpected()));
    }
}
