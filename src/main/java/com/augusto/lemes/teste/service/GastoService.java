package com.augusto.lemes.teste.service;

import java.util.Date;
import java.util.List;

import com.augusto.lemes.teste.model.Gasto;

/**
 * 
 * @author Augusto Lemes
 * @since 29/11/2018
 * 
 * Service referente a Gastos.
 *
 */
public interface GastoService {
	
	List<Gasto> findByCodigoUsuario(Long codigoUsuario);
	
	List<Gasto> findByData(Date data);
	
	Gasto save(Gasto gasto);
	
	Iterable<Gasto> listGastos();

}
