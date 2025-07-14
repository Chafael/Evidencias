package org.medrecord.service.domain;

import org.medrecord.model.Prescripcion;
import org.medrecord.repository.PrescripcionRepository;

import java.sql.SQLException;

public class PrescripcionService {
    private final PrescripcionRepository prescripcionRepo;
    public PrescripcionService(PrescripcionRepository prescripcionRepo) {
        this.prescripcionRepo = prescripcionRepo;
    }

    public Prescripcion getByIdPrescripcion(int idPrescripcion) throws SQLException {
        return prescripcionRepo.findByIdPrescripcion(idPrescripcion);
    }

    public void createPrescripcion(Prescripcion prescripcion) throws SQLException {
        prescripcionRepo.savePrescripcion(prescripcion);
    }
}
