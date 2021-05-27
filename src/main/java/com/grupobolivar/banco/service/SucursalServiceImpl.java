package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.Sucursal;
import com.grupobolivar.banco.models.dto.SucursalDTO;
import com.grupobolivar.banco.models.mapper.SucursalMapper;
import com.grupobolivar.banco.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "sucursalService")
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalMapper sucursalMapper;

    @Override
    public List<SucursalDTO> getSucursales() {

        List<Sucursal> sucursales = sucursalRepository.findAll();

        return sucursalMapper.sucursalesToSucursalesDTO(sucursales);
    }
}
