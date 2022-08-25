package com.reba.api.persona.repository;

import com.reba.api.persona.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findByName(String name);

}
