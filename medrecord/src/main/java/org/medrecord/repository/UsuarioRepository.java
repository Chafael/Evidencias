package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {
    public Usuario findByIdUser(int idUsuario) throws SQLException {
        Usuario usuario = null;
        String query = "SELECT * FROM USUARIO WHERE id_usuario = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellidoPaterno(rs.getString("apellido_paterno"));
                    usuario.setApellidoMaterno(rs.getString("apellido_materno"));
                    usuario.setCorreo(rs.getString("email"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    usuario.setSexo(rs.getString("sexo"));
                }
            }
        }

        return usuario;
    }

    public void saveUser(Usuario usuario) throws SQLException {
        String query = "INSERT INTO USUARIO (nombre, apellido_paterno, apellido_materno, email, contrasena, fecha_nacimiento, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidoPaterno());
            stmt.setString(3, usuario.getApellidoMaterno());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getContrasena());
            stmt.setDate(6, usuario.getFechaNacimiento());
            stmt.setString(7, usuario.getSexo());
            stmt.executeUpdate();
        }
    }

    public void updateUser(Usuario usuario) throws SQLException {
        String query = "UPDATE USUARIO SET nombre = ?,  apellido_paterno= ?, apellido_materno= ?, email= ?, fecha_nacimiento= ?, sexo= ? WHERE id_usuario = ?";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidoPaterno());
            stmt.setString(3, usuario.getApellidoMaterno());
            stmt.setString(4, usuario.getCorreo());
            stmt.setDate(5, usuario.getFechaNacimiento());
            stmt.setString(6, usuario.getSexo());
            stmt.setInt(7, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int idUsuario) throws SQLException {
        String query = "DELETE FROM USUARIO WHERE id_usuario = ?";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }
}

