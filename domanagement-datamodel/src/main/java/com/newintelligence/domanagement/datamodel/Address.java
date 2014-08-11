package com.newintelligence.domanagement.datamodel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends AbstractEntity {
    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private Integer building;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "entrance")
    private String entrance;

    @ManyToMany(mappedBy = "addresses")
    private List<User> employees;

    public List<User> getEmployees() {
	return employees;
    }

    public void setEmployees(List<User> employees) {
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
	Address other = (Address) obj;
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
