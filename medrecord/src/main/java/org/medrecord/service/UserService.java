package org.medrecord.service;

import org.medrecord.model.Usuario;
import org.medrecord.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<Usuario> getAllUsers() throws SQLException {
        return userRepo.findAll();
    }

    public Usuario getByIdUser(int id_usuario) throws SQLException {
        return userRepo.findByid_usuario(id_usuario);
    }

    public void createUser(Usuario user) throws SQLException {
        userRepo.save(user);
    }
}
