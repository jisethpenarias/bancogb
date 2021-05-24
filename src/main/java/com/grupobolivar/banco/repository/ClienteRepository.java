package com.grupobolivar.banco.repository;

import com.grupobolivar.banco.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "clienteRepository")
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
