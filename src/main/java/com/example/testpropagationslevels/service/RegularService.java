package com.example.testpropagationslevels.service;

import com.example.testpropagationslevels.domain.EntitySaved;
import com.example.testpropagationslevels.domain.repository.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegularService {

	private final EntityRepository repository;

	private final RollbackService rollbackService;

	@Transactional
	public void testPersistenceInRollback(boolean fail) {
		try {
			final EntitySaved entitySaved = EntitySaved.builder().transaction("REGULAR").build();
			this.repository.save(entitySaved);
			if (fail) {
				throw new RuntimeException("Error during regular operation");
			}
		} catch (final RuntimeException e) {
			System.out.println("Exception occurred. Persist alternative operation" + e);
			this.rollbackService.testPersistDuringRollbackInsideTransaction();
			throw e;
		}
	}
}
