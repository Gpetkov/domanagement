package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Country;

@Repository
public interface CountryDao extends PagingAndSortingRepository<Country, Long> {
}