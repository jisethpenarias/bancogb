package com.grupobolivar.banco.repository;

import com.grupobolivar.banco.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "sucursalRepository")
@Transactional
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
