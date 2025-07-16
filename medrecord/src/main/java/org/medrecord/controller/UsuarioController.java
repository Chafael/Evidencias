package org.medrecord.controller;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.medrecord.dto.LoginRequest;
import org.medrecord.model.Usuario;
import org.medrecord.service.domain.UsuarioService;
import java.sql.SQLIntegrityConstraintViolationException;

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void getById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id_usuario"));
            Usuario usuario = usuarioService.getByIdUser(id);
            if (usuario != null) {
                ctx.json(usuario);
            } else {
                ctx.status(HttpStatus.NOT_FOUND).result("Usuario no encontrado");
            }
        } catch (Exception e) {
            ctx.status(404).result("Error al encontrar al usuario" + e.getMessage());
        }
    }

    public void create(Context ctx) {
        try {
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            usuarioService.createUser(usuario);
            ctx.status(201).result("Usuario creado");
        }catch (SQLIntegrityConstraintViolationException e) {
            ctx.status(409).result("Ya existe un usuario con ese correo electrónico." + e.getMessage());
        }catch (Exception e) {
            ctx.status(400).result("Error al crear usuario" + e.getMessage());
        }
    }

    public void update(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id_usuario"));
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            usuario.setIdUsuario(id);
            usuarioService.updateUser(usuario);
            ctx.status(200).result("Usuario actualizado");
        } catch (SQLIntegrityConstraintViolationException e) {
            ctx.status(409).result("Ya existe un usuario con ese correo electrónico.");
        } catch (Exception e) {
            ctx.status(400).result("Error al actualizar usuario" + e.getMessage());
        }
    }

    public void deleteById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id_usuario"));
            usuarioService.deleteByIdUser(id);
            ctx.status(200).result("Usuario eliminado");
        } catch (Exception e) {
            ctx.status(400).result("Error al eliminar usuario" + e.getMessage());
        }
    }

    // MÉTODO LOGIN
    public void login(Context ctx) {
        try {
            LoginRequest loginRequest = ctx.bodyAsClass(LoginRequest.class);
            Usuario usuario = usuarioService.login(loginRequest.getCorreo(), loginRequest.getContrasena());

            if (usuario != null) {
                ctx.status(200).json(usuario);
            } else {
                ctx.status(401).result("Credenciales incorrectas");
            }
        } catch (Exception e) {
            ctx.status(400).result("Error al iniciar sesión: " + e.getMessage());
        }
    }
}