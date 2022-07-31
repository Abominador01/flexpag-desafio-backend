package com.flexpag.paymentscheduler.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flexpag.paymentscheduler.model.PagamentoModel;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> {

	List<PagamentoModel> findAllByStatusContainingIgnoreCase(String status);

	
}
