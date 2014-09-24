package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.RequestType;

@Repository
public interface RequestTypeDao extends CrudRepository<RequestType, Long> {

}
