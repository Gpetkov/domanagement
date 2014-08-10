package com.realintelligence.domanagement.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "language")
    private String language;

    @Column(name = "postal_code")
    private Integer postalCode;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language;
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
	result = prime * result + ((language == null) ? 0 : language.hashCode());
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
	Country other = (Country) obj;
	if (language == null) {
	    if (other.language != null)
		return false;
	} else if (!language.equals(other.language))
	    return false;
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
