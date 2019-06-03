package br.com.inspection.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void shouldReturnSizesLikeZeroWhenSquaresIsNull() {
        Square square = new Square(0, null);
        assertThat(square.getFirstPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getSecondPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getThirdPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getFourthPositionMaxSpotArea(0), equalTo(0));
    }

    @Test
    public void shouldReturnSizesLikeZeroWhenSquaresIsEmpty() {
        Square square = new Square(0, Collections.emptyList());
        assertThat(square.getFirstPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getSecondPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getThirdPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getFourthPositionMaxSpotArea(0), equalTo(0));
    }

    @Test
    public void shouldReturnSizesLikeZeroWhenSquaresHasSpotWithOnlyZero() {
        Square square = new Square(0, Arrays.asList("[0,0,0,0]","[0,0,0,0]","[0,0,0,0]","[0,0,0,0]"));
        assertThat(square.getFirstPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getSecondPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getThirdPositionMaxSpotArea(0), equalTo(0));
        assertThat(square.getFourthPositionMaxSpotArea(0), equalTo(0));
    }

    @Test
    public void shouldReturnAValidObjectWhenSquaresHasSpots() {
        Square square = new Square(0, Arrays.asList("[1,1,0,0]","[1,1,0,0]","[0,0,1,1]","[0,0,1,1]"));
        assertThat(square.getFirstPositionMaxSpotArea(0), equalTo(4));
        assertThat(square.getSecondPositionMaxSpotArea(0), equalTo(4));
        assertThat(square.getThirdPositionMaxSpotArea(0), equalTo(4));
        assertThat(square.getFourthPositionMaxSpotArea(0), equalTo(4));
    }

    @Test
    public void shouldReturnAListWithCorrectSizeAndValues() {
        Square square = new Square(0, Arrays.asList("[1,1,0,0]","[1,1,0,0]","[0,0,1,1]","[0,0,1,1]"));
        assertThat(square.getSquaresAsList().size(), equalTo(16));
        assertThat(square.getSquaresAsList(), hasItems(1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,1));
    }

}