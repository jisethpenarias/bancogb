package com.grupobolivar.banco.repository;

import com.grupobolivar.banco.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "usuarioRepository")
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
