package com.finalmiguelvilca.trabajofinalmiguelvilca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {

    private Integer idCurso;
    @NotNull
    @Size(min = 1, max = 20)
    private String nombre;
    @NotNull
    @Size(min = 1, max = 10)
    private String siglas;
    @NotNull
    private boolean estado;
}
