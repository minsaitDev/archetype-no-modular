package com.hexagonal.infrastructure.adapter.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "tasks")
public class TaskMongoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
	private String description;
	private boolean completed;
	private LocalDateTime dateOfCreation;
	private int timeRequiredToComplete;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "taskEntities")
	@JsonIgnore
	private Set<UserEntity> userEntities = new HashSet<>();

	public TaskMongoEntity(String id) {
		this.id = id;
	}

	public void setInitialValues() {
		this.completed = false;
		this.dateOfCreation = LocalDateTime.now();
	}

}
