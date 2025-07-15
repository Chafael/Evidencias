package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.Prescripcion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescripcionRepository {
    public Prescripcion findByIdPrescripcion(int idPrescripcion) throws SQLException {
        Prescripcion prescripcion = null;
        String query = "SELECT * FROM PRESCRIPCION WHERE id_prescripcion = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idPrescripcion);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prescripcion = new Prescripcion();
                    prescripcion.setIdPrescripcion(rs.getInt("id_prescripcion"));
                    prescripcion.setIdConsulta(rs.getInt("id_consulta"));
                    prescripcion.setIdMedicamento(rs.getInt("id_medicamento"));
                    prescripcion.setDosis(rs.getDouble("dosis"));
                    prescripcion.setFrecuencia(rs.getInt("frecuencia"));
                    prescripcion.setDuracion(rs.getInt("duracion"));
                    prescripcion.setInstruccionesAdionales(rs.getString("instrucciones_adionales"));
                }
            }
        }
        return prescripcion;

    }

    public void savePrescripcion(Prescripcion prescripcion) throws SQLException {
        String query = "INSERT INTO PRESCRIPCION (id_consulta, id_medicamento, dosis, frecuencia, duracion, instrucciones_adionales) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, prescripcion.getIdConsulta());
            stmt.setInt(2, prescripcion.getIdMedicamento());
            stmt.setDouble(3, prescripcion.getDosis());
            stmt.setInt(4, prescripcion.getFrecuencia());
            stmt.setInt(5, prescripcion.getDuracion());
            stmt.setString(6, prescripcion.getInstruccionesAdionales());
            stmt.executeUpdate();
        }
    }
}
