package org.medrecord.routes;

import io.javalin.Javalin;
import org.medrecord.controller.UserController;

public class UserRoutes {
    private final UserController userController;

    public UserRoutes(UserController userController) {
        this.userController = userController;
    }

    public void register(Javalin app) {
        app.get("/users", userController::getAll);
        app.post("/users", userController::create);
        app.get("/users/{id}", userController::getById);
    }
}

