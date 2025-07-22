package org.medrecord.controller;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.medrecord.model.ConsultaMedica;
import org.medrecord.service.domain.ConsultaMedicaService;
import org.medrecord.service.domain.PrescripcionService;

public class ConsultaMedicaController {
    private final ConsultaMedicaService consultaMedicaService;

    public ConsultaMedicaController(ConsultaMedicaService consultaMedicaService) {
        this.consultaMedicaService = consultaMedicaService;
    }



    public void getById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id_consulta"));
            ConsultaMedica consultaMedica = consultaMedicaService.getByIdConsulta(id);
            if (consultaMedica != null) {
                ctx.json(consultaMedica);
            } else {
                ctx.status(HttpStatus.NOT_FOUND).result("Consulta medica no encontrada");
            }
        } catch (Exception e) {
            ctx.status(404).result("Error al encontrar la consulta medica" );
        }
    }

    public void create(Context ctx) {
        try {
            ConsultaMedica consultaMedica = ctx.bodyAsClass(ConsultaMedica.class);
            consultaMedicaService.createConsulta(consultaMedica);
            ctx.status(201).result("Consulta medica creada");
        }catch (Exception e) {
            ctx.status(400).result("Error al crear la consulta medica" + e.getMessage());
        }
    }
}
