package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.TipoCuentaDTO;

import java.util.List;

public interface TipoCuentaService {

    List<TipoCuentaDTO> getTiposCuentas();
}
