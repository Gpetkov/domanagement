package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;

import com.newintelligence.domanagement.datamodel.Request;

public interface RequestStatusDao extends CrudRepository<Request, Long> {

}
