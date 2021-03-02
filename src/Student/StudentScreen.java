package Student;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MainFrame.MainFrame;
import MainFrame.Login;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class StudentScreen extends JPanel {

	private MainFrame main;
	private ImageIcon img1;
	private int tempUserID;
	private String tempUsername;

	private JComboBox cbModule, cbTime;

	private String[] moduleArr = { "Object-oriented Programming", "Network Fundamental",
			"New Media Marketing Application" };
	private String[] timeArr = { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00",
			"12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00",
			"18:30", "19:00" };
	// private studentCheckIn checkIn;

	public StudentScreen(MainFrame mainFrame, int userID, String userName, String imageName, String imageType) {

		tempUserID = userID;
		tempUsername = userName;

		setBackground(new Color(192, 192, 192));
		this.main = mainFrame;
		setLayout(null);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBackground(new Color(192, 192, 192));
		lblTime.setBounds(16, 138, 52, 14);
		this.add(lblTime);

		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					DateFormat dateFormat = new SimpleDateFormat("HH:mm");
					String checkInTime = dateFormat.format(checkInClicked());

					Date checkInTimeDateFormat = dateFormat.parse(checkInTime);

					int moduleIndex = cbModule.getSelectedIndex();
					int timeIndex = cbTime.getSelectedIndex();

					DateFormat sdf = new SimpleDateFormat("HH:mm");
					Date lessonTime = sdf.parse(timeArr[timeIndex]);

					Student stud = new Student(lessonTime, checkInTimeDateFormat);

					String checkInSuccess = "User ID: " + tempUserID + "\nUsername: " + userName
							+ "\nLesson start time: " + cbTime.getSelectedItem() + "\nModule: "
							+ cbModule.getSelectedItem() + "\nAttendance status: " + stud.getAttendanceStatus()
							+ "\nYou have successfully checked in at " + checkInClicked();
					Login login = main.getController().datastorage.accList.get(tempUserID - 1);

					JOptionPane.showMessageDialog(null, checkInSuccess, "Check-in Success", JOptionPane.PLAIN_MESSAGE);

					if (moduleIndex == 0) {
						main.getController().setCheckInTime(tempUserID, userName, checkInTime,
								cbModule.getSelectedItem(), sdf.format(lessonTime), stud.getAttendanceStatus());
					} else if (moduleIndex == 1) {
						main.getController().setCheckInTime(tempUserID, userName, checkInTime,
								cbModule.getSelectedItem(), sdf.format(lessonTime), stud.getAttendanceStatus());
					} else if (moduleIndex == 2) {
						main.getController().setCheckInTime(tempUserID, userName, checkInTime,
								cbModule.getSelectedItem(), sdf.format(lessonTime), stud.getAttendanceStatus());
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		btnCheckIn.setBounds(79, 177, 92, 37);
		add(btnCheckIn);

		JLabel lblModule = new JLabel("Module:");
		lblModule.setBackground(new Color(192, 192, 192));
		lblModule.setBounds(16, 89, 56, 16);
		add(lblModule);

		this.cbModule = new JComboBox(this.moduleArr);
		this.cbModule.setToolTipText("");
		this.cbModule.setBounds(69, 86, 207, 22);
		add(cbModule);

		this.cbTime = new JComboBox(this.timeArr);
		this.cbTime.setBounds(69, 134, 207, 22);
		add(cbTime);

		JLabel lblSum = new JLabel("Summary:");
		lblSum.setBackground(new Color(192, 192, 192));
		lblSum.setBounds(16, 187, 77, 16);
		add(lblSum);

		JLabel lblNewLabel = new JLabel("Student Screen");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 330, 46);
		add(lblNewLabel);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new LogoutButtonListener());
		btnLogout.setBounds(184, 177, 92, 37);
		add(btnLogout);

		this.img1 = new ImageIcon("src/Images/" + imageName + "." + imageType);
		JLabel lblLabelBackground = new JLabel(this.img1);
		lblLabelBackground.setBounds(288, 89, 92, 125);
		add(lblLabelBackground);
	}

	public Date checkInClicked() {

		studentCheckIn checkIn = new studentCheckIn();
		Date dt = new Date();
		checkIn.setCheckInTime(dt);
		return dt;
	}

	private class LogoutButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			showLogin();
		}
	}

	private void showLogin() {
		this.main.showJLogin();
	}

}
