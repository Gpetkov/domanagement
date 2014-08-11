package com.newintelligence.domanagement.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_status_id")
    private RequestStatus requestStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_type_id")
    private RequestType requestType;

    public RequestType getRequestType() {
	return requestType;
    }

    public void setRequestType(RequestType requestType) {
	this.requestType = requestType;
    }

    public RequestStatus getRequestStatus() {
	return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
	this.requestStatus = requestStatus;
    }

    public Comment getComment() {
	return comment;
    }

    public void setComment(Comment comment) {
	this.comment = comment;
    }

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
