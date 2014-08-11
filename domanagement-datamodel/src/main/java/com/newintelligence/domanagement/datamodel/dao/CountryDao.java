package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newintelligence.domanagement.datamodel.Country;

public interface CountryDao extends PagingAndSortingRepository<Country, Long> {
}