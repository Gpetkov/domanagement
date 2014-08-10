package com.realintelligence.domanagement.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private Integer postalCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<User> employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    
    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
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
	City other = (City) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (postalCode == null) {
	    if (other.postalCode != null)
		return false;
	} else if (!postalCode.equals(other.postalCode))
	    return false;
	return true;
    }
}
