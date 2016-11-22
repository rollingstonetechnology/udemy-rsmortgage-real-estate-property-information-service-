package com.rollingstone.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "rsmortgage_background_check_order")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BackgroundCheckOrder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private boolean isCreditCheckOrdered;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "customer_since", unique = true, nullable = false, length = 10)
	Date	creditCheckOderedDate;
	
	@Column(nullable = false)
	private boolean isCriminalCheckOrder;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "customer_since", unique = true, nullable = false, length = 10)
	Date criminalCheckOderedDat;
	
	
	
	List<Address> pastYearsAddresses;
	
	public BackgroundCheckOrder(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCreditCheckOrdered() {
		return isCreditCheckOrdered;
	}

	public void setCreditCheckOrdered(boolean isCreditCheckOrdered) {
		this.isCreditCheckOrdered = isCreditCheckOrdered;
	}

	public Date getCreditCheckOderedDate() {
		return creditCheckOderedDate;
	}

	public void setCreditCheckOderedDate(Date creditCheckOderedDate) {
		this.creditCheckOderedDate = creditCheckOderedDate;
	}

	public boolean isCriminalCheckOrder() {
		return isCriminalCheckOrder;
	}

	public void setCriminalCheckOrder(boolean isCriminalCheckOrder) {
		this.isCriminalCheckOrder = isCriminalCheckOrder;
	}

	public Date getCriminalCheckOderedDat() {
		return criminalCheckOderedDat;
	}

	public void setCriminalCheckOderedDat(Date criminalCheckOderedDat) {
		this.criminalCheckOderedDat = criminalCheckOderedDat;
	}

	

	public List<Address> getPastYearsAddresses() {
		return pastYearsAddresses;
	}

	public void setPastYearsAddresses(List<Address> pastYearsAddresses) {
		this.pastYearsAddresses = pastYearsAddresses;
	}

	@Override
	public String toString() {
		return "BackgroundCheckOrder [id=" + id + ", isCreditCheckOrdered=" + isCreditCheckOrdered
				+ ", creditCheckOderedDate=" + creditCheckOderedDate + ", isCriminalCheckOrder=" + isCriminalCheckOrder
				+ ", criminalCheckOderedDat=" + criminalCheckOderedDat + ", creditScoreFExperian="
				+ ", pastYearsAddresses=" + pastYearsAddresses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCheckOderedDate == null) ? 0 : creditCheckOderedDate.hashCode());
		result = prime * result + ((criminalCheckOderedDat == null) ? 0 : criminalCheckOderedDat.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isCreditCheckOrdered ? 1231 : 1237);
		result = prime * result + (isCriminalCheckOrder ? 1231 : 1237);
		result = prime * result + ((pastYearsAddresses == null) ? 0 : pastYearsAddresses.hashCode());
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
		BackgroundCheckOrder other = (BackgroundCheckOrder) obj;
	
		if (creditCheckOderedDate == null) {
			if (other.creditCheckOderedDate != null)
				return false;
		} else if (!creditCheckOderedDate.equals(other.creditCheckOderedDate))
			return false;
		if (criminalCheckOderedDat == null) {
			if (other.criminalCheckOderedDat != null)
				return false;
		} else if (!criminalCheckOderedDat.equals(other.criminalCheckOderedDat))
			return false;
		if (id != other.id)
			return false;
		if (isCreditCheckOrdered != other.isCreditCheckOrdered)
			return false;
		if (isCriminalCheckOrder != other.isCriminalCheckOrder)
			return false;
		if (pastYearsAddresses == null) {
			if (other.pastYearsAddresses != null)
				return false;
		} else if (!pastYearsAddresses.equals(other.pastYearsAddresses))
			return false;
		return true;
	}

	public BackgroundCheckOrder(long id, boolean isCreditCheckOrdered, Date creditCheckOderedDate,
			boolean isCriminalCheckOrder, Date criminalCheckOderedDat, int creditScoreFExperian,
			int creditScoreFromTransunion, int creditScoreFromOthers, int averageCreditScore,
			List<Address> pastYearsAddresses) {
		super();
		this.id = id;
		this.isCreditCheckOrdered = isCreditCheckOrdered;
		this.creditCheckOderedDate = creditCheckOderedDate;
		this.isCriminalCheckOrder = isCriminalCheckOrder;
		this.criminalCheckOderedDat = criminalCheckOderedDat;
		this.pastYearsAddresses = pastYearsAddresses;
	}
	
	
}
