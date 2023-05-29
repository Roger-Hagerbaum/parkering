package com.rogerhagerbaum.parkerning.config;


import org.geolatte.geom.json.GeolatteGeomModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class parkingConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    GeolatteGeomModule geolatteModule(){return new GeolatteGeomModule();}
}

