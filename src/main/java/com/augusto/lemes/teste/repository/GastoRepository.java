package com.augusto.lemes.teste.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.augusto.lemes.teste.model.Gasto;
/**
 * 
 * @author Augusto Lemes
 * @since 28/11/2019
 * 
 * Repositório referente a gastos.
 *
 */
@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {
	
	List<Gasto> findByCodigoUsuario(Long codigoUsuario);
	
	List<Gasto> findByData(Date data);
	

}
