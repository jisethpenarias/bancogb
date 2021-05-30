package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cuentas")
@RestController(value = "cuentaController")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @CrossOrigin
    @RequestMapping(value = "/{idCliente}", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<CuentaDTO>> getCuentasCliente(@PathVariable(name = "idCliente") Long idCliente) {
        return new ResponseEntity<List<CuentaDTO>>(cuentaService.getCuentasCliente(idCliente), HttpStatus.OK);
    }

}
