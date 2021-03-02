package Student;

import java.util.Date;

import MainFrame.Login;

public class Student {

	private String attendanceRecord;
	private String name;
	private Date loginTimeStamp;
	private Date lessonTime;
	private String lessonStartTime;
	public Login login;
	private int studentID;
	private String studentAdminNo;
	private Object module;
	
	private String userName;
	private int userID;
	private String checkInTime;
	
	public Student(int userID, String userName, String time, Object module, String lessonTime, String attendanceStatus) {
		this.userID = userID;
		
		this.userName = userName;
		
		this.checkInTime = time;
		
		this.setModule(module);
		
		this.lessonStartTime = lessonTime;
		
		this.attendanceRecord = attendanceStatus;
		
	}

	public String getAttendanceRecord() {
		return attendanceRecord;
	}

	public void setAttendanceRecord(String attendanceRecord) {
		this.attendanceRecord = attendanceRecord;
	}

	public String getLessonStartTime() {
		return lessonStartTime;
	}

	public void setLessonStartTime(String lessonStartTime) {
		this.lessonStartTime = lessonStartTime;
	}

	public Student(Date lessonTime, Date checkInTime) {
		this.lessonTime = lessonTime;
		this.loginTimeStamp = checkInTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getAttendanceStatus() {
		
		if(loginTimeStamp.after(lessonTime)) {
			return "Late";
		} else {
			return "Present";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLoginTimeStamp() {
		return loginTimeStamp;
	}

	public void setLoginTimeStamp(Date loginTimeStamp) {
		this.loginTimeStamp = loginTimeStamp;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentAdminNo() {
		return studentAdminNo;
	}

	public void setStudentAdminNo(String studentAdminNo) {
		this.studentAdminNo = studentAdminNo;
	}

	public Date getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(Date lessonTime) {
		this.lessonTime = lessonTime;
	}

	public Object getModule() {
		return module;
	}

	public void setModule(Object module) {
		this.module = module;
	}

}
