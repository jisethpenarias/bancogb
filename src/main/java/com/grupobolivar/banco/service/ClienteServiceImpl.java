package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.Cliente;
import com.grupobolivar.banco.models.Usuario;
import com.grupobolivar.banco.models.dto.ClienteCreateDTO;
import com.grupobolivar.banco.models.dto.ClienteDTO;
import com.grupobolivar.banco.models.mapper.ClienteMapper;
import com.grupobolivar.banco.repository.ClienteRepository;
import com.grupobolivar.banco.repository.ProcedureInvoker;
import com.grupobolivar.banco.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> getClientes() {
        return clienteMapper.clientesToClientesDTOs(clienteRepository.findAll());
    }

    @Transactional
    @Override
    public ClienteDTO createCliente(ClienteCreateDTO clienteDTO) {
        // validaciones sobre  el cliente DTO
        Cliente cliente = clienteMapper.clienteCreateDTOToCliente(clienteDTO);

        Usuario usuario = usuarioRepository.save(
                Usuario.builder()
                        .usuario(clienteDTO.getPrimerNombre().substring(0,3) + clienteDTO.getPrimerApellido().substring(0,3))
                        .contrasena( String.valueOf((int) Math.floor(Math.random()*(100000-999+1)+999)))
                        .ultimoIngreso(LocalDateTime.now()).build());
        cliente.setUsuario(usuario);

        return clienteMapper.clienteToClienteDTO(clienteRepository.save(cliente));
    }

}
