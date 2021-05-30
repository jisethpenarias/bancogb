package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {

    List<CuentaDTO> getCuentasCliente(Long idCliente);

}
