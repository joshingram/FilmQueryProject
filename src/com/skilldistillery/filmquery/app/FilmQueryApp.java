package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.*;

import com.skilldistillery.filmquery.database.*;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {
	private Scanner kb = new Scanner(System.in);
	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() throws SQLException {
		System.out.println("Welcome to the Film Query App.");
		startUserInterface();
	}

	private void startUserInterface() throws SQLException {
		while (true) {
			System.out.println();
			System.out.println("Please choose from the following:");
			System.out.println("1. Look up a film by ID number");
			System.out.println("2. Look up a film by keyword search");
			System.out.println("3. Exit");

			try {
				int input = kb.nextInt();
				switch (input) {
				case 1:
					lookFilmById();
					break;
				case 2:
					lookFilmByKeyword();
					break;
				case 3:
					System.out.println("--== GOOD BYE ==--");
					System.exit(0);
				default:
					System.out.println("Invalid number, try again");
					kb.nextLine();

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid entry, try again");

			}
		}
	}

	private void lookFilmById() throws SQLException {
		System.out.println();
		System.out.print("Please enter the film ID number: ");
		int filmChoice = kb.nextInt();

		Film film = db.findFilmById(filmChoice);

		if (film != null) {
			System.out.println("Result: " + film);
			System.out.println("\tStarring:");

			for (Actor castMember : film.getActors()) {
				System.out.println("\t\t" + castMember);
			}
			returnOrView(film);
		} else {
			System.out.println("No such film found, try again.");
		}
	}

	private void lookFilmByKeyword() throws SQLException {
		System.out.println();
		System.out.print("Please enter the keyword: ");
		String userKeyword = kb.next();

		List<Film> films = db.findFilmByKeyword(userKeyword);

		if (films.size() > 0) {
			for (Film film : films) {
				System.out.println("Result: " + film);
				System.out.println("\tStarring:");

				for (Actor castMember : film.getActors()) {
					System.out.println("\t\t" + castMember);
				}
			}
			returnOrView(films);
		} else {
			System.out.println("No results for that search found, try again.");
		}
	}

	// Overloaded method for a single film
	private void returnOrView(Film film) throws SQLException {
		System.out.println("Would you like to:");
		System.out.println("1) Return to main menu");
		System.out.println("2) View all film details");
		try {
			int userChoice = kb.nextInt();

			switch (userChoice) {
			case 1:
				startUserInterface();
				break;
			case 2:
				System.out.println(film.toStringLong());
				DatabaseAccessorObject dao = new DatabaseAccessorObject();
				List<Inventory> inventories = dao.getInventory(film.getId());
				for (Inventory inventory : inventories) {
					System.out.println(inventory);
				}
				break;
			default:
				System.out.println("Invalid number choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry");
		}
	}

	// Overloaded method for a list of films
	private void returnOrView(List<Film> films) throws SQLException {
		System.out.println("Would you like to:");
		System.out.println("1) Return to main menu");
		System.out.println("2) View all film details");
		try {
			int userChoice = kb.nextInt();

			switch (userChoice) {
			case 1:
				startUserInterface();
				break;
			case 2:
				for (Film film : films) {
					System.out.println(film.toStringLong());
					DatabaseAccessorObject dao = new DatabaseAccessorObject();
					List<Inventory> inventories = dao.getInventory(film.getId());
					for (Inventory inventory : inventories) {
						System.out.println(inventory);
					}
				}
				break;
			default:
				System.out.println("Invalid number choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry");
		}
	}
}
