package com.flexpag.paymentscheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.model.PagamentoModel;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	
	public List<PagamentoModel>findAll(){
		return pagamentoRepository.findAll();
	}
	
	
	public Optional<PagamentoModel>getPaymentById(Long id){
		return pagamentoRepository.findById(id);
	}
			
	
	public void deletePayment(Long id) {
		pagamentoRepository.deleteById(id);
	}
}
