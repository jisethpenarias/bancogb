package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.Usuario;
import com.grupobolivar.banco.models.dto.UsuarioDTO;
import com.grupobolivar.banco.models.mapper.UsuarioMapper;
import com.grupobolivar.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    // Inyeccion de la interfaz del repositorio
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();

        /*
        List<UsuarioDTO> usuariosDTOS = listaDeUsuarios
                .stream()
                .map(usuario -> UsuarioDTO.builder().usuario(usuario.getUsuario()).contrasena(usuario.getContrasena()).build())
                .collect(Collectors.toList());
         */

        List<UsuarioDTO> usuariosDTOS = usuarioMapper.usuariosToUsuariosDTOs(listaDeUsuarios);

        return usuariosDTOS;
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
        usuario.setUltimoIngreso(LocalDateTime.now());

        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return usuarioMapper.usuarioToUsuarioDTO(usuarioCreado);
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Optional<Usuario> findUsuario = usuarioRepository.findById(usuarioDTO.getUsuarioId());

        if(!findUsuario.isPresent()) {
            throw new Exception("El usuario que quiere modificar no existe");
        }

        Usuario usuario = findUsuario.get();
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setContrasena(usuarioDTO.getContrasena());

        Usuario usuarioModificado = usuarioRepository.save(usuario);

        return usuarioMapper.usuarioToUsuarioDTO(usuarioModificado);
    }

    @Override
    public void deleteUsuario(Long id) throws Exception {
        Optional<Usuario> findUsuario = usuarioRepository.findById(id);

        if(!findUsuario.isPresent()) {
            throw new Exception("El usuario que quiere modificar no existe");
        }

        Usuario usuario = findUsuario.get();

        usuarioRepository.delete(usuario);
    }


}
