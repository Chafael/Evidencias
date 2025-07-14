package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.MedidaFisiologica;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedidaFisiologicaRepository {
    public MedidaFisiologica findByIdMedida(int idMedida) throws SQLException {
        MedidaFisiologica medidaFisiologica = null;
        String query = "SELECT * FROM MEDIDA_FISIOLOGICA WHERE id_medida = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idMedida);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    medidaFisiologica = new MedidaFisiologica();
                    medidaFisiologica.setIdMedida(rs.getInt("id_medida"));
                    medidaFisiologica.setIdUsuario(rs.getInt("id_usuario"));
                    medidaFisiologica.setIdConsulta(rs.getInt("id_consulta"));
                    medidaFisiologica.setOrigen(rs.getString("origen"));
                    medidaFisiologica.setFechaRegistro(rs.getDate("fecha_registro"));
                    medidaFisiologica.setTipoMedida(rs.getString("tipo_medida"));
                    medidaFisiologica.setValor(rs.getDouble("valor_medida"));
                    medidaFisiologica.setUnidad(rs.getString("unidad_medida"));
                    medidaFisiologica.setNotaAdicional(rs.getString("nota_adicional"));
                }
            }
        }
        return medidaFisiologica;
    }

    public void saveMedida(MedidaFisiologica medidaFisiologica) throws SQLException {
        String query = "INSERT INTO MEDIDA_FISIOLOGICA (id_usuario, id_consulta, origen, fecha_registro, tipo_medida, valor_medida, unidad_medida, nota_adicional) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, medidaFisiologica.getIdUsuario());
            stmt.setInt(2, medidaFisiologica.getIdConsulta());
            stmt.setString(3, medidaFisiologica.getOrigen());
            stmt.setDate(4, medidaFisiologica.getFechaRegistro());
            stmt.setString(5, medidaFisiologica.getTipoMedida());
            stmt.setDouble(6, medidaFisiologica.getValor());
            stmt.setString(7, medidaFisiologica.getUnidad());
            stmt.setString(8, medidaFisiologica.getNotaAdicional());
            stmt.executeUpdate();
        }
    }
}
