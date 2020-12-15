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
@Table(name="quickmeals")
public class QuickMeal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	private String description;
	@DecimalMin(value="0.01")
	private float price;
	//private int quantity;
	private String image_url;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Many meals can be on many orders
   @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "quickmealorder",
    	joinColumns = @JoinColumn(name = "quickmeal_id"),
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

         


	public QuickMeal() {
		super();
	}

	public QuickMeal(@NotBlank String name, String description, @DecimalMin("0.01") float price, 
			String image_url) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image_url = image_url;
	}

	/*public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/*public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}*/
    
    
	
	

}
