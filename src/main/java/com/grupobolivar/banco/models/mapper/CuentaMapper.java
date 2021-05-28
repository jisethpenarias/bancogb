package com.grupobolivar.banco.models.mapper;

import com.grupobolivar.banco.models.Cuenta;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, TipoCuentaMapper.class})
public interface CuentaMapper {

    Cuenta cuentaDTOToCuenta(CuentaDTO cuentaDTO);

    CuentaDTO cuentaToCuentaDTO(Cuenta cuenta);

    List<CuentaDTO> cuentasToCuentasDTOs(List<Cuenta> cuentas);

}
