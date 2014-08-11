package com.newintelligence.domanagement.datamodel;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class User extends AbstractEntity {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id")
    private Education education;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "manager")
    private Region manageRegion;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "manager")
    private Area manageArea;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "humanResource")
    private Area hrArea;

    @ManyToMany
    @JoinTable(name = "employee_to_address", joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(name = "user_to_role", joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Comment> comments;

    public List<Comment> getComments() {
	return comments;
    }

    public void setComments(List<Comment> comments) {
	this.comments = comments;
    }

    public List<Role> getRoles() {
	return roles;
    }

    public void setRoles(List<Role> roles) {
	this.roles = roles;
    }

    public List<Address> getAddresses() {
	return addresses;
    }

    public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
    }

    public Area getHrArea() {
	return hrArea;
    }

    public void setHrArea(Area hrArea) {
	this.hrArea = hrArea;
    }

    public Area getManageArea() {
	return manageArea;
    }

    public void setManageArea(Area manageArea) {
	this.manageArea = manageArea;
    }

    public Region getManageRegion() {
	return manageRegion;
    }

    public void setManageRegion(Region manageRegion) {
	this.manageRegion = manageRegion;
    }

    public Education getEducation() {
	return education;
    }

    public void setEducation(Education education) {
	this.education = education;
    }

    public Department getDepartment() {
	return department;
    }

    public void setDepartment(Department department) {
	this.department = department;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getSecondName() {
	return secondName;
    }

    public void setSecondName(String secondName) {
	this.secondName = secondName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public City getCity() {
	return city;
    }

    public void setCity(City city) {
	this.city = city;
    }

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
