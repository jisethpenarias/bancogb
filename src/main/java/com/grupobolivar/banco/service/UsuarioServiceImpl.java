package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.Usuario;
import com.grupobolivar.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    // Inyeccion de la interfaz del repositorio
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        // logica de negocio
        // logica de negocio
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
        // logica de negocio
        // logica de negocio
        // logica de negocio
        return listaDeUsuarios;
    }

}
