package com.newintelligence.domanagement.datamodel.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.newintelligence.domanagement.datamodel.Address;

public interface AddressDao extends PagingAndSortingRepository<Address, Long> {
}
