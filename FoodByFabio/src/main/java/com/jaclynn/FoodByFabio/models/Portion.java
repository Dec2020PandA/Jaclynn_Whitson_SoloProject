package com.jaclynn.FoodByFabio.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="portions")
public class Portion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private Float measurement;
	@NotBlank
	private String unit;
	
	//Many portion will be on many veggies
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "veggieportions",
			joinColumns = @JoinColumn(name = "portion_id"),
			inverseJoinColumns = @JoinColumn(name = "veggie_id")
			)
	private List<Veggie> veggie;
	
	//many portion sizes are available to many meats
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "meatportions",
			joinColumns = @JoinColumn(name = "portion_id"),
			inverseJoinColumns = @JoinColumn(name = "meat_id")
			)
	private List<Meat> meats;
	
	//many portions will be on many carbs
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "carbportions",
			joinColumns = @JoinColumn(name = "portion_id"),
			inverseJoinColumns = @JoinColumn(name = "carb_id")
			)
	private List<Carb> carb;
	
	public Portion() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Float getMeasurement() {
		return measurement;
	}


	public void setMeasurement(Float measurement) {
		this.measurement = measurement;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public List<Veggie> getVeggie() {
		return veggie;
	}


	public void setVeggie(List<Veggie> veggie) {
		this.veggie = veggie;
	}


	public List<Meat> getMeats() {
		return meats;
	}


	public void setMeats(List<Meat> meats) {
		this.meats = meats;
	}


	public List<Carb> getCarb() {
		return carb;
	}


	public void setCarb(List<Carb> carb) {
		this.carb = carb;
	}


	
	
	
}
