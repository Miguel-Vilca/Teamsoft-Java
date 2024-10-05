package com.finalmiguelvilca.trabajofinalmiguelvilca.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.EstudianteDTO;
import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Estudiante;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "estudianteMapper")
    public ModelMapper estudianteMapper() {
        ModelMapper mapper = new ModelMapper();

        //Escritura POST PUT
        mapper.createTypeMap(EstudianteDTO.class, Estudiante.class)
                .addMapping(EstudianteDTO::getNombresEstudiante, (dest, v) -> dest.setNombres((String) v))
                .addMapping(EstudianteDTO::getApellidosEstudiante, (dest, v) -> dest.setApellidos((String) v));

        //Lectura GET
        mapper.createTypeMap(Estudiante.class, EstudianteDTO.class)
                .addMapping(Estudiante::getNombres, (dest, v) -> dest.setNombresEstudiante((String) v))
                .addMapping(Estudiante::getApellidos, (dest, v) -> dest.setApellidosEstudiante((String) v));

        return mapper;
    }

}
