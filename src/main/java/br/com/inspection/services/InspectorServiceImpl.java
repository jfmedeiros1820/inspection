package br.com.inspection.services;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InspectorServiceImpl implements InspectorService {

    private static final Logger logger = LoggerFactory.getLogger(InspectorServiceImpl.class);

    public InspectionResult inspectPiece(Piece piece) {
        logger.info("Initializing inspection of piece process");
        InspectionResult inspectionResult = new InspectionResult();
        SquaresService squaresService = new SquaresServiceImpl(piece.getSquaresGrouped());
        inspectionResult.setTotalArea(squaresService.getTotalArea());
        inspectionResult.setNumberOfSpots(squaresService.calculateNumberOfSpots());
        inspectionResult.setBiggestSpotArea(squaresService.getBiggestSpotArea());
        inspectionResult.calculateAverageSpotArea();
        logger.info("Inspection process ended successfully");
        return inspectionResult;
    }
}
