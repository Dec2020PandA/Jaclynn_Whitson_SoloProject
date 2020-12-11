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
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
        
    
    public List<QuickMeal> getQuickmeals() {
		return quickmeals;
	}

	public void setQuickmeals(List<QuickMeal> quickmeals) {
		this.quickmeals = quickmeals;
	}
	
	//many orders will have many random meals
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "randommealorder",
    	joinColumns = @JoinColumn(name = "order_id"),
    	inverseJoinColumns = @JoinColumn(name = "randommeal_id")
    )
    private List<RandomMeal> randomMeals;

	//many orders will have many quick meals
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "quickmealorder",
    	joinColumns = @JoinColumn(name = "order_id"),
    	inverseJoinColumns = @JoinColumn(name = "quickmeal_id")
    )
    private List<QuickMeal> quickmeals;
    
    //many orders will have one delivery address
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="deliveryaddress_id")
    private DeliveryAddress deliveryaddress;
    
    //many orders will have one pickup location
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pickuplocation_id")
    private PickupLocation pickuplocation;
    
    //many orders will belong to one user
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User customer;
    
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    @PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Order() {
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

	public DeliveryAddress getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(DeliveryAddress deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public PickupLocation getPickuplocation() {
		return pickuplocation;
	}

	public void setPickuplocation(PickupLocation pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}
    
    

}
