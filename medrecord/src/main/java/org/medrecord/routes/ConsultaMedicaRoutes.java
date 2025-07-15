package org.medrecord.routes;

import io.javalin.Javalin;
import org.medrecord.controller.ConsultaMedicaController;

public class ConsultaMedicaRoutes {
    private final ConsultaMedicaController consultaMedicaController;
    public ConsultaMedicaRoutes(ConsultaMedicaController consultaMedicaController) {
        this.consultaMedicaController = consultaMedicaController;
    }

    public void register(Javalin app) {
        app.post("/consultamedica", consultaMedicaController::create);
        app.get("/consultamedica/{id_consulta}", consultaMedicaController::getById);


        // Ejemplo de más rutas:
        // app.put("/users/:id", userController::update);
        // app.delete("/users/:id", userController::delete);
    }
}
