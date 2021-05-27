package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.SucursalDTO;
import com.grupobolivar.banco.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("sucursales")
@RestController(value = "sucursalController")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<SucursalDTO>> getSucursales() {
        return new ResponseEntity<List<SucursalDTO>>(sucursalService.getSucursales(), HttpStatus.OK);
    }
}
