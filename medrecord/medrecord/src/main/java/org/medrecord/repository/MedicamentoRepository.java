package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentoRepository {
    public Medicamento findByIdMedicamento(int idMedicamento) throws SQLException {
        Medicamento medicamento = null;
        String query = "SELECT * FROM MEDICAMENTO WHERE id_consulta = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idMedicamento);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    medicamento = new Medicamento();
                    medicamento.setIdMedicamento(rs.getInt("id_consulta"));
                    medicamento.setNombreMedicamento(rs.getString("nombre_medicamento"));
                    medicamento.setUnidadMedicamento(rs.getString("unidad_medicamento"));
                    medicamento.setCategoriaMedicamento(rs.getString("categoria_medicamento"));
                    medicamento.setTipoMedicamento(rs.getString("tipo_medicamento"));
                }
            }
        }
        return medicamento;
    }

    public void saveMedicamento(Medicamento medicamento) throws SQLException {
        String query = "INSERT INTO MEDICAMENTO (nombre_medicamento, unidad_medicamento, categoria_medicamento, tipo_medicamento) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, medicamento.getNombreMedicamento());
            stmt.setString(2, medicamento.getUnidadMedicamento());
            stmt.setString(3, medicamento.getCategoriaMedicamento());
            stmt.setString(4, medicamento.getTipoMedicamento());
            stmt.executeUpdate();
        }
    }
}
