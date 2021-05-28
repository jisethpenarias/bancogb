package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.ConsignacionDTO;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.models.dto.RetiroDTO;
import com.grupobolivar.banco.service.TransaccionesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("transacciones")
@RestController(value = "transaccionesController")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @RequestMapping(value = "/retirar", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<String> retirar(@RequestBody RetiroDTO retiroDTO){
        return new ResponseEntity<String>(transaccionesService.retirar(retiroDTO), HttpStatus.OK) ;
    }


    @RequestMapping(value = "/consignar", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<String> consignar(@RequestBody ConsignacionDTO consignacionDTO){
        return new ResponseEntity<String>(transaccionesService.consignar(consignacionDTO), HttpStatus.OK) ;
    }


    @RequestMapping(value = "/saldos/{documentoCliente}", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<CuentaDTO>> consultarSaldos(@PathVariable(value = "documentoCliente") Long documentoCliente){
        return new ResponseEntity<List<CuentaDTO>>(transaccionesService.consultarSaldo(documentoCliente), HttpStatus.OK);
    }



}
