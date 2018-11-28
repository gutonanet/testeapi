package com.augusto.lemes.teste.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Augusto Lemes
 * @since 27/11/2018
 * 
 * Bean referente a Gastos.
 * 
 */

@Entity
public class Gasto {
	
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private Double valor;
	private Long codigoUsuario;
	@Temporal(value = TemporalType.DATE)
	private Date data;
	
	
	public Gasto() {
		super();
	}
	
	public Gasto(Long id, String descricao, Double valor, Long codigoUsuario, Date data) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.codigoUsuario = codigoUsuario;
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
