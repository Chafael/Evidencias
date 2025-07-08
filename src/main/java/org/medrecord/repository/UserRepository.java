package org.medrecord.repository;

import org.medrecord.config.DataBaseConfig;
import org.medrecord.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<Usuario> findAll() throws SQLException {
        List<Usuario> users = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";
        try (
                Connection conn = DataBaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellido"));
                u.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                u.setEmail(rs.getString("email"));
                u.setContrasena(rs.getString("contrasena"));
                u.setGenero(rs.getString("sexo"));
                users.add(u);
            }
        }
        return users;
    }

    public Usuario findByid_usuario(int id_usuario) throws SQLException {
        Usuario user = null;
        String query = "SELECT * FROM usuario WHERE id_usuario = ?";

        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id_usuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new Usuario();
                    user.setId_usuario(rs.getInt("id_usuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setApellidos(rs.getString("apellidos"));
                    user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    user.setEmail(rs.getString("email"));
                    user.setContrasena(rs.getString("contrasena"));
                    user.setGenero(rs.getString("sexo"));
                }
            }
        }

        return user;
    }

    public void save(Usuario user) throws SQLException {
        String query = "INSERT INTO USUARIO (nombre, apellidos, fecha_nacimiento, email, contrasena, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getApellidos());
            stmt.setDate(3, new java.sql.Date(user.getFechaNacimiento().getTime()));
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getContrasena());
            stmt.setString(6, user.getGenero());
            stmt.executeUpdate();
        }
    }
}
