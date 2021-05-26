package com.grupobolivar.banco.repository;


import com.grupobolivar.banco.models.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "tipoCuentaRepository")
@Transactional
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
}
