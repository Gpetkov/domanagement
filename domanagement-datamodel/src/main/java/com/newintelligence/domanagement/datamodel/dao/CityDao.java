package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newintelligence.domanagement.datamodel.City;

public interface CityDao extends PagingAndSortingRepository<City, Long> {
}