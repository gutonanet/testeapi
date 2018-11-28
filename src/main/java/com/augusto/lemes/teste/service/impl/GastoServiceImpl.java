package com.augusto.lemes.teste.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.lemes.teste.model.Gasto;
import com.augusto.lemes.teste.repository.GastoRepository;
import com.augusto.lemes.teste.service.GastoService;

@Service
public class GastoServiceImpl implements GastoService {
	
	@Autowired
	private GastoRepository repository;
	
	public List<Gasto> findByCodigoUsuario(Long codigoUsuario){
		return repository.findByCodigoUsuario(codigoUsuario);
	}
	
	public List<Gasto> findByData(Date data){
		return repository.findByData(data);
	}
	
	public Gasto save(Gasto gasto) {
		return repository.save(gasto);
	}
	
	public Iterable<Gasto> listGastos() {
		Iterable<Gasto> gastos =  repository.findAll();
		return gastos;
	}
	
	

}
