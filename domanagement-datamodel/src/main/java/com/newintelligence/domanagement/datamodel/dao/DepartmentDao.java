package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Long>{
}
