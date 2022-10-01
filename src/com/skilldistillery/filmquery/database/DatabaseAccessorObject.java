package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.*;
import com.skilldistillery.filmquery.entities.*;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found, contact tech support");
		}
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// ...proof is left to reader

		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();

		if (filmResult.next()) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setYear(filmResult.getString("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("length"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			String plainLanguage = getLanguage(filmResult.getInt("language_id"));
			film.setPlainLanguage(plainLanguage);
			List <Actor> actors = findActorsByFilmId(filmResult.getInt("id"));
			film.setActors(actors);
			String category = getCategory(filmResult.getInt("id"));
			film.setCategory(category);
		}
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);
		// ...proof is left to reader

		String sql = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);

		ResultSet actorResult = stmt.executeQuery();

		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
		}
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id  WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setYear(rs.getString("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("length"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				String plainLanguage = getLanguage(rs.getInt("language_id"));
				film.setPlainLanguage(plainLanguage);
				List <Actor> actors = findActorsByFilmId(rs.getInt("id"));
				film.setActors(actors);
				String category = getCategory(rs.getInt("id"));
				film.setCategory(category);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}
	
	@Override
	public String getLanguage(int langID) throws SQLException {
		String plainLanguage = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT name FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langID);

		ResultSet langResult = stmt.executeQuery();

		if (langResult.next()) {
			plainLanguage = (langResult.getString("name"));
			
		}
		stmt.close();
		conn.close();
		return plainLanguage;
	}
	
	@Override
	public String getCategory(int category) throws SQLException {
		String cat = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT category.name FROM category JOIN film_category ON category.id = film_category.category_id JOIN film ON film.id = film_category.film_id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, category);

		ResultSet catResult = stmt.executeQuery();

		if (catResult.next()) {
			cat = (catResult.getString("name"));
			
		}
		stmt.close();
		conn.close();
		return cat;
	}
	
	@Override
	public List<Inventory> getInventory(int filmId) {
		List<Inventory> inventories = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, film_id, store_id, media_condition FROM inventory_item WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setId(rs.getInt("id"));
				inventory.setFilmId(rs.getInt("film_id"));
				inventory.setStoreId(rs.getInt("store_id"));
				inventory.setMediaCondition(rs.getString("media_condition"));
				
				inventories.add(inventory);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventories;
	}
}