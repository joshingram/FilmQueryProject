package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

	private int id;
	private String title;
	private String description;
	private String year;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private String plainLanguage;
	private String category;

	public Film() {
	}

	public Film(int id, String title, String description, String year, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors, String plainLanguage, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.year = year;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
		this.plainLanguage = plainLanguage;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getPlainLanguage() {
		return plainLanguage;
	}

	public void setPlainLanguage(String plainLanguage) {
		this.plainLanguage = plainLanguage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return title + ", " + year + ", " + rating + "\n\t" + description + " " + plainLanguage;
	}

	public String toStringLong() {
		return "Film: " + id + " " + title + ", CATEGORY: " + category + ", " + description
				+ "\n\t" + year + ", language id: " + languageId + ", rentalDuration: " + rentalDuration
				+ ", rentalRate: " + rentalRate + ", length: " + length + ", replacementCost: " + replacementCost
				+ ", " + rating + ", specialFeatures: " + specialFeatures + ",  " + plainLanguage + " \n\tstarring: " + actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, languageId, length, rating, rentalDuration, rentalRate, replacementCost,
				specialFeatures, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating)
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title)
				&& Objects.equals(year, other.year);
	}

}
