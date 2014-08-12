package com.newintelligence.domanagement.datamodel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.newintelligence.domanagement.datamodel.Address;
import com.newintelligence.domanagement.datamodel.Role;
import com.newintelligence.domanagement.datamodel.User;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class UserDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @Email
    private String emailAddress;

    @NotNull
    private Boolean isActive;

    @DateTimeFormat
    private Date startDate;

    @DateTimeFormat
    private Date endDate;

    @NotNull
    private CityDto city;

    @NotNull
    private DepartmentDto department;

    @NotNull
    private EducationDto education;

    @NotNull
    private RegionDto manageRegion;

    @NotNull
    private AreaDto manageArea;

    @NotNull
    private AreaDto hrArea;

    @NotNull
    private List<AddressDto> addresses;

    @NotNull
    private List<RoleDto> roles;

    public UserDto(User user) {
	this.id = user.getId();
	this.firstName = user.getFirstName();
	this.secondName = user.getSecondName();
	this.lastName = user.getLastName();
	this.username = user.getUsername();
	this.emailAddress = user.getEmailAddress();
	this.isActive = user.getIsActive();
	this.startDate = user.getStartDate();
	this.endDate = user.getEndDate();
	this.city = new CityDto(user.getCity());
	this.department = new DepartmentDto(user.getDepartment());
	this.education = new EducationDto(user.getEducation());
	this.manageRegion = new RegionDto(user.getManageRegion());
	this.manageArea = new AreaDto(user.getManageArea());
	this.hrArea = new AreaDto(user.getHrArea());

	if (addresses == null) {
	    addresses = new ArrayList<AddressDto>();
	}

	for (Address address : user.getAddresses()) {
	    addresses.add(new AddressDto(address));
	}

	if (roles == null) {
	    roles = new ArrayList<RoleDto>();
	}

	for (Role role : user.getRoles()) {
	    roles.add(new RoleDto(role));
	}
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public CityDto getCity() {
	return city;
    }

    public void setCity(CityDto city) {
	this.city = city;
    }

    public List<RoleDto> getRoles() {
	return roles;
    }

    public void setRoles(List<RoleDto> roles) {
	this.roles = roles;
    }

    public List<AddressDto> getAddresses() {
	return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
	this.addresses = addresses;
    }

    public AreaDto getHrArea() {
	return hrArea;
    }

    public void setHrArea(AreaDto hrArea) {
	this.hrArea = hrArea;
    }

    public AreaDto getManageArea() {
	return manageArea;
    }

    public void setManageArea(AreaDto manageArea) {
	this.manageArea = manageArea;
    }

    public RegionDto getManageRegion() {
	return manageRegion;
    }

    public void setManageRegion(RegionDto manageRegion) {
	this.manageRegion = manageRegion;
    }

    public EducationDto getEducation() {
	return education;
    }

    public void setEducation(EducationDto education) {
	this.education = education;
    }

    public DepartmentDto getDepartment() {
	return department;
    }

    public void setDepartment(DepartmentDto department) {
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
	UserDto other = (UserDto) obj;
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
