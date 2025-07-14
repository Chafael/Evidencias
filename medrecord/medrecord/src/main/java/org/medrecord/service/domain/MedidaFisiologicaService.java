package org.medrecord.service.domain;

import org.medrecord.model.MedidaFisiologica;
import org.medrecord.repository.MedidaFisiologicaRepository;

import java.sql.SQLException;


public class MedidaFisiologicaService {
    private final MedidaFisiologicaRepository medidaFisiologicaRepo;
    public MedidaFisiologicaService(MedidaFisiologicaRepository medidaFisiologicaRepo) {
        this.medidaFisiologicaRepo = medidaFisiologicaRepo;
    }
    public MedidaFisiologica getByIdMedida(int idMedida) throws SQLException {
        return medidaFisiologicaRepo.findByIdMedida(idMedida);
    }

    public void createMedida(MedidaFisiologica medidaFisiologica) throws SQLException {
        medidaFisiologicaRepo.saveMedida(medidaFisiologica);
    }
}
