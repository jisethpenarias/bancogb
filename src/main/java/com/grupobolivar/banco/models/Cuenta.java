package com.grupobolivar.banco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// Anotaciones de Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(
        name="CuentaResult",
        entities = @EntityResult(
                entityClass = Cuenta.class,
                fields = {
                    @FieldResult(name = "numeroCuenta", column = "NUMERO_CUENTA"),
                    @FieldResult(name = "saldo", column = "SALDO"),
                    @FieldResult(name = "cliente", column = "CLIENTE_ID"),
                    @FieldResult(name = "tipoCuenta", column = "TIPO_CUENTA_ID")
                }
        )
        )
// Anotaciones de JPA
@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @Column(name = "NUMERO_CUENTA")
    private Long numeroCuenta;

    @Column(name = "SALDO")
    private Double saldo;

    @ManyToOne()
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "TIPO_CUENTA_ID")
    private TipoCuenta tipoCuenta ;

}
