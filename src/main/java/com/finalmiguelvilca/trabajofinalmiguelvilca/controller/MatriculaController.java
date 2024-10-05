package com.finalmiguelvilca.trabajofinalmiguelvilca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.GenericResponse;
import com.finalmiguelvilca.trabajofinalmiguelvilca.dto.MatriculaDTO;
import com.finalmiguelvilca.trabajofinalmiguelvilca.model.Matricula;
import com.finalmiguelvilca.trabajofinalmiguelvilca.service.IMatriculaService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<MatriculaDTO>> getallMatriculas(){
        List<MatriculaDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> getMatriculaById(@PathVariable("id") int id){
        Matricula obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void>  save(@Valid @RequestBody MatriculaDTO dto){
        Matricula obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMatricula()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody MatriculaDTO dto){
        Matricula obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private MatriculaDTO convertToDto(Matricula obj) {
        return modelMapper.map(obj, MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto) {
        return modelMapper.map(dto, Matricula.class);
    }
}
