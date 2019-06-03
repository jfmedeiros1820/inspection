package br.com.inspection.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Square {

    private int first, second, third, fourth;
    private int firstSpotSize, secondSpotSize, thirdSpotSize, fourthSpotSize;
    private Square nextSquare;

    public Square(int position, List<String> squares) {
        if(squares != null && !squares.isEmpty()) {
            String square = squares.get(position);
            String[] items = square.substring(1, square.length() - 1).split(",");
            this.first = Integer.parseInt(items[0]);
            this.second = Integer.parseInt(items[1]);
            this.third = Integer.parseInt(items[2]);
            this.fourth = Integer.parseInt(items[3]);
            this.nextSquare = position < squares.size() - 1 ? new Square(position+1, squares): null;
        }
        initializeSpotSizes();
    }

    private void initializeSpotSizes() {
        this.firstSpotSize = getFirstSpotSize();
        this.secondSpotSize = getSecondSpotSize();
        this.thirdSpotSize = getThirdSpotSize();
        this.fourthSpotSize = getFourthSpotSize();
    }

    public int getFirstPositionMaxSpotArea(int count) {
        int actualCount = this.firstSpotSize;
        if(this.nextSquare != null) {
            if(actualCount == 0) {
                actualCount = Math.max(count, this.nextSquare.getFirstPositionMaxSpotArea(0));
            } else {
                actualCount = this.nextSquare.getFirstPositionMaxSpotArea(count + actualCount);
            }
        } else {
            actualCount += count;
        }
        return Math.max(count, actualCount);
    }

    public int getSecondPositionMaxSpotArea(int count) {
        int actualCount = this.secondSpotSize;
        if(this.nextSquare != null) {
            if(actualCount == 0) {
                actualCount = Math.max(count, this.nextSquare.getSecondPositionMaxSpotArea(0));
            } else {
                actualCount = this.nextSquare.getSecondPositionMaxSpotArea(count + actualCount);
            }
        } else {
            actualCount += count;
        }
        return Math.max(count, actualCount);
    }

    public int getThirdPositionMaxSpotArea(int count) {
        int actualCount = this.thirdSpotSize;
        if(this.nextSquare != null) {
            if(actualCount == 0) {
                actualCount = Math.max(count, this.nextSquare.getThirdPositionMaxSpotArea(0));
            } else {
                actualCount = this.nextSquare.getThirdPositionMaxSpotArea(count + actualCount);
            }
        } else {
            actualCount += count;
        }
        return Math.max(count, actualCount);
    }

    public int getFourthPositionMaxSpotArea(int count) {
        int actualCount = this.fourthSpotSize;
        if(this.nextSquare != null) {
            if(actualCount == 0) {
                actualCount = Math.max(count, this.nextSquare.getFourthPositionMaxSpotArea(0));
            } else {
                actualCount = this.nextSquare.getFourthPositionMaxSpotArea(count + actualCount);
            }
        } else {
            actualCount += count;
        }
        return Math.max(count, actualCount);
    }

    private int getFirstSpotSize() {
        int actualCount = 0;
        if(first == 1) {
            actualCount++;
            if(second == 1){
                actualCount++;
                if(fourth == 1) actualCount++;
            }
            if(third == 1) actualCount++;
        }
        return actualCount;
    }

    private int getSecondSpotSize() {
        int actualCount = 0;
        if(second == 1) {
            actualCount++;
            if(first == 1){
                actualCount++;
                if(third == 1) actualCount++;
            }
            if(fourth == 1) actualCount++;
        }
        return actualCount;
    }

    private int getThirdSpotSize() {
        int actualCount = 0;
        if(third == 1) {
            actualCount++;
            if(first == 1){
                actualCount++;
                if(second == 1) actualCount++;
            }
            if(fourth == 1) actualCount++;
        }
        return actualCount;
    }

    private int getFourthSpotSize() {
        int actualCount = 0;
        if(fourth == 1) {
            actualCount++;
            if(third == 1){
                actualCount++;
                if(first == 1) actualCount++;
            }
            if(second == 1) actualCount++;
        }
        return actualCount;
    }

    public List<Integer> getSquaresAsList() {
        List<Integer> squares = new ArrayList<>(Arrays.asList(first, second, third, fourth));
        if(this.nextSquare != null) {
            squares.addAll(this.nextSquare.getSquaresAsList());
        }
        return squares;
    }
}
