package com.grupobolivar.banco.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsignacionDTO {

    private Long cuentaNumeroOrigen;
    private Long cuentaNumeroDestino;
    private Long valor;

}
