package StudentAttendanceSystem;

import java.util.Vector;
import MainFrame.Login;
import Student.Student;
import Tutor.Tutor;

public class DataStorage {
	public Vector<Login> accList;
	public Vector<Student> checkInList;
	
	private Login log;

	public DataStorage() {
		this.accList = new Vector<Login>();
		this.checkInList = new Vector<Student>();

		Login arr1 = new Login(1, "Zacus", "123", true, "Zacus", "jpg");
		Login arr2 = new Login(2, "Darren", "1234", false, "Darren", "jpg");
		Login arr3 = new Login(3, "Peter", "12345", false, "Zacus", "jpg");
		Login arr4 = new Login(4, "Alex", "12345", true, "Alex", "jpg");
		Login arr5 = new Login(5, "John", "1234", true, "Zacus", "jpg");
		Login arr6 = new Login(6, "Harrod", "123", true, "Darren", "jpg");
		this.accList.add(arr1);
		this.accList.add(arr2);
		this.accList.add(arr3);
		this.accList.add(arr4);
		this.accList.add(arr5);
		this.accList.add(arr6);
	}
	
	public void setCheckInTime(int userID, String userName, String time, Object module, String lessonTime, String attendanceStatus) {
		Student l = new Student(userID, userName, time, module, lessonTime, attendanceStatus);
		this.checkInList.addElement(l);
	}
	
	public Login checkPassword(String userName, String passWord) {
		for (int i = 0; i < this.accList.size(); i++) {
			//System.out.println("DataStorage.accList.size(): " + this.accList.size());
			Login temp = this.accList.get(i);
			if (temp.getTempUsername().equals(userName) && temp.getTempPassword().equals(passWord)) {
				
				temp.setUsername(userName);
				return temp;
			}
		}
		return null;
	}
	
	public boolean isStudent(String userName, String passWord) {
		for (int i = 0; i < this.accList.size(); i++) {
			Login temp = this.accList.get(i);
			if (temp.getTempUsername().equals(userName) && temp.getTempPassword().equals(passWord) && temp.getTempIsStudent().equals(true)) {
				return true;
			}
		}
		return false;
	}
	
	public Student[] getAllStudents() {
		
		Student[] studentArr = new Student[checkInList.size()];
		checkInList.toArray(studentArr);
		
		return studentArr;
	}
	

	public boolean storeStudentID(Student s) {

		return false;
	}

	public boolean storeLoginTimestamp(Student s) {

		return false;
	}

	public boolean storeStudents(Tutor t) {

		return false;
	}

	public boolean storeLogin(Login l) {

		return false;
	}

	public boolean storeStudentProfile(Tutor t) {

		return false;
	}

}
