package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Education;

@Repository
public interface EducationDao extends CrudRepository<Education, Long> {

}
