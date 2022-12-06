package menu.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import db.setup.DB;
import menu.calendar.CalendarGUI;
import menu.edit.EditController;
import menu.edit.EditGUI;

public class MainGUI extends JFrame {
	private JPanel panel;
	private JButton editButton;
	private JButton displayButton;
	private JButton exitButton;
	private DB db;
	private User user;
	private String username;
	
	public MainGUI(DB db, int userID, String un) {
		super("Main Menu");
		this.db = db;
		this.user = new User(userID, db);
		this.username = un;
		
		setSize(600, 300);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.white);
		add(new JLabel("<HTML><center>Welcome to the Main Menu " + un + "<BR>Please select Edit to edit your calendar,"
						+ " Display to display your calendar, or Exit to exit the Main Menu</center><HTML>"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}
	
	public void buildGUI() {
		panel = new JPanel();
		panel.setBounds(600, 600, 600, 600);
		panel.setBackground(Color.white);
		
		editButton = new JButton("Edit");
		editButton.setBounds(500, 1000, 80, 30);
		editButton.setBackground(Color.orange);
		editButton.addActionListener(new ActionPerformed());
		
		displayButton = new JButton("Display");
		displayButton.setBounds(1000, 1000, 80, 30);
		displayButton.setBackground(Color.green);
		displayButton.addActionListener(new ActionPerformed());
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(1500, 1000, 80, 30);
		exitButton.setBackground(Color.red);
		exitButton.addActionListener(new ActionPerformed());
		
		panel.add(editButton);
		panel.add(displayButton);
		panel.add(exitButton);
		
		add(panel);
	}
	
	// ActionPerformed class to implement button actions
	public class ActionPerformed implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) (e.getSource());		// Gets user input if button is pressed
			if(source.equals(editButton)) {		// Calls handleRegister if Register is pressed
				handleEdit();
			}
			else if(source.equals(displayButton)) {	// Calls handleLogin if Login is pressed
				handleDisplay();
			}
			else if(source.equals(exitButton)) {
				handleExit();
			}
		}
		
		private void handleEdit() {
			Scanner input = new Scanner(System.in);
			EditController editController = new EditController(user, db, input);
			EditGUI edit = new EditGUI("Edit Menu", editController);
		}
		
		private void handleDisplay() {
			CalendarGUI calendar = new CalendarGUI();
		}
		
		private void handleExit() {
			dispose();
		}
	}
}
