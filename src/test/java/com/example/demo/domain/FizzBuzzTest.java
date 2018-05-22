package com.example.demo.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void FizzTest() {
        String value = FizzBuzz.getValue(3);
        Assert.assertEquals("Fizz",value);
    }

    @Test
    public void BuzzTest() {
        String value2 = FizzBuzz.getValue(5);
        Assert.assertEquals("Buzz",value2);
    }

    @Test
    public void FizzBuzzTest() {
        String value2 = FizzBuzz.getValue(15);
        Assert.assertEquals("FizzBuzz",value2);
    }

    @Test
    public void NormalTest() {
        String value2 = FizzBuzz.getValue(13);
        Assert.assertEquals("13",value2);
    }
}