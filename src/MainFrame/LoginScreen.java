package MainFrame;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Student.Module;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class LoginScreen extends JPanel {

	public String password;
	public Module module;
	public String username;

	private JLabel lblUsername;
	private JTextField txtUsername;

	private ImageIcon img1;
	private MainFrame main;
	private JPasswordField txtPassword;

	public LoginScreen(MainFrame mainFrame) {

		setBackground(new Color(192, 192, 192));
		this.main = mainFrame;
		setLayout(null);

		lblUsername = new JLabel("Username:");
		lblUsername.setBackground(new Color(192, 192, 192));
		lblUsername.setBounds(56, 134, 64, 14);
		add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBackground(new Color(192, 192, 192));
		lblPassword.setBounds(56, 165, 64, 14);
		add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(136, 131, 125, 20);
		add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(56, 205, 89, 23);
		btnLogin.addActionListener(new LoginButtonListener());
		add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(172, 205, 89, 23);
		btnCancel.addActionListener(new CancelButtonListener());
		add(btnCancel);

		JLabel lblHeader = new JLabel("Please login your account");
		lblHeader.setForeground(Color.RED);
		lblHeader.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(10, 25, 300, 75);
		add(lblHeader);

		this.img1 = new ImageIcon("src/Images/Pikachu1.jpg");
		JLabel label = new JLabel(this.img1);
		label.setBounds(0, 0, 350, 100);
		add(label);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(136, 161, 125, 22);
		add(txtPassword);
	}

	private class LoginButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String password = new String(txtPassword.getPassword());

			String userPassError = "Username and Password not input!";
			String userPassWrong = "Username and Password is wrong!";

			if (txtUsername.getText().isEmpty() || txtPassword.getPassword().length < 1) {
				JOptionPane.showMessageDialog(null, userPassError, "ERROR", JOptionPane.ERROR_MESSAGE);
				
			} else {
				username = txtUsername.getText();

				Login checkPassword = main.getController().checkPassword(username, password);

				if (checkPassword != null) {
					boolean checkStudent = main.getController().checkStudent(username, password);
					if (checkStudent) {

						int userID = checkPassword.getUserID();
						String userName = checkPassword.getUsername();
						String imageName = checkPassword.getImageName();
						String imageType = checkPassword.getImageType();
								
						showStudent(userID, userName, imageName, imageType);
					} else {
						showTutor();
					}
				} else {
					JOptionPane.showMessageDialog(null, userPassWrong, "ERROR", JOptionPane.ERROR_MESSAGE);
					txtUsername.setText("");
					txtPassword.setText("");
				}

			}
		}
	}

	private class CancelButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}
	}

	private void showStudent(int userID, String userName, String imageName, String imageType) {
		this.main.showJStudent(userID, userName, imageName, imageType);
	}

	private void showTutor() {
		this.main.showJTutor();
	}
}
