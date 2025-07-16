package org.medrecord.routes;

import io.javalin.Javalin;
import org.medrecord.controller.MedidaFisiologicaController;

public class MedidaFisiologicaRoutes {
    private final MedidaFisiologicaController medidaFisiologicaController;
    public MedidaFisiologicaRoutes(MedidaFisiologicaController medidaFisiologicaController) {
        this.medidaFisiologicaController = medidaFisiologicaController;
    }

    public void register(Javalin app) {
        app.post("/medidafisiologica", medidaFisiologicaController::create);
        app.get("/medidafisiologica/{id_medida}", medidaFisiologicaController::getById);
    }
}
