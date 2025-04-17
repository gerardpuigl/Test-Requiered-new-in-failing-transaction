package com.example.testpropagationslevels.domain.repository;

import com.example.testpropagationslevels.domain.EntitySaved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<EntitySaved, Long> {
}
