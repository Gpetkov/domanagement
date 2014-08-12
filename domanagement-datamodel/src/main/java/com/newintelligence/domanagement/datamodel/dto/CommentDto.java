package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.Comment;

@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private UserDto employee;

    private RequestDto request;

    public CommentDto(Comment comment) {
	this.id = comment.getId();
	this.content = comment.getContent();
	this.employee = new UserDto(comment.getEmployee());
	this.request = new RequestDto(comment.getRequest());
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public RequestDto getRequest() {
	return request;
    }

    public void setRequest(RequestDto request) {
	this.request = request;
    }

    public UserDto getEmployee() {
	return employee;
    }

    public void setEmployee(UserDto employee) {
	this.employee = employee;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((content == null) ? 0 : content.hashCode());
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
	CommentDto other = (CommentDto) obj;
	if (content == null) {
	    if (other.content != null)
		return false;
	} else if (!content.equals(other.content))
	    return false;
	return true;
    }
}
