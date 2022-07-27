package com.example.SpringJPA.Config;

import com.example.SpringJPA.Controller.RegionController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(RegionController.class);
    }
}
