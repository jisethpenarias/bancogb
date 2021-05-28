package com.grupobolivar.banco.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TIPO_CUENTA")
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_CUENTA_ID")
    private Long tipoCuentaId;

    @Column(name = "TASA")
    private Double tasa;

    @Column(name = "NOMBRE")
    private String nombre;
}
