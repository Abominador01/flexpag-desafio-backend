package com.flexpag.paymentscheduler.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flexpag.paymentscheduler.model.PagamentoModel;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;

@RestController
@RequestMapping("/PagamentoModel")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<PagamentoModel>> findAll(){
		List<PagamentoModel> pagamentoModel = pagamentoRepository.findAll();
		
		return ResponseEntity.ok().body(pagamentoModel);
	}
	
	@GetMapping("status/{status}")
	public ResponseEntity<List<PagamentoModel>> getByStatus(@PathVariable String status){
		return ResponseEntity.ok(pagamentoRepository.findAllByStatusContainingIgnoreCase(status));
	}
	
	@PostMapping
	public  ResponseEntity<PagamentoModel> post(@Validated @RequestBody PagamentoModel pagamento){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pagamentoRepository.save(pagamento));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PagamentoModel> update(@PathVariable Long id, @RequestBody PagamentoModel pagamento){
				
	if(!pagamentoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	pagamento.setId(id);
	pagamento = pagamentoRepository.save(pagamento);
	return ResponseEntity.ok(pagamento);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
	if(!pagamentoRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
	}
	
	pagamentoRepository.deleteById(id);
	return ResponseEntity.noContent().build();
	
	}
}
