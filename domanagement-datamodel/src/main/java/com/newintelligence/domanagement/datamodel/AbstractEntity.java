package com.newintelligence.domanagement.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "date_created", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Version
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    public AbstractEntity() {
	this.dateCreated = new Date();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
	return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
	this.dateUpdated = dateUpdated;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
	result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	AbstractEntity other = (AbstractEntity) obj;
	if (dateCreated == null) {
	    if (other.dateCreated != null)
		return false;
	} else if (!dateCreated.equals(other.dateCreated))
	    return false;
	if (dateUpdated == null) {
	    if (other.dateUpdated != null)
		return false;
	} else if (!dateUpdated.equals(other.dateUpdated))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
}
