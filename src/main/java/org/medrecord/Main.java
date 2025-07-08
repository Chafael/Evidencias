package org.medrecord;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import org.medrecord.di.AppModule;
import org.medrecord.routes.UserRoutes;


public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(CorsPluginConfig.CorsRule::anyHost);
            });
        }).start(7000);

        app.get("/", ctx -> ctx.result("API Javalin 2"));

        AppModule.initUser().register(app);
    }
}
