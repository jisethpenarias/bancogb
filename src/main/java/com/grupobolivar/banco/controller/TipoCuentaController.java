package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.TipoCuentaDTO;
import com.grupobolivar.banco.service.TipoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("tipoCuentas")
@RestController(value = "tipoCuentaController")
public class TipoCuentaController {

    @Autowired
    private TipoCuentaService tipoCuentaService;

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<TipoCuentaDTO>> getTipoCuentas(){
      return new ResponseEntity<List<TipoCuentaDTO>>(tipoCuentaService.getTiposCuentas(), HttpStatus.OK);
    }
}
