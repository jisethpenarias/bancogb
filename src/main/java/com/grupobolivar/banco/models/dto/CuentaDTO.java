package com.grupobolivar.banco.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CuentaDTO {

    private Long numeroCuenta;
    private String saldo;
    //private ClienteDTO cliente;
    private TipoCuentaDTO tipoCuenta;
}
