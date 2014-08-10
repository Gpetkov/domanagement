package com.realintelligence.domanagement.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class User extends AbstractEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
	result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	User other = (User) obj;
	if (emailAddress == null) {
	    if (other.emailAddress != null)
		return false;
	} else if (!emailAddress.equals(other.emailAddress))
	    return false;
	if (endDate == null) {
	    if (other.endDate != null)
		return false;
	} else if (!endDate.equals(other.endDate))
	    return false;
	if (firstName == null) {
	    if (other.firstName != null)
		return false;
	} else if (!firstName.equals(other.firstName))
	    return false;
	if (isActive == null) {
	    if (other.isActive != null)
		return false;
	} else if (!isActive.equals(other.isActive))
	    return false;
	if (lastName == null) {
	    if (other.lastName != null)
		return false;
	} else if (!lastName.equals(other.lastName))
	    return false;
	if (secondName == null) {
	    if (other.secondName != null)
		return false;
	} else if (!secondName.equals(other.secondName))
	    return false;
	if (startDate == null) {
	    if (other.startDate != null)
		return false;
	} else if (!startDate.equals(other.startDate))
	    return false;
	if (username == null) {
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }
}
