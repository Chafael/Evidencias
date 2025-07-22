package org.medrecord.di;

import org.medrecord.service.domain.MedidaFisiologicaService;
import org.medrecord.service.domain.UsuarioService;
import org.medrecord.service.domain.ConsultaMedicaService;

import org.medrecord.controller.UsuarioController;
import org.medrecord.controller.ConsultaMedicaController;
import org.medrecord.controller.MedidaFisiologicaController;


import org.medrecord.repository.UsuarioRepository;
import org.medrecord.repository.ConsultaMedicaRepository;
import org.medrecord.repository.MedidaFisiologicaRepository;


import org.medrecord.routes.UsuarioRoutes;
import org.medrecord.routes.ConsultaMedicaRoutes;
import org.medrecord.routes.MedidaFisiologicaRoutes;

public class AppModule {
    public static UsuarioRoutes initUser() {
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);
        UsuarioController usuarioController = new UsuarioController(usuarioService);
        return new UsuarioRoutes(usuarioController);
    }

    public static ConsultaMedicaRoutes initConsultaMedica() {
        ConsultaMedicaRepository consultaMedicaRepo = new ConsultaMedicaRepository();
        ConsultaMedicaService consultaService = new ConsultaMedicaService(consultaMedicaRepo);
        ConsultaMedicaController consultaController = new ConsultaMedicaController(consultaService);
        return new ConsultaMedicaRoutes(consultaController);
    }

    public static MedidaFisiologicaRoutes initMedidaFisiologica() {
        MedidaFisiologicaRepository medidaFisiologicaRepo = new MedidaFisiologicaRepository();
        MedidaFisiologicaService medidaFisiologicaService = new MedidaFisiologicaService(medidaFisiologicaRepo);
        MedidaFisiologicaController medidaFisiologicaController = new MedidaFisiologicaController(medidaFisiologicaService);
        return new MedidaFisiologicaRoutes(medidaFisiologicaController);
    }


}
