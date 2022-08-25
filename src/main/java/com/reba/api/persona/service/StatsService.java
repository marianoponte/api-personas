package com.reba.api.persona.service;

import com.reba.api.persona.dto.StatsDTO;
import com.reba.api.persona.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsService {

    @Autowired
    private CountryService countryService;

    @Autowired
    private PersonService personService;

    public List<StatsDTO> getStats() {
        List<StatsDTO> stats = new ArrayList<>();
        List<Country> countries = countryService.findAll();
        stats = countries.stream()
                .map(country -> new StatsDTO(country.getName(), getPercentageByCountry(country)))
                .collect(Collectors.toList());
        return stats;
    }

    private String getPercentageByCountry(Country country) {
        Long countPeople = personService.getCountPeople();
        Long countPeopleByCountry = personService.getCountPeopleByCountry(country);
        if (countPeopleByCountry.longValue() == 0) {
            return "0,00";
        }
        double percentajeDouble = (countPeopleByCountry.doubleValue() / countPeople.doubleValue()) * 100;
        return String.format("%.2f", percentajeDouble);
    }
}
