package br.com.inspection.services;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;

public class InspectorServiceImpl implements InspectorService {

    public InspectionResult inspectPiece(Piece piece) {
        InspectionResult inspectionResult = new InspectionResult();
        SquaresService squaresService = new SquaresServiceImpl(piece.getSquaresGrouped());
        inspectionResult.setTotalArea(squaresService.getTotalArea());
        inspectionResult.setNumberOfSpots(squaresService.calculateNumberOfSpots());
        inspectionResult.setBiggestSpotArea(squaresService.getBiggestSpotArea());
        inspectionResult.calculateAverageSpotArea();
        return inspectionResult;
    }
}
