package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Region;

@Repository
public interface RegionDao extends CrudRepository<Region, Long> {

}
