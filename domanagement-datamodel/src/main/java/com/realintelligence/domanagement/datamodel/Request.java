package com.realintelligence.domanagement.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {
    @Column(name = "year")
    private Integer year;

    @Column(name = "month")
    private Integer month;

    @Column(name = "list_of_days")
    private String listOfDays;

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getMonth() {
	return month;
    }

    public void setMonth(Integer month) {
	this.month = month;
    }

    public String getListOfDays() {
	return listOfDays;
    }

    public void setListOfDays(String listOfDays) {
	this.listOfDays = listOfDays;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((listOfDays == null) ? 0 : listOfDays.hashCode());
	result = prime * result + ((month == null) ? 0 : month.hashCode());
	result = prime * result + ((year == null) ? 0 : year.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Request other = (Request) obj;
	if (listOfDays == null) {
	    if (other.listOfDays != null)
		return false;
	} else if (!listOfDays.equals(other.listOfDays))
	    return false;
	if (month == null) {
	    if (other.month != null)
		return false;
	} else if (!month.equals(other.month))
	    return false;
	if (year == null) {
	    if (other.year != null)
		return false;
	} else if (!year.equals(other.year))
	    return false;
	return true;
    }
}
