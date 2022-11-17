package menu.main;
import menu.edit.EditController;
import menu.calendar.CalendarController;

import java.util.Scanner;

import db.setup.DB;

public class MainController {
	private EditController editController;
	private CalendarController calendarController;
	private User user;
	private Scanner input;
	public MainController(Scanner input) {
		this.input = input;
	}
	
	public void menu(int userID, DB db) {
		this.user = new User(userID, db);
		this.editController = new EditController(this.user, db, input);
		this.calendarController = new CalendarController(this.user, db, input);
		String option = "";
		while(true) {
			System.out.println("Welcome to the Main Menu!");
			System.out.println("Would you like to Exit or View/Edit your Calendar? Enter 'Exit', 'View', or 'Edit':");
			option = input.nextLine();
			if(option.equals("View")) {
				// Update calendar
				this.user.updateCalendar(db);
				this.calendarController.menu();
			}
			else if(option.equals("Edit")) {
				this.editController.menu();
			}
			else if(option.equals("Exit")) {
				break;
			}
			else {
				System.out.println("Invalid input, please try again");
			}
		}
	
	}
	public EditController getEditController() {
		return editController;
	}

	public void setEditController(EditController editController) {
		this.editController = editController;
	}

	public CalendarController getCalendarController() {
		return calendarController;
	}

	public void setCalendarController(CalendarController calendarController) {
		this.calendarController = calendarController;
	}
	
}
