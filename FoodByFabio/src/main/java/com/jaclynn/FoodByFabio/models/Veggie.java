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
@Table(name="veggies")
public class Veggie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	
	//one veggie will belong to many different recipes
	@OneToMany(mappedBy="veggie", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Recipe> recipes;
	
	//one veggie can have many portion sizes
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "veggieportions",
			joinColumns = @JoinColumn(name = "veggie_id"),
			inverseJoinColumns = @JoinColumn(name = "portion_id")
			)

	private List<Portion> veggiePortions;
	
	public Veggie() {
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
	public List<Portion> getVeggiePortions() {
		return veggiePortions;
	}
	
	public void setPortions(List<Portion> veggiePortions) {
		this.veggiePortions = veggiePortions;
	}
	public List<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}