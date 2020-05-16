package com.example.sample;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"x", "y", "expected"})
public class Fixture {
	private int x;
    private int y;
    private int expected;

    Fixture(){}

    Fixture(int x, int y, int expected) {
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	@Override
	public String toString() {
		return "Fixture [x=" + x + ", y=" + y + ", expected=" + expected + "]";
	}
}
