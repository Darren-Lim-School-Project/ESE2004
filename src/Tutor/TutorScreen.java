package Tutor;

import java.awt.Color; 

import javax.swing.JPanel;

import MainFrame.MainFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TutorScreen extends JPanel {
	
	private MainFrame main;

	public TutorScreen(MainFrame mainFrame) {
		
		setBackground(new Color(192, 192, 192));
		this.main = mainFrame;
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Tutor Page");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(10, 28, 345, 36);
		add(lblWelcome);
		
		JButton btnView = new JButton("View Student Attendance");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJView();
			}
		});
		btnView.setBounds(10, 134, 181, 30);
		add(btnView);
		
		JButton btnSearch = new JButton("Search Student");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showJSearch();
			}
		});
		btnSearch.setBounds(201, 134, 125, 30);
		add(btnSearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showLogin();
			}
		});
		btnLogout.setBounds(135, 196, 89, 23);
		add(btnLogout);
	}
	
	private void showJSearch() {
		
		this.main.showJSearch();
		
	}

	private void showJView() {
		
		this.main.showJView();
		
	}

	private void showLogin() {
		
		this.main.showJLogin();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
