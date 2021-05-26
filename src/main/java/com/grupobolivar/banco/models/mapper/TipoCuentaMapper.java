package com.grupobolivar.banco.models.mapper;


import com.grupobolivar.banco.models.TipoCuenta;
import com.grupobolivar.banco.models.dto.TipoCuentaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCuentaMapper {

    TipoCuenta tipoCuentaDTOToTipoCuenta(TipoCuentaDTO tipoCuentaDTO);
    TipoCuentaDTO tiposCuentasToTiposCuentasDTO(TipoCuenta tipoCuenta);
    List<TipoCuentaDTO> tiposCuentasToTiposCuentasDTO(List<TipoCuenta> tipoCuentas);

}
