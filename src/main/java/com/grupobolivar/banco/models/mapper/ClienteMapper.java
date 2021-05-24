package com.grupobolivar.banco.models.mapper;

import com.grupobolivar.banco.models.Cliente;
import com.grupobolivar.banco.models.dto.ClienteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface ClienteMapper {

    Cliente clienteDTOToCliente(ClienteDTO clienteDTO);
    ClienteDTO clienteToClienteDTO(Cliente cliente);
    List<ClienteDTO> clientesToClientesDTOs(List<Cliente> clientes);

}
