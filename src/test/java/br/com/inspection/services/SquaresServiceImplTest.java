package br.com.inspection.services;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SquaresServiceImplTest {

    SquaresService squaresServiceImpl;

    @Test
    public void shouldReturnEmptyWhenSquaresAreEmpty() {
        squaresServiceImpl = new SquaresServiceImpl(Collections.emptyList());
        assertThat(squaresServiceImpl.getTotalArea(), equalTo(0));
        assertThat(squaresServiceImpl.getBiggestSpotArea(), equalTo(0));
        assertThat(squaresServiceImpl.calculateNumberOfSpots(), equalTo(0));
    }

    @Test
    public void shouldReturnEmptyWhenSquaresAreNull() {
        squaresServiceImpl = new SquaresServiceImpl(null);
        assertThat(squaresServiceImpl.getTotalArea(), equalTo(0));
        assertThat(squaresServiceImpl.getBiggestSpotArea(), equalTo(0));
        assertThat(squaresServiceImpl.calculateNumberOfSpots(), equalTo(0));
    }

    @Test
    public void shouldReturnEmptyWhenSquaresHasNoSpots() {
        squaresServiceImpl = new SquaresServiceImpl(Arrays.asList("[0,0,0,0]","[0,0,0,0]","[0,0,0,0]","[0,0,0,0]"));
        assertThat(squaresServiceImpl.getTotalArea(), equalTo(0));
        assertThat(squaresServiceImpl.getBiggestSpotArea(), equalTo(0));
        assertThat(squaresServiceImpl.calculateNumberOfSpots(), equalTo(0));
    }

    @Test
    public void shouldReturnValuesWhenSquaresHasSpots() {
        squaresServiceImpl = new SquaresServiceImpl(Arrays.asList("[1,1,0,0]","[1,1,0,0]","[0,0,1,1]","[0,0,1,1]"));
        assertThat(squaresServiceImpl.getTotalArea(), equalTo(8));
        assertThat(squaresServiceImpl.getBiggestSpotArea(), equalTo(4));
        assertThat(squaresServiceImpl.calculateNumberOfSpots(), equalTo(2));
    }
}