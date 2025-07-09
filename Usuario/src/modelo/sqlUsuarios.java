package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para manejar operaciones CRUD de la tabla USUARIO
 * Hereda la conexión de la clase Conexion
 */
public class sqlUsuarios extends Conexion {
    
    // ─── Constructor ────────────────────────────────────
    public sqlUsuarios() {
        super(); // Llama al constructor de la clase padre Conexion
    }
    
    // ─── Método para insertar un usuario ─────────────────
    public boolean insertarUsuario(usuarios usuario) {
        String sql = "INSERT INTO USUARIO (nombre, apellidos, fecha_nacimiento, email, contrasena, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return false;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getFecha_nacimiento());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getSexo());
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
            
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    // ─── Método para buscar usuario por ID ─────────────────
    public usuarios buscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM USUARIO WHERE id_usuario = ?";
        usuarios usuario = null;
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return null;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new usuarios(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("sexo"),
                    rs.getString("fecha_creacion")
                );
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario por ID: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        
        return usuario;
    }
    
    // ─── Método para buscar usuario por email ─────────────
    public usuarios buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM USUARIO WHERE email = ?";
        usuarios usuario = null;
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return null;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new usuarios(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("sexo"),
                    rs.getString("fecha_creacion")
                );
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario por email: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        
        return usuario;
    }
    
    // ─── Método para obtener todos los usuarios ──────────
    public List<usuarios> obtenerTodosUsuarios() {
        String sql = "SELECT * FROM USUARIO ORDER BY fecha_creacion DESC";
        List<usuarios> listaUsuarios = new ArrayList<>();
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return listaUsuarios;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                usuarios usuario = new usuarios(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("sexo"),
                    rs.getString("fecha_creacion")
                );
                listaUsuarios.add(usuario);
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los usuarios: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        
        return listaUsuarios;
    }
    
    // ─── Método para actualizar un usuario ──────────────
    public boolean actualizarUsuario(usuarios usuario) {
        String sql = "UPDATE USUARIO SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, email = ?, contrasena = ?, sexo = ? WHERE id_usuario = ?";
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return false;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getFecha_nacimiento());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getSexo());
            ps.setInt(7, usuario.getId_usuario());
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
            
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    // ─── Método para eliminar un usuario ────────────────
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE id_usuario = ?";
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return false;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
            
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    // ─── Método para verificar si un email ya existe ────
    public boolean emailExiste(String email) {
        String sql = "SELECT COUNT(*) FROM USUARIO WHERE email = ?";
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return false;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                rs.close();
                ps.close();
                return count > 0;
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error al verificar email: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        
        return false;
    }
    
    // ─── Método para validar login ──────────────────────
    public usuarios validarLogin(String email, String contrasena) {
        String sql = "SELECT * FROM USUARIO WHERE email = ? AND contrasena = ?";
        usuarios usuario = null;
        
        Connection con = getConexion();
        if (con == null) {
            System.err.println("No se pudo establecer la conexión");
            return null;
        }
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new usuarios(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("email"),
                    rs.getString("contrasena"),
                    rs.getString("sexo"),
                    rs.getString("fecha_creacion")
                );
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            System.err.println("Error al validar login: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
        
        return usuario;
    }
}