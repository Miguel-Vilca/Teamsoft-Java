package com.finalmiguelvilca.trabajofinalmiguelvilca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.CursoDTO;
import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.GenericResponse;
import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Curso;
import com.finalmiguelvilca.trabajofinalmiguelvilca.service.ICursoService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final ICursoService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<CursoDTO>> getallCursos(){
        List<CursoDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> getCursoById(@PathVariable("id") int id){
        Curso obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CursoDTO dto){
        Curso obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody CursoDTO dto){
        Curso obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CursoDTO convertToDto(Curso obj) {
        return modelMapper.map(obj, CursoDTO.class);
    }

    private Curso convertToEntity(CursoDTO dto) {
        return modelMapper.map(dto, Curso.class);
    }
}
