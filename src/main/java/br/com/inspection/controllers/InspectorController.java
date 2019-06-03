package br.com.inspection.controllers;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;
import br.com.inspection.services.InspectorService;
import br.com.inspection.services.InspectorServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/spot_check")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InspectorController {

    private InspectorService inspectorService;

    public InspectorController() {
        this.inspectorService = new InspectorServiceImpl();
    }

    public InspectorController(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @POST
    public Response inspect(Piece piece) {
        if(!isSquaresValid(piece.getSquaresGrouped())) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("Invalid Matrix Format")
                    .build();
        }
        InspectionResult inspectionResult = inspectorService.inspectPiece(piece);
        return Response.ok(inspectionResult).build();
    }

    private static boolean isSquaresValid(List<String> squares) {
        for (String square: squares) {
            String squareClean = square.substring(1, square.length() - 1);
            boolean hasInvalidCharacter = !squareClean.matches("[0-9, /,]+");
            boolean hasMoreThanFourElements = squareClean.split(",").length > 4;

            if(hasInvalidCharacter || hasMoreThanFourElements) {
                return false;
            }
        }
        return true;
    }
}
