package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.ClienteCreateDTO;
import com.grupobolivar.banco.models.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> getClientes();

    ClienteDTO createCliente(ClienteCreateDTO clienteDTO);
}
