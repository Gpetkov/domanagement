package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Request;

@Repository
public interface RequestStatusDao extends CrudRepository<Request, Long> {

}
