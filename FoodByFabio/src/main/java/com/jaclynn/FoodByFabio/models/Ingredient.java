package com.jaclynn.FoodByFabio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ingredients")
public class Ingredient {
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
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "custommealingredients",
    	joinColumns = @JoinColumn(name = "custommeal_id"),
    	inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<CustomMeal> customMeals;
    
    //many ingredients will be found in many meals
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "randommealingredients",
    	joinColumns = @JoinColumn(name = "ingredient_id"),
    	inverseJoinColumns = @JoinColumn(name = "randommeal_id")
    )
    private List<RandomMeal> randomMeals;
    
    
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    @PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Ingredient() {
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

	public List<CustomMeal> getCustomMeals() {
		return customMeals;
	}

	public void setCustomMeals(List<CustomMeal> customMeals) {
		this.customMeals = customMeals;
	}

	public List<RandomMeal> getRandomMeals() {
		return randomMeals;
	}

	public void setRandomMeals(List<RandomMeal> randomMeals) {
		this.randomMeals = randomMeals;
	}
    
    
	
}
