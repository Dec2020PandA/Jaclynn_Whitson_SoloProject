package com.jaclynn.FoodByFabio.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="custommeals")
public class CustomMeal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String meat;
	@NotBlank
	private String meatPortion;
	@NotBlank
	private String carb;
	@NotBlank
	private String carbPortion;
	@NotBlank
	private String veggie;
	@NotBlank
	private String veggiePortion;
	@NotBlank
	private int quantity;
	@DecimalMin(value="0.01")
	private float price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    @PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public CustomMeal() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public String getMeatPortion() {
		return meatPortion;
	}

	public void setMeatPortion(String meatPortion) {
		this.meatPortion = meatPortion;
	}

	public String getCarb() {
		return carb;
	}

	public void setCarb(String carb) {
		this.carb = carb;
	}

	public String getCarbPortion() {
		return carbPortion;
	}

	public void setCarbPortion(String carbPortion) {
		this.carbPortion = carbPortion;
	}

	public String getVeggie() {
		return veggie;
	}

	public void setVeggie(String veggie) {
		this.veggie = veggie;
	}

	public String getVeggiePortion() {
		return veggiePortion;
	}

	public void setVeggiePortion(String veggiePortion) {
		this.veggiePortion = veggiePortion;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
}
