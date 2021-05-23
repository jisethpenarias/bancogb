package com.grupobolivar.banco.models.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long usuarioId;
    private String usuario;
    private String contrasena;

}
