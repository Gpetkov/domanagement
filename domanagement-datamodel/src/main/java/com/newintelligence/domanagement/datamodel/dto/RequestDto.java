package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.Request;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class RequestDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer year;

    private Integer month;

    private String listOfDays;

    private CommentDto comment;

    private RequestStatusDto requestStatus;

    private RequestTypeDto requestType;

    public RequestDto(Request request) {
	this.id = request.getId();
	this.year = request.getYear();
	this.month = request.getMonth();
	// TODO: Consider using builder pattern for this later
	this.listOfDays = request.getListOfDays();
	this.comment = new CommentDto(request.getComment());
	this.requestStatus = new RequestStatusDto(request.getRequestStatus());
	this.requestType = new RequestTypeDto(request.getRequestType());
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public RequestTypeDto getRequestType() {
	return requestType;
    }

    public void setRequestType(RequestTypeDto requestType) {
	this.requestType = requestType;
    }

    public RequestStatusDto getRequestStatus() {
	return requestStatus;
    }

    public void setRequestStatus(RequestStatusDto requestStatus) {
	this.requestStatus = requestStatus;
    }

    public CommentDto getComment() {
	return comment;
    }

    public void setComment(CommentDto comment) {
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
	RequestDto other = (RequestDto) obj;
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
