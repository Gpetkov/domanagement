package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.City;
import com.newintelligence.domanagement.datamodel.Region;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class RegionDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private List<CityDto> cities;

    private AreaDto area;

    private UserDto manager;

    public RegionDto(Region region) {
	this.id = region.getId();
	this.name = region.getName();
	this.area = new AreaDto(region.getArea());
	this.manager = new UserDto(region.getManager());

	if (this.cities == null) {
	    this.cities = new ArrayList<CityDto>();
	}

	for (City city : region.getCities()) {
	    cities.add(new CityDto(city));
	}
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public UserDto getManager() {
	return manager;
    }

    public void setManager(UserDto manager) {
	this.manager = manager;
    }

    public AreaDto getArea() {
	return area;
    }

    public void setArea(AreaDto area) {
	this.area = area;
    }

    public List<CityDto> getCities() {
	return cities;
    }

    public void setCities(List<CityDto> cities) {
	this.cities = cities;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	RegionDto other = (RegionDto) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }
}
