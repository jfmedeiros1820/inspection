package br.com.inspection.controllers;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;
import br.com.inspection.services.InspectorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class InspectorControllerTest {

    @Mock
    InspectorService inspectorService;

    InspectorController inspectorController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        inspectorController = new InspectorController(inspectorService);
    }

    @Test
    public void shouldFailIfRequestInvalid() {
        Piece piece = new Piece();
        String squaresString = "[1,a,1,1],[0,false,0,0],[1,0.2,1,1],[0,0,0,0]";
        piece.setSquares(squaresString);
        Response response = inspectorController.inspect(piece);
        assertThat(response.getStatus(), equalTo(Response.Status.BAD_REQUEST.getStatusCode()));
        assertThat(response.getEntity(), equalTo("Invalid Matrix Format"));
        verifyNoMoreInteractions(inspectorService);
    }

    @Test
    public void shouldCallServiceIfRequestIsValid() {
        Piece piece = new Piece();
        String squaresString = "[1,1,0,0],[0,0,1,1],[0,0,1,1],[0,0,1,1]";
        piece.setSquares(squaresString);
        InspectionResult inspectionResult = new InspectionResult();
        inspectionResult.setTotalArea(8);
        inspectionResult.setNumberOfSpots(2);
        inspectionResult.setAverageSpotArea(4.0);
        inspectionResult.setBiggestSpotArea(4);
        when(inspectorService.inspectPiece(any(Piece.class))).thenReturn(inspectionResult);
        Response response = inspectorController.inspect(piece);
        assertThat(response.getStatus(), equalTo(Response.Status.OK.getStatusCode()));
        verify(inspectorService, times(1)).inspectPiece(ArgumentMatchers.any());
    }
}