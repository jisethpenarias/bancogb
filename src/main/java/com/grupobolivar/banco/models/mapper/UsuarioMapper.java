package com.grupobolivar.banco.models.mapper;

import com.grupobolivar.banco.models.Usuario;
import com.grupobolivar.banco.models.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> usuariosToUsuariosDTOs(List<Usuario> usuarios);

}
