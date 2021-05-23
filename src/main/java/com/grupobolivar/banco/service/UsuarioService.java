package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> getUsuarios();

    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) throws Exception;

    void deleteUsuario(Long id) throws Exception;
}
