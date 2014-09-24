package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.City;

@Repository
public interface CityDao extends PagingAndSortingRepository<City, Long> {
}