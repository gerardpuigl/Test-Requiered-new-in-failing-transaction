package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.domain.EntitySaved;
import com.example.testpropagationslevels.domain.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RollbackService {

	private final EntityRepository repository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testPersistDuringRollbackInsideTransaction() {
		final EntitySaved entitySaved = EntitySaved.builder().transaction("ROLLBACK using REQUIRES_NEW").build();
		this.repository.save(entitySaved);
	}

}
