package com.finalmiguelvilca.trabajofinalmiguelvilca.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {
    private Integer idDetalleMatricula;
    @NotNull
    private CursoDTO curso;
    @JsonBackReference
    private MatriculaDTO matricula;
    @NotNull
    private String aula;
}
