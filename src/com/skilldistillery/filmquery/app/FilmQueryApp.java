package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void test2() throws SQLException {
		Actor actor = db.findActorById(1);
		System.out.println(actor);
	}

	private void test3() {
		List<Actor> actors = db.findActorsByFilmId(1);
		System.out.println(actors);
	}

	private void launch() throws SQLException {
		System.out.println("Welcome to the Film Query App.");
		startUserInterface();

	}

	private void startUserInterface() throws SQLException {
		while (true) {
			Scanner kb = new Scanner(System.in);

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
					System.out.println("good bye");
					System.exit(0);
				default:
					System.out.println("invalid number, try again");
					kb.nextLine();

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, try again");

			}
// TODO fix this kb.close
			// kb.close();
		}
	}

	private void lookFilmById() throws SQLException {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.print("Please enter the film ID number: ");
		int filmChoice = kb.nextInt();

		Film film = db.findFilmById(filmChoice);

		if (film != null) {
			System.out.println("Result: " + film);
			System.out.println("Starring:");

			for (Actor castMember : film.getActors()) {
				System.out.println("\t" + castMember);
			}
		} else {
			System.out.println("No such film found, try again.");
			startUserInterface();
		}
		returnOrView(film);
	}

	private void lookFilmByKeyword() throws SQLException {
		Scanner kb = new Scanner(System.in);
		System.out.println();
		System.out.print("Please enter the keyword: ");
		String userKeyword = kb.next();

		List<Film> films = db.findFilmByKeyword(userKeyword);

		if (films.size() > 0) {
			for (Film film : films) {
				System.out.println("Result: " + film);
				System.out.println("Starring:");

				for (Actor castMember : film.getActors()) {
					System.out.println("\t" + castMember);
				}
			}returnOrView(films);
		} else {
			System.out.println("No results for that search found, try again.");
		}
	}

	private void returnOrView(Film film) throws SQLException {
		Scanner kb = new Scanner(System.in);
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
				break;
			default:
				System.out.println("Invalid choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid choice");
		}
	}
	
	private void returnOrView(List<Film> films) throws SQLException {
		Scanner kb = new Scanner(System.in);
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
				}
				break;
			default:
				System.out.println("Invalid choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid choice");
		}
	}
}
