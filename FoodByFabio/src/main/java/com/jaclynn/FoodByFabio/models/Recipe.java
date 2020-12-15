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
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //many recipes will have one meat
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="meat_id")
    private Meat meat;
    
    //many recipes will have one carb
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="carb_id")
    private Carb carb;
    
    //many recipes will have one veggie
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="veggie_id")
    private Veggie veggie;
    
    
    //many ingredients will be found in many meals
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "randommealingredients",
    	joinColumns = @JoinColumn(name = "recipe_id"),
    	inverseJoinColumns = @JoinColumn(name = "randommeal_id")
    )
    private List<RandomMeal> randomMeals;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "custommealingredients",
    	joinColumns = @JoinColumn(name = "custommeal_id"),
    	inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<CustomMeal> customMeals;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    @PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Recipe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Meat getMeat() {
		return meat;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public Carb getCarb() {
		return carb;
	}

	public void setCarb(Carb carb) {
		this.carb = carb;
	}

	public Veggie getVeggie() {
		return veggie;
	}

	public void setVeggie(Veggie veggie) {
		this.veggie = veggie;
	}
    
    
	
}