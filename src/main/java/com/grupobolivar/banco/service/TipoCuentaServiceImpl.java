package com.grupobolivar.banco.service;


import com.grupobolivar.banco.models.TipoCuenta;
import com.grupobolivar.banco.models.dto.TipoCuentaDTO;
import com.grupobolivar.banco.models.mapper.TipoCuentaMapper;
import com.grupobolivar.banco.repository.TipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tipoCuentaService")
public class TipoCuentaServiceImpl  implements TipoCuentaService {

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    private TipoCuentaMapper tipoCuentaMapper;


    @Override
    public List<TipoCuentaDTO> getTiposCuentas() {
        List<TipoCuenta> tiposCuentas = tipoCuentaRepository.findAll();

        return tipoCuentaMapper.tiposCuentasToTiposCuentasDTO(tiposCuentas);
    }
}
