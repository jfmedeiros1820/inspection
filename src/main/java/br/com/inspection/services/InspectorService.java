package br.com.inspection.services;

import br.com.inspection.domain.InspectionResult;
import br.com.inspection.domain.Piece;

public interface InspectorService {

    InspectionResult inspectPiece(Piece piece);
}
