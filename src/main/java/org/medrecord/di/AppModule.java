package org.medrecord.di;

import org.medrecord.controller.UserController;
import org.medrecord.service.UserService;
import org.medrecord.repository.UserRepository;
import org.medrecord.routes.UserRoutes;

public class AppModule {
    public static UserRoutes initUser() {
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        return new UserRoutes(userController);
    }
}

