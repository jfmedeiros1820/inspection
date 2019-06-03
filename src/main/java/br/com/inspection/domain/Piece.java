package br.com.inspection.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piece {

    private String squares;

    private List<String> squaresGrouped = new ArrayList<>();

    public String getSquares() {
        return this.squares;
    }

    public void setSquares(String squares) {
        if(squares != null && !squares.trim().equals("")) {
            this.squares = squares;
            squares = squares.substring(1, squares.length() - 1).replaceAll("],", "] ");
            String[] squaresGroup = squares.split(" ");
            this.squaresGrouped = Arrays.asList(squaresGroup);
        }
    }

    public List<String> getSquaresGrouped() {
        return squaresGrouped;
    }

    public void setSquaresGrouped(List<String> squaresGrouped) {
        this.squaresGrouped = squaresGrouped;
    }
}
