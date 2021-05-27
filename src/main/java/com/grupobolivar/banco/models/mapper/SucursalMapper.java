package com.grupobolivar.banco.models.mapper;

import com.grupobolivar.banco.models.Sucursal;
import com.grupobolivar.banco.models.dto.SucursalDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    Sucursal sucursalDTOToSucursal(SucursalDTO sucursalDTO);
    SucursalDTO sucursalToSucursalDTO(Sucursal sucursal);
    List<SucursalDTO> sucursalesToSucursalesDTO(List<Sucursal> sucursales);

}
