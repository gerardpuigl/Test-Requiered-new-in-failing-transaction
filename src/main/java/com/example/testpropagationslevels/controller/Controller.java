package com.example.testpropagationslevels.controller;

import com.example.testpropagationslevels.domain.EntitySaved;
import com.example.testpropagationslevels.domain.repository.EntityRepository;
import com.example.testpropagationslevels.service.RegularService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {

	private final RegularService regularService;

	private final EntityRepository repository;

	@PostMapping("/test")
	public List<EntitySaved> testPersistenceRollbackRequest(
			@RequestParam(value = "fail", defaultValue = "false") boolean fail) {

		try {
			this.regularService.testPersistenceInRollback(fail);
		} catch (final RuntimeException e) {
			System.out.println("Exception occurred: " + e);
		}
		return this.repository.findAll();
	}

}
