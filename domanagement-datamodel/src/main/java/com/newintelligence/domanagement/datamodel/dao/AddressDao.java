package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.newintelligence.domanagement.datamodel.Address;

@Repository
public interface AddressDao extends PagingAndSortingRepository<Address, Long> {
}
