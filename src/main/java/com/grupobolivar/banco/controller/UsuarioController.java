package com.grupobolivar.banco.controller;

import com.grupobolivar.banco.models.dto.UsuarioDTO;
import com.grupobolivar.banco.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("usuarios")
@RestController(value = "usuarioController")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDTOARetornar = usuarioService.createUsuario(usuarioDTO);
        return new ResponseEntity<UsuarioDTO>(usuarioDTOARetornar, HttpStatus.CREATED);
    }

    /**
     * getUsuarios: Consulta de todos los usuarios disponibles
     * @return List<Usuario>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO usuarioRespuestaDTO = usuarioService.updateUsuario(usuarioDTO);
            return new ResponseEntity<UsuarioDTO>(usuarioRespuestaDTO, HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<UsuarioDTO>(UsuarioDTO.builder().build(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=*/*", produces = "application/json")
    public void deleteUsuario(@PathVariable("id") Long id) {
        try {
            usuarioService.deleteUsuario(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
