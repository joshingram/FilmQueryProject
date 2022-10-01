package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Inventory;

public interface DatabaseAccessor {
	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByKeyword(String keyword);

	public String getLanguage(int langID) throws SQLException;

	public String getCategory(int category) throws SQLException;

	public List<Inventory> getInventory(int filmId);

}
