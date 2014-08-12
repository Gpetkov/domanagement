package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.City;
import com.newintelligence.domanagement.datamodel.Region;
import com.newintelligence.domanagement.datamodel.User;

@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Integer postalCode;

    @NotNull
    private List<UserDto> employees;

    @NotNull
    private Region region;

    public CityDto(City city) {
	this.id = city.getId();
	this.name = city.getName();
	this.postalCode = city.getPostalCode();

	if (this.employees == null) {
	    this.employees = new ArrayList<UserDto>();
	}

	for (User user : city.getEmployees()) {
	    employees.add(new UserDto(user));
	}
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
	this.postalCode = postalCode;
    }

    public List<UserDto> getEmployees() {
	return employees;
    }

    public void setEmployees(List<UserDto> employees) {
	this.employees = employees;
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
    }
}
