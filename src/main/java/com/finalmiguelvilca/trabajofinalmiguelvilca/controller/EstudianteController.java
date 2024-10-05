package com.finalmiguelvilca.trabajofinalmiguelvilca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.EstudianteDTO;
import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.GenericResponse;
import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Estudiante;
import com.finalmiguelvilca.trabajofinalmiguelvilca.service.IEstudianteService;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;
    @Qualifier("estudianteMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<EstudianteDTO>> getallEstudiantes(){
        List<EstudianteDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> getEstudianteById(@PathVariable("id") int id){
        Estudiante obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void>  save(@Valid @RequestBody EstudianteDTO dto){
        Estudiante obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEstudiante()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody EstudianteDTO dto){
        Estudiante obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private EstudianteDTO convertToDto(Estudiante obj) {
        return modelMapper.map(obj, EstudianteDTO.class);
    }

    private Estudiante convertToEntity(EstudianteDTO dto) {
        return modelMapper.map(dto, Estudiante.class);
    }
}
