package com.flexpag.paymentscheduler.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class PagamentoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	private LocalDate dataAgendamento;
	
	@Column
	@NonNull
	private String hora;
		
	@Column
	@NonNull
	private Double valor;
	
	@Column
	private String status = "pending";
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	 
}
