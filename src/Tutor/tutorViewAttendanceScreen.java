package Tutor;

import javax.swing.DefaultListModel; 
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MainFrame.Login;
import MainFrame.MainFrame;
import Student.Student;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class tutorViewAttendanceScreen extends JPanel {
	private JList jlName;
	private JList jlAttendanceList;

	private MainFrame main;

	public tutorViewAttendanceScreen(MainFrame mainFrame) {
		setBackground(new Color(192, 192, 192));
		this.main = mainFrame;
		setLayout(null);

		JButton btnStudentName = new JButton("Refresh");
		btnStudentName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				displayList();

			}
		});
		btnStudentName.setBounds(61, 372, 144, 23);
		add(btnStudentName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 260, 350);
		add(scrollPane);

		jlName = new JList();
		jlName.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(this.jlName);
		this.jlName.addListSelectionListener(new DisplayListener());

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(285, 11, 260, 350);
		add(scrollPane1);

		jlAttendanceList = new JList();
		jlAttendanceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane1.setViewportView(this.jlAttendanceList);

		JButton btnLogout = new JButton("Return to Tutor Page");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTutor();
			}
		});
		btnLogout.setBounds(328, 372, 176, 23);
		add(btnLogout);

		displayList();
	}

	private class DisplayListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {

			jlAttendanceList.setModel(new DefaultListModel());
			DefaultListModel model = new DefaultListModel();
			Vector<Student> list = main.getController().datastorage.checkInList;
			int index = jlName.getSelectedIndex();

			if (index > -1) {
				String vName = main.getController().datastorage.accList.get(index).getTempUsername();

				for (int i = 0; i < main.getController().datastorage.checkInList.size(); i++) {
					Student stud = list.get(i);
					String vStudent = main.getController().datastorage.checkInList.get(i).getUserName();

					if (vName.equals(vStudent)) {

						model.addElement("Name: " + stud.getUserName());
						model.addElement("Module: " + stud.getModule());
						model.addElement("Lesson Start Time: " + stud.getLessonStartTime());
						model.addElement("Check In Time: " + stud.getCheckInTime());
						model.addElement("Attendance Status: " + stud.getAttendanceRecord());
						model.addElement("====================================");
					}
				}
				jlAttendanceList.setModel(model);
			}
		}
	}

	private void displayList() {

		DefaultListModel model = new DefaultListModel();

		Vector<Login> list = main.getController().datastorage.accList;
		for (int i = 0; i < main.getController().datastorage.accList.size(); i++) {
			Login log = list.get(i);

			model.addElement(log.getTempUsername());
		}
		this.jlName.setModel(model);

	}

	private void showTutor() {
		this.main.showJTutor();
	}
}
