package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.ClienteDTO;
import com.grupobolivar.banco.models.mapper.ClienteMapper;
import com.grupobolivar.banco.repository.ClienteRepository;
import com.grupobolivar.banco.repository.ProcedureInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClienteDTO> getClientes() {
        return clienteMapper.clientesToClientesDTOs(clienteRepository.findAll());
    }

}
