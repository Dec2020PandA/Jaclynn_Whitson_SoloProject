package com.jaclynn.FoodByFabio.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="carbs")
public class Carb {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	
	//one meat will belong to many different recipes
	@OneToMany(mappedBy="carb", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Recipe> recipes;
	
	
	//Many carb can have many portion sizes
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "carbportions",
			joinColumns = @JoinColumn(name = "carb_id"),
			inverseJoinColumns = @JoinColumn(name = "portion_id")
			)
	private List<Portion> portions;
	
	public Carb() {
		super();
	}


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


	public List<Portion> getPortions() {
		return portions;
	}


	public void setPortions(List<Portion> portions) {
		this.portions = portions;
	}


	public List<Recipe> getRecipes() {
		return recipes;
	}


	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
	
}
