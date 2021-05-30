package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.Cliente;
import com.grupobolivar.banco.models.dto.ClienteDTO;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.models.mapper.ClienteMapper;
import com.grupobolivar.banco.models.mapper.CuentaMapper;
import com.grupobolivar.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "cuentaService")
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaMapper cuentaMapper;


    @Transactional
    @Override
    public List<CuentaDTO> getCuentasCliente(Long idCliente) {
        Cliente cliente = clienteRepository.getOne(idCliente);
        return cuentaMapper.cuentasToCuentasDTOs(cliente.getCuentas());
    }
}
