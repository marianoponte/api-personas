package com.reba.api.persona.service;

import com.reba.api.persona.model.Country;
import com.reba.api.persona.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public Optional<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }
}
