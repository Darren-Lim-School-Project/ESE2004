package StudentAttendanceSystem;

import java.util.Date;

import MainFrame.Login;
import Student.Module;
import Student.Student;
import Tutor.Tutor;

public class Controller {

	public DataStorage datastorage;

	public Controller() {
		this.datastorage = new DataStorage();
	}

	public DataStorage getDatastorage() {
		return datastorage;
	}

	public void setDatastorage(DataStorage datastorage) {
		this.datastorage = datastorage;
	}
	
	public Date getCheckInTime() {
		
		
		
		return null;
		
	}
	
	public void setCheckInTime(int userID, String userName, String time, Object module, String lessonTime, String attendanceStatus) {
		this.datastorage.setCheckInTime(userID, userName, time, module, lessonTime, attendanceStatus);
	}
	
	public Login checkPassword(String username, String password) {
		return this.datastorage.checkPassword(username, password);
		
	}
	
	public boolean checkStudent(String username, String password) {
		
		return this.datastorage.isStudent(username, password);
	}

	public boolean loginAccount(Student s, String u, Module m, String p, Tutor t) {

		return false;
	}

	public boolean captureLoginTimestamp(int as, String san, int id, String n, String ts) {

		return false;
	}

	public boolean viewSelectedStudentProfile(String d, String tan) {

		return false;
	}

	public boolean CaptureStudentID(int as, String san, String ts, int id, String n) {

		return false;
	}

	public boolean trackStudents(String tan, String d) {

		return false;
	}

}
