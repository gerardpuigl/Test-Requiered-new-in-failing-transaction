package com.example.testpropagationslevels.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "entity")
public class EntitySaved {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "transaction_type", nullable = true)
	private String transaction;

}
