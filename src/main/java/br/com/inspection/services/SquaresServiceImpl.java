package br.com.inspection.services;

import br.com.inspection.domain.Square;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SquaresServiceImpl implements SquaresService {

    private static final Logger logger = LoggerFactory.getLogger(SquaresServiceImpl.class);

    private Square square;
    private List<Integer> values = new ArrayList<>();

    public SquaresServiceImpl(List<String> squares) {
        if(squares != null && !squares.isEmpty()) {
            this.square = new Square(0, squares);
            this.values = this.square.getSquaresAsList();
        }
    }

    public int getTotalArea() {
        logger.info("Getting total area with spots");
        return this.values.stream().reduce(0, Integer::sum);
    }

    public int getBiggestSpotArea() {
        logger.info("Getting the biggest spot area");
        int biggestSpotArea = 0;
        if(this.square != null) {
            biggestSpotArea = Math.max(this.square.getFirstPositionMaxSpotArea(0), this.square.getSecondPositionMaxSpotArea(0));
            biggestSpotArea = Math.max(biggestSpotArea, this.square.getThirdPositionMaxSpotArea(0));
            biggestSpotArea = Math.max(biggestSpotArea, this.square.getFourthPositionMaxSpotArea(0));
        }
        logger.info("Biggest spot area is: " + biggestSpotArea);
        return biggestSpotArea;
    }

    public int calculateNumberOfSpots() {
        logger.info("Starting calculation of the number of spots");
        int spots = 0;
        for (int i = 0; i < values.size(); i++) {
            boolean hasSpot;
            int size = 4;
            if(i % size == 0) {
                if(isMatrixFull(i, values)) {
                    hasSpot = true;
                    int j = i;
                    do {
                        j += size;

                        if(j % size == 0) j--;
                    } while(j < (values.size() -1) && isMatrixFull(j, values));
                    i = j;
                } else {
                    hasSpot = hasSpot(i, size, values);
                }
            } else {
                hasSpot = hasSpot(i, size, values);
            }
            if(hasSpot) {
                spots++;
            }
        }
        logger.info("Number of spots is: " + spots);
        return spots;
    }

    private boolean isMatrixFull(int i, List<Integer> values) {
        return values.get(i) == 1 && values.get(i+1) == 1 && values.get(i+2) == 1 && values.get(i+3) == 1;
    }

    private boolean hasSpot(int i, int size, List<Integer> values) {
        boolean hasSpot = false;
        int spaces = i % 2 == 0 ? 2 : 1;
        int value = values.get(i);
        if(value == 1) {
            if( (i + size) < values.size() && values.get(i + size) == 1) {
                if((i - spaces) >= 0) {
                    if( (i - size) >= 0 && values.get(i - size) == 1) {
                        hasSpot = false;
                    } else if(values.get(i - spaces) != 1) {
                        hasSpot = true;
                    }
                } else {
                    hasSpot = true;
                }
            } else if( (i - size) >= 0 && values.get(i - size) == 1) {
                hasSpot = false;
            } else if((i + 1) < values.size() && values.get(i + 1) == 1) {
                hasSpot = false;
            } else hasSpot = (i - 1) < 0 || values.get(i - 1) != 1;
        }
        return hasSpot;
    }
}
