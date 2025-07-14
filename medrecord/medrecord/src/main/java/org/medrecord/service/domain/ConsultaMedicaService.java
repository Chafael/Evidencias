package org.medrecord.service.domain;

import org.medrecord.model.ConsultaMedica;
import org.medrecord.repository.ConsultaMedicaRepository;

import java.sql.SQLException;


public class ConsultaMedicaService {
    private final ConsultaMedicaRepository consultaMedicaRepo;
    public ConsultaMedicaService(ConsultaMedicaRepository consultaMedicaRepo) {
        this.consultaMedicaRepo = consultaMedicaRepo;
    }
    public ConsultaMedica getByIdConsulta(int idConsulta) throws SQLException {
        return consultaMedicaRepo.findByIdConsulta(idConsulta);
    }

    public void createConsulta(ConsultaMedica consultaMedica) throws SQLException {
        consultaMedicaRepo.saveConsulta(consultaMedica);
    }
}
