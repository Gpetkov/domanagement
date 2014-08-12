package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.Address;
import com.newintelligence.domanagement.datamodel.User;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class AddressDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String street;

    private Integer building;

    private Integer floor;

    private String entrance;

    private List<UserDto> employees;

    public AddressDto(Address address) {
	this.id = address.getId();
	this.street = address.getStreet();
	this.floor = address.getFloor();
	this.entrance = address.getEntrance();
	if (employees == null) {
	    employees = new ArrayList<UserDto>();
	}
	for (User user : address.getEmployees()) {
	    employees.add(new UserDto(user));
	}
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<UserDto> getEmployees() {
	return employees;
    }

    public void setEmployees(List<UserDto> employees) {
	this.employees = employees;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public Integer getBuilding() {
	return building;
    }

    public void setBuilding(Integer building) {
	this.building = building;
    }

    public Integer getFloor() {
	return floor;
    }

    public void setFloor(Integer floor) {
	this.floor = floor;
    }

    public String getEntrance() {
	return entrance;
    }

    public void setEntrance(String entrance) {
	this.entrance = entrance;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((building == null) ? 0 : building.hashCode());
	result = prime * result + ((entrance == null) ? 0 : entrance.hashCode());
	result = prime * result + ((floor == null) ? 0 : floor.hashCode());
	result = prime * result + ((street == null) ? 0 : street.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AddressDto other = (AddressDto) obj;
	if (building == null) {
	    if (other.building != null)
		return false;
	} else if (!building.equals(other.building))
	    return false;
	if (entrance == null) {
	    if (other.entrance != null)
		return false;
	} else if (!entrance.equals(other.entrance))
	    return false;
	if (floor == null) {
	    if (other.floor != null)
		return false;
	} else if (!floor.equals(other.floor))
	    return false;
	if (street == null) {
	    if (other.street != null)
		return false;
	} else if (!street.equals(other.street))
	    return false;
	return true;
    }
}
