package org.medrecord.service.domain;

import org.medrecord.model.Usuario;
import org.medrecord.repository.UsuarioRepository;

import java.sql.SQLException;

public class UsuarioService {
    private final UsuarioRepository usuarioRepo;
    public UsuarioService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    public Usuario getByIdUser(int idUsuario) throws SQLException {
        return usuarioRepo.findByIdUser(idUsuario);
    }

    public void createUser(Usuario usuario) throws SQLException {
        usuarioRepo.saveUser(usuario);
    }

    public void updateUser(Usuario usuario) throws SQLException {
        usuarioRepo.updateUser(usuario);
    }

    public void deleteByIdUser(int idUsuario) throws SQLException {
        usuarioRepo.deleteUser(idUsuario);
    }
}
