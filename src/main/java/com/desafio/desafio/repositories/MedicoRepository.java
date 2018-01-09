package com.desafio.desafio.repositories;

import com.desafio.desafio.models.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, String> {
}
