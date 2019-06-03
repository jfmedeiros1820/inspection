package br.com.inspection.services;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InspectorServiceImplTest {

    InspectorService inspectorService;

    @Before
    public void setUp() {
        inspectorService = new InspectorServiceImpl();
    }

    @Test
    public void shouldReturnAnEmptyObjectIfSquaresAreEmpty() {
        Piece piece = new Piece();
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        assertThat(inspectionResult.getTotalArea(), equalTo(0));
        assertThat(inspectionResult.getAverageSpotArea(), equalTo(0.0));
        assertThat(inspectionResult.getBiggestSpotArea(), equalTo(0));
        assertThat(inspectionResult.getNumberOfSpots(), equalTo(0));
    }

    @Test
    public void shouldReturnObjectWithEmptyValuesIfMatrixHasSpotWithOnlyZero() {
        Piece piece = new Piece();
        piece.setSquaresGrouped(Arrays.asList("[0,0,0,0]","[0,0,0,0]","[0,0,0,0]","[0,0,0,0]"));
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        assertThat(inspectionResult.getTotalArea(), equalTo(0));
        assertThat(inspectionResult.getAverageSpotArea(), equalTo(0.0));
        assertThat(inspectionResult.getBiggestSpotArea(), equalTo(0));
        assertThat(inspectionResult.getNumberOfSpots(), equalTo(0));
    }

    @Test
    public void shouldReturnAResponseWithValuesIfMatrixHasSpots() {
        Piece piece = new Piece();
        piece.setSquaresGrouped(Arrays.asList("[1,1,0,0]","[1,1,0,0]","[0,0,1,1]","[0,0,1,1]"));
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        assertThat(inspectionResult.getTotalArea(), equalTo(8));
        assertThat(inspectionResult.getAverageSpotArea(), equalTo(4.0));
        assertThat(inspectionResult.getBiggestSpotArea(), equalTo(4));
        assertThat(inspectionResult.getNumberOfSpots(), equalTo(2));
    }

    @Test
    public void shouldReturnAResponseWithValuesIfMatrixHasSpotsWithoutConnections() {
        Piece piece = new Piece();
        piece.setSquaresGrouped(Arrays.asList("[1,0,0,0]","[0,0,1,0]","[0,0,0,1]","[0,0,1,1]"));
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        assertThat(inspectionResult.getTotalArea(), equalTo(5));
        assertThat(inspectionResult.getAverageSpotArea(), equalTo(1.6666666666666667));
        assertThat(inspectionResult.getBiggestSpotArea(), equalTo(3));
        assertThat(inspectionResult.getNumberOfSpots(), equalTo(3));
    }

    @Test
    public void shouldReturnAResponseWithValuesIfMatrixHasLargeSpotArea() {
        Piece piece = new Piece();
        piece.setSquaresGrouped(Arrays.asList("[1,1,1,1]","[1,1,1,1]","[1,1,1,1]","[1,1,1,1]"));
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        assertThat(inspectionResult.getTotalArea(), equalTo(16));
        assertThat(inspectionResult.getAverageSpotArea(), equalTo(16.0));
        assertThat(inspectionResult.getBiggestSpotArea(), equalTo(16));
        assertThat(inspectionResult.getNumberOfSpots(), equalTo(1));
    }
}