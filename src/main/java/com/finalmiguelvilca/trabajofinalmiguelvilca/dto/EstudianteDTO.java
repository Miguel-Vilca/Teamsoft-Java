package com.finalmiguelvilca.trabajofinalmiguelvilca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

    private Integer idEstudiante;
    @NotNull
    @Size(min = 1, max = 50)
    private String nombresEstudiante;
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidosEstudiante;
    @NotNull
    @Size(min = 1, max = 8)
    private String dni;
    @NotNull
    private Integer edad;
}
