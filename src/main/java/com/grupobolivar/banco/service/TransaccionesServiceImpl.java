package com.grupobolivar.banco.service;

import com.grupobolivar.banco.models.dto.ConsignacionDTO;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.models.dto.RetiroDTO;
import com.grupobolivar.banco.models.mapper.CuentaMapper;
import com.grupobolivar.banco.repository.ProcedureInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "transaccionesService")
public class TransaccionesServiceImpl implements TransaccionesService {

    @Autowired
    private ProcedureInvoker procedureInvoker;

    @Autowired
    private CuentaMapper cuentaMapper;

    @Override
    public String retirar(RetiroDTO retiroDTO) {
        return procedureInvoker.invokeRetirarProcedure(retiroDTO);
    }

    @Override
    public String consignar(ConsignacionDTO consignacionDTO) {
        return procedureInvoker.invokeConsignarProcedure(consignacionDTO);
    }

    @Override
    public List<CuentaDTO> consultarSaldo(Long documentoCliente) {
        return cuentaMapper.cuentasToCuentasDTOs(procedureInvoker.invokeConsultaSaldoProcedure(documentoCliente));
    }
}
