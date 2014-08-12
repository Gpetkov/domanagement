package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.Area;
import com.newintelligence.domanagement.datamodel.Region;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class AreaDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;

    private List<RegionDto> regions;

    private CountryDto country;

    private UserDto manager;

    private UserDto humanResource;

    public AreaDto(Area area) {
	this.id = area.getId();
	this.name = area.getName();
	this.manager = new UserDto(area.getManager());
	this.humanResource = new UserDto(area.getHumanResource());
	this.country = new CountryDto(area.getCountry());

	if (regions == null) {
	    regions = new ArrayList<RegionDto>();
	}

	for (Region region : area.getRegions()) {
	    regions.add(new RegionDto(region));
	}
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public UserDto getHumanResource() {
	return humanResource;
    }

    public void setHumanResource(UserDto humanResource) {
	this.humanResource = humanResource;
    }

    public UserDto getManager() {
	return manager;
    }

    public void setManager(UserDto manager) {
	this.manager = manager;
    }

    public CountryDto getCountry() {
	return country;
    }

    public void setCountry(CountryDto country) {
	this.country = country;
    }

    public List<RegionDto> getRegions() {
	return regions;
    }

    public void setRegions(List<RegionDto> regions) {
	this.regions = regions;
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
	AreaDto other = (AreaDto) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }
}
