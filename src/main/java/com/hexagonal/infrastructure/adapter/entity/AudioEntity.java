package com.hexagonal.infrastructure.adapter.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "audios")
public class AudioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String url;
}
