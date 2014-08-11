package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.CrudRepository;

import com.newintelligence.domanagement.datamodel.User;

public interface UserDao extends CrudRepository<User, Long> {

}
