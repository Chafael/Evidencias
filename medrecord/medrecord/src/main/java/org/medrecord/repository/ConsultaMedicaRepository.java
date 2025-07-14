package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.ConsultaMedica;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultaMedicaRepository {
    public ConsultaMedica findByIdConsulta(int idConsulta) throws SQLException {
        ConsultaMedica consultaMedica = null;
        String query = "SELECT * FROM USUARIO WHERE id_consulta = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idConsulta);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    consultaMedica = new ConsultaMedica();
                    consultaMedica.setIdConsulta(rs.getInt("id_consulta"));
                    consultaMedica.setIdUsuario(rs.getInt("id_usuario"));
                    consultaMedica.setMotivo(rs.getString("motivo"));
                    consultaMedica.setDoctor(rs.getString("doctor"));
                    consultaMedica.setClinica(rs.getString("clinica"));
                    consultaMedica.setFechaConsulta(rs.getDate("fecha_consulta"));
                }
            }
        }
        return consultaMedica;
    }

    public void saveConsulta(ConsultaMedica consultaMedica) throws SQLException {
        String query = "INSERT INTO USUARIO (id_usuario, motivo, doctor, clinica, fecha_consulta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, consultaMedica.getIdUsuario());
            stmt.setString(2, consultaMedica.getMotivo());
            stmt.setString(3, consultaMedica.getDoctor());
            stmt.setString(4, consultaMedica.getClinica());
            stmt.setDate(5, consultaMedica.getFechaConsulta());
            stmt.executeUpdate();
        }
    }
}
