package com.grupobolivar.banco.models.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoCuentaDTO {

    private Long tipoCuentaId;
    private Double tasa;
    private String nombre;
}
