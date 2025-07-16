package org.medrecord.routes;

import io.javalin.Javalin;
import org.medrecord.controller.UsuarioController;

public class UsuarioRoutes {
    private final UsuarioController usuarioController;

    public UsuarioRoutes(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void register(Javalin app) {
        app.post("/users", usuarioController::create);
        app.get("/users/{id_usuario}", usuarioController::getById);
        app.put("/users/{id_usuario}", usuarioController::update);
        app.delete("/users/{id_usuario}", usuarioController::deleteById);

        // NUEVA RUTA DE LOGIN
        app.post("/login", usuarioController::login);
    }
}