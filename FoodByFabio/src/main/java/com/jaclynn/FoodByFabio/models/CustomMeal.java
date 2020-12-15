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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="custommeals")
public class CustomMeal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private int quantity;
	@DecimalMin(value="0.01")
	private float price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //many ingredients will be found in many meals
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "custommealingredients",
    	joinColumns = @JoinColumn(name = "recipe_id"),
    	inverseJoinColumns = @JoinColumn(name = "custommeal_id")
    )
    private List<Recipe> ingredients;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "custommealorder",
    	joinColumns = @JoinColumn(name = "custommeal_id"),
    	inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;
    
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

	public List<Recipe> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Recipe> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
    
}