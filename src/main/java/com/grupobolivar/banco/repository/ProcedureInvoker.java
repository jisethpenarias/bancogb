package com.grupobolivar.banco.repository;

import com.grupobolivar.banco.models.Cuenta;
import com.grupobolivar.banco.models.dto.ConsignacionDTO;
import com.grupobolivar.banco.models.dto.CuentaDTO;
import com.grupobolivar.banco.models.dto.RetiroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
@Transactional
public class ProcedureInvoker {

    @Autowired
    private EntityManager entityManager;

    public String invokeRetirarProcedure(RetiroDTO retiroDTO){
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("BANCOGB.RETIRODECUENTA");
        storedProcedureQuery.registerStoredProcedureParameter("IN_NUMERO_DE_CUENTA", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("IN_VALOR_RETIRO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("IN_NUMERO_DE_CUENTA",retiroDTO.getCuentaNumero());
        storedProcedureQuery.setParameter("IN_VALOR_RETIRO",retiroDTO.getValorRetiro());

        storedProcedureQuery.execute();

        return (String) storedProcedureQuery.getOutputParameterValue("OUT_RESPUESTA");
    }

    public String invokeConsignarProcedure(ConsignacionDTO consignacionDTO){
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("BANCOGB.CONSIGNACION");
        storedProcedureQuery.registerStoredProcedureParameter("IN_NUMERO_DE_CUENTA_ORIGEN", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("IN_NUMERO_DE_CUENTA_DESTINO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("IN_VALOR", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("IN_NUMERO_DE_CUENTA_ORIGEN", consignacionDTO.getCuentaNumeroOrigen());
        storedProcedureQuery.setParameter("IN_NUMERO_DE_CUENTA_DESTINO", consignacionDTO.getCuentaNumeroDestino());
        storedProcedureQuery.setParameter("IN_VALOR",consignacionDTO.getValor());

        storedProcedureQuery.execute();

        return (String) storedProcedureQuery.getOutputParameterValue("OUT_RESPUESTA");
    }

    public List<Cuenta> invokeConsultaSaldoProcedure(Long documentoCliente){
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("BANCOGB.CONSULTADESALDO", "CuentaResult");
        storedProcedureQuery.registerStoredProcedureParameter("IN_CLIENTE_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("OUT_CUENTAS", void.class, ParameterMode.REF_CURSOR);

        storedProcedureQuery.setParameter("IN_CLIENTE_ID", documentoCliente);
        storedProcedureQuery.execute();

        List<Cuenta> cuentas = storedProcedureQuery.getResultList();
        return cuentas;
    }



}
