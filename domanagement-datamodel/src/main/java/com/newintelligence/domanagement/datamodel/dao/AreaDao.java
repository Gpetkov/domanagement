package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Area;

@Repository
public interface AreaDao extends PagingAndSortingRepository<Area, Long> {
}