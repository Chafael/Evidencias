package org.medrecord.controller;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.medrecord.model.MedidaFisiologica;
import org.medrecord.service.domain.MedidaFisiologicaService;

public class MedidaFisiologicaController {
    private final MedidaFisiologicaService medidaFisiologicaService;

    public MedidaFisiologicaController(MedidaFisiologicaService medidaFisiologicaService) {
        this.medidaFisiologicaService = medidaFisiologicaService;
    }

    public void getById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id_medida"));
            MedidaFisiologica medidaFisiologica = medidaFisiologicaService.getByIdMedida(id);
            if (medidaFisiologica != null) {
                ctx.json(medidaFisiologica);
            } else {
                ctx.status(HttpStatus.NOT_FOUND).result("Medida fisiologica no encontrada");
            }
        } catch (Exception e) {
            ctx.status(404).result("Error al encontrar la medida fisiologica" + e.getMessage());
        }
    }

    public void create(Context ctx) {
        try {
            MedidaFisiologica medidaFisiologica = ctx.bodyAsClass(MedidaFisiologica.class);
            medidaFisiologicaService.createMedida(medidaFisiologica);
            ctx.status(201).result("Medida fisiologica creada");
        }catch (Exception e) {
            ctx.status(400).result("Error al crear la medida fisiologica" + e.getMessage());
        }
    }
}
