package com.augusto.lemes.teste.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.lemes.teste.model.Gasto;
import com.augusto.lemes.teste.service.GastoService;

/**
 * 
 * @author Augusto Lemes
 * @since 27/11/2018
 * 
 * Serviços referentes a gastos com cartão.
 *
 */

@RestController
@RequestMapping("/api")
public class GastoController {
	
	@Autowired
	private GastoService gastoService;
	
	@PostMapping("/gastos")
	public Gasto createGasto(@RequestBody Gasto gasto) {
		Gasto savedGasto = gastoService.save(gasto);
		return savedGasto;
	}
	
	@GetMapping("/gastos")
	public Iterable<Gasto> listGastos() {
		Iterable<Gasto> gastos =  gastoService.listGastos();
		return gastos;
	}

	@GetMapping("/gastos/codigousuario/{codigoUsuario}")
	public List<Gasto> findGastosByCodigoUsuario(@PathVariable long codigoUsuario) {
		List<Gasto> gastos = gastoService.findByCodigoUsuario(codigoUsuario);
		return gastos;
	}

	
	@GetMapping("/gastos/data/{data}")
	public List<Gasto> findGastosByData(@PathVariable String data) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataParam = format.parse(data);
		List<Gasto> gastos = gastoService.findByData(dataParam);
		return gastos;
	}
	
}
