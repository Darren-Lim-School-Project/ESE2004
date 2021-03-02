package MainFrame;

import java.awt.CardLayout; 

import javax.swing.JFrame;

import Student.Student;
import Student.StudentScreen;
import StudentAttendanceSystem.Controller;
import Tutor.Tutor;
import Tutor.TutorScreen;
import Tutor.tutorSearchStudentScreen;
import Tutor.tutorViewAttendanceScreen;

public class MainFrame extends JFrame {

	private CardLayout card;
	private Controller cont;

	public MainFrame() {
		this.cont = new Controller();
		this.setTitle("Attendance Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.card = new CardLayout();
		this.setLayout(this.card);
		this.showJLogin();
		this.setVisible(true);
	}

	public void showJLogin() {
		this.setSize(350, 350);
		LoginScreen login = new LoginScreen(this);
		this.add(login, "Login1");
		this.card.show(this.getContentPane(), "Login1");
	}

	public void showJStudent(int userID, String userName, String imageName, String imageType) {
		this.setSize(450, 300);
		StudentScreen student = new StudentScreen(this, userID, userName, imageName, imageType);
		this.add(student, "Student1");
		this.card.show(this.getContentPane(), "Student1");
	}

	public void showJTutor() {
		this.setSize(365, 350);
		TutorScreen tutor = new TutorScreen(this);
		this.add(tutor, "Tutor1");
		this.card.show(this.getContentPane(), "Tutor1");
	}
	
	public void showJView() {
		this.setSize(565, 450);
		tutorViewAttendanceScreen view = new tutorViewAttendanceScreen(this);
		this.add(view, "View1");
		this.card.show(this.getContentPane(), "View1");
	}
	
	public void showJSearch() {
		this.setSize(565, 450);
		tutorSearchStudentScreen search = new tutorSearchStudentScreen(this);
		this.add(search, "Search1");
		this.card.show(this.getContentPane(), "Search1");
	}

	public Controller getController() {
		return this.cont;
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}

}
