package dev.conca.kata.romannumerals.converter;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dev.conca.kata.romannumerals.converter.IntegerToRomanConverter;

public class ConverterAcceptanceTest {

    private IntegerToRomanConverter converter;

    @Before
    public void setUp() {
        converter = new IntegerToRomanConverter();
    }
    
    @Test
    public void testConversions() {
        Assert.assertEquals("I", converter.convert(1));
        Assert.assertEquals("II", converter.convert(2));
        Assert.assertEquals("III", converter.convert(3));
        Assert.assertEquals("IV", converter.convert(4));
        Assert.assertEquals("V", converter.convert(5));
        Assert.assertEquals("VI", converter.convert(6));
        Assert.assertEquals("VII", converter.convert(7));
        Assert.assertEquals("VIII", converter.convert(8));
        Assert.assertEquals("IX", converter.convert(9));
        Assert.assertEquals("X", converter.convert(10));
        Assert.assertEquals("XX", converter.convert(20));
        Assert.assertEquals("XXX", converter.convert(30));
        Assert.assertEquals("XL", converter.convert(40));
        Assert.assertEquals("L", converter.convert(50));
        Assert.assertEquals("LX", converter.convert(60));
        Assert.assertEquals("LXX", converter.convert(70));
        Assert.assertEquals("LXXX", converter.convert(80));
        Assert.assertEquals("XC", converter.convert(90));
        Assert.assertEquals("C", converter.convert(100));
        Assert.assertEquals("CC", converter.convert(200));
        Assert.assertEquals("CCC", converter.convert(300));
        Assert.assertEquals("CD", converter.convert(400));
        Assert.assertEquals("D", converter.convert(500));
        Assert.assertEquals("DC", converter.convert(600));
        Assert.assertEquals("DCC", converter.convert(700));
        Assert.assertEquals("DCCC", converter.convert(800));
        Assert.assertEquals("CM", converter.convert(900));
        Assert.assertEquals("M", converter.convert(1000));
        Assert.assertEquals("MCCC", converter.convert(1300));
        Assert.assertEquals("MCD", converter.convert(1400));
        Assert.assertEquals("MD", converter.convert(1500));
        Assert.assertEquals("MDC", converter.convert(1600));
        Assert.assertEquals("MDCC", converter.convert(1700));
    }
}
