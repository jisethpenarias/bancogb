package com.grupobolivar.banco.models.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDTO {

    private Long sucursalId;
    private String nombre;
    private String direccion;
    private Long telefono;

}
