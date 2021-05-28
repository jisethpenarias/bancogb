package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.ConsignacionDTO;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.models.dto.RetiroDTO;

import java.util.List;

public interface TransaccionesService {

    String retirar(RetiroDTO retiroDTO);

    String consignar(ConsignacionDTO consignacionDTO);

    List<CuentaDTO> consultarSaldo(Long documentoCliente);

}
