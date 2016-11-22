package com.rollingstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * A User POJO serving as an Entity as well as a Data Transfer Object i.e DTO
 */
@Entity
@Table(name = "rsmortgage_account")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RealEstateProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="account_type_id")
	private PropertyType propertyType;
	
	@Column(nullable = false)
	private int yearBuilt;
	
	@Column(nullable = false)
	private double currentPrice;
	
	@Column(nullable = false)
	private float currentTax;
	
	@Column(nullable = false)
	private String ownerName;
	
	@Column(nullable = false)
	private String ownerPhone;
	
	@Column(nullable = false)
	private String ownerEmail;
	
	@Column(nullable = false)
	private boolean isFullyOwned;
	
	@Column(nullable = false)
	private boolean isDamaged;
	
	@Column(nullable = false)
	private boolean isForeClosed;
	
	@Column(nullable = false)
	private String currentLender;
	
	@OneToOne
	@JoinColumn(name="property_address_id")
	private Address ownerAddress;
	
	@OneToOne
	@JoinColumn(name="property_address_id")
	private Address propertyAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getCurrentTax() {
		return currentTax;
	}

	public void setCurrentTax(float currentTax) {
		this.currentTax = currentTax;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public boolean isFullyOwned() {
		return isFullyOwned;
	}

	public void setFullyOwned(boolean isFullyOwned) {
		this.isFullyOwned = isFullyOwned;
	}

	public boolean isDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}

	public boolean isForeClosed() {
		return isForeClosed;
	}

	public void setForeClosed(boolean isForeClosed) {
		this.isForeClosed = isForeClosed;
	}

	public String getCurrentLender() {
		return currentLender;
	}

	public void setCurrentLender(String currentLender) {
		this.currentLender = currentLender;
	}

	public Address getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(Address ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public Address getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(Address propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	@Override
	public String toString() {
		return "RealEstateProperty [id=" + id + ", propertyType=" + propertyType + ", yearBuilt=" + yearBuilt
				+ ", currentPrice=" + currentPrice + ", currentTax=" + currentTax + ", ownerName=" + ownerName
				+ ", ownerPhone=" + ownerPhone + ", ownerEmail=" + ownerEmail + ", isFullyOwned=" + isFullyOwned
				+ ", isDamaged=" + isDamaged + ", isForeClosed=" + isForeClosed + ", currentLender=" + currentLender
				+ ", ownerAddress=" + ownerAddress + ", propertyAddress=" + propertyAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentLender == null) ? 0 : currentLender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(currentTax);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isDamaged ? 1231 : 1237);
		result = prime * result + (isForeClosed ? 1231 : 1237);
		result = prime * result + (isFullyOwned ? 1231 : 1237);
		result = prime * result + ((ownerAddress == null) ? 0 : ownerAddress.hashCode());
		result = prime * result + ((ownerEmail == null) ? 0 : ownerEmail.hashCode());
		result = prime * result + ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ((ownerPhone == null) ? 0 : ownerPhone.hashCode());
		result = prime * result + ((propertyAddress == null) ? 0 : propertyAddress.hashCode());
		result = prime * result + ((propertyType == null) ? 0 : propertyType.hashCode());
		result = prime * result + yearBuilt;
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
		RealEstateProperty other = (RealEstateProperty) obj;
		if (currentLender == null) {
			if (other.currentLender != null)
				return false;
		} else if (!currentLender.equals(other.currentLender))
			return false;
		if (Double.doubleToLongBits(currentPrice) != Double.doubleToLongBits(other.currentPrice))
			return false;
		if (Float.floatToIntBits(currentTax) != Float.floatToIntBits(other.currentTax))
			return false;
		if (id != other.id)
			return false;
		if (isDamaged != other.isDamaged)
			return false;
		if (isForeClosed != other.isForeClosed)
			return false;
		if (isFullyOwned != other.isFullyOwned)
			return false;
		if (ownerAddress == null) {
			if (other.ownerAddress != null)
				return false;
		} else if (!ownerAddress.equals(other.ownerAddress))
			return false;
		if (ownerEmail == null) {
			if (other.ownerEmail != null)
				return false;
		} else if (!ownerEmail.equals(other.ownerEmail))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (ownerPhone == null) {
			if (other.ownerPhone != null)
				return false;
		} else if (!ownerPhone.equals(other.ownerPhone))
			return false;
		if (propertyAddress == null) {
			if (other.propertyAddress != null)
				return false;
		} else if (!propertyAddress.equals(other.propertyAddress))
			return false;
		if (propertyType == null) {
			if (other.propertyType != null)
				return false;
		} else if (!propertyType.equals(other.propertyType))
			return false;
		if (yearBuilt != other.yearBuilt)
			return false;
		return true;
	}

	public RealEstateProperty(long id, PropertyType propertyType, int yearBuilt, double currentPrice, float currentTax,
			String ownerName, String ownerPhone, String ownerEmail, boolean isFullyOwned, boolean isDamaged,
			boolean isForeClosed, String currentLender, Address ownerAddress, Address propertyAddress) {
		super();
		this.id = id;
		this.propertyType = propertyType;
		this.yearBuilt = yearBuilt;
		this.currentPrice = currentPrice;
		this.currentTax = currentTax;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerEmail = ownerEmail;
		this.isFullyOwned = isFullyOwned;
		this.isDamaged = isDamaged;
		this.isForeClosed = isForeClosed;
		this.currentLender = currentLender;
		this.ownerAddress = ownerAddress;
		this.propertyAddress = propertyAddress;
	}
	
	
}
