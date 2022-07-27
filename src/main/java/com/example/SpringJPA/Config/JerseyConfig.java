package com.example.SpringJPA.Config;

import com.example.SpringJPA.Controller.RegionController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component //Will be checked by spring when the app starts to run
public class JerseyConfig extends ResourceConfig {
    //Each Controller must be register here
    public JerseyConfig(){

        register(RegionController.class);
    }
}
