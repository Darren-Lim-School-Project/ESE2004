package Tutor;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MainFrame.MainFrame;
import Student.Student;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class tutorSearchStudentScreen extends JPanel {

	private JTextField txtStudentName;
	private JList jlAttendanceList;

	private MainFrame main;

	public tutorSearchStudentScreen(MainFrame mainFrame) {
		setBackground(new Color(192, 192, 192));
		this.main = mainFrame;
		setLayout(null);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setForeground(Color.BLACK);
		lblStudentName.setBounds(183, 313, 98, 14);
		add(lblStudentName);

		txtStudentName = new JTextField();
		txtStudentName.setText("");
		txtStudentName.setBounds(278, 310, 98, 20);
		add(txtStudentName);
		txtStudentName.setColumns(10);

		JButton btnStudentName = new JButton("Submit");
		btnStudentName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				displayList();

			}
		});
		btnStudentName.setBounds(183, 338, 194, 23);
		add(btnStudentName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 525, 275);
		add(scrollPane);

		jlAttendanceList = new JList();
		jlAttendanceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(this.jlAttendanceList);
		this.jlAttendanceList.addListSelectionListener(new DisplayListener());

		JButton btnLogout = new JButton("Return to Tutor Page");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				showTutor();

			}

		});
		btnLogout.setBounds(183, 372, 194, 23);
		add(btnLogout);
	}

	private class DisplayListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			displayName();
		}
	}

	private void displayName() {
		for (int i = 0; i < main.getController().datastorage.checkInList.size(); i++) {
			main.getController().datastorage.checkInList.get(i);
		}
	}

	private void displayList() {

		this.jlAttendanceList.setModel(new DefaultListModel());
		DefaultListModel model = new DefaultListModel();
		
		String noUsername = "Username not input, please try again!";
		
		Vector<Student> list = main.getController().datastorage.checkInList;

		if (txtStudentName.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, noUsername, "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {

			for (int i = 0; i < list.size(); i++) {
				Student stud = list.get(i);
				String name = txtStudentName.getText().trim();
				String fName = stud.getUserName();
				fName = fName.trim();
				
				if (fName.equals(name)) {
					model.addElement("Name: " + stud.getUserName());
					model.addElement("Module: " + stud.getModule());
					model.addElement("Lesson Start Time: " + stud.getLessonStartTime());
					model.addElement("Check In Time: " + stud.getCheckInTime());
					model.addElement("Attendance Status: " + stud.getAttendanceRecord());
					model.addElement("====================================");
					
				}

			}

			this.jlAttendanceList.setModel(model);

		}

	}

	private void showTutor() {
		this.main.showJTutor();
	}
}
