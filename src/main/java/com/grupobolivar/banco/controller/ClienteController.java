package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.ClienteCreateDTO;
import com.grupobolivar.banco.models.dto.ClienteDTO;
import com.grupobolivar.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("clientes")
@RestController(value = "clienteController")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<ClienteDTO>> getUsuarios() {
        return new ResponseEntity<List<ClienteDTO>>(clienteService.getClientes(), HttpStatus.OK);
    }


    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteCreateDTO clienteDTO) {
        return new ResponseEntity<ClienteDTO>(clienteService.createCliente(clienteDTO), HttpStatus.OK);
    }

}
